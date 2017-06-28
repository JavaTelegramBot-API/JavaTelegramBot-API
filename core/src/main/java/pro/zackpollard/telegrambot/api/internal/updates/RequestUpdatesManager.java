package pro.zackpollard.telegrambot.api.internal.updates;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.inline.GameInlineCallbackQuery;
import pro.zackpollard.telegrambot.api.chat.inline.InlineCallbackQuery;
import pro.zackpollard.telegrambot.api.chat.message.GameMessageCallbackQuery;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.MessageCallbackQuery;
import pro.zackpollard.telegrambot.api.chat.message.content.TextContent;
import pro.zackpollard.telegrambot.api.event.Event;
import pro.zackpollard.telegrambot.api.event.chat.*;
import pro.zackpollard.telegrambot.api.event.chat.game.GameInlineCallbackQueryReceivedEvent;
import pro.zackpollard.telegrambot.api.event.chat.game.GameMessageCallbackQueryReceivedEvent;
import pro.zackpollard.telegrambot.api.event.chat.inline.InlineCallbackQueryReceivedEvent;
import pro.zackpollard.telegrambot.api.event.chat.inline.InlineQueryReceivedEvent;
import pro.zackpollard.telegrambot.api.event.chat.inline.InlineResultChosenEvent;
import pro.zackpollard.telegrambot.api.event.chat.message.*;
import pro.zackpollard.telegrambot.api.extensions.Extensions;
import pro.zackpollard.telegrambot.api.internal.event.ListenerRegistryImpl;
import pro.zackpollard.telegrambot.api.updates.Update;
import pro.zackpollard.telegrambot.api.updates.UpdateManager;

/**
 * @author Zack Pollard
 */
public class RequestUpdatesManager extends UpdateManager {

    private ListenerRegistryImpl eventManager = null;
    private Thread updaterThread = null;
    private boolean getPreviousUpdates = false;

    public RequestUpdatesManager(TelegramBot telegramBot, boolean getPreviousUpdates) {

        super(telegramBot);
        this.getPreviousUpdates = getPreviousUpdates;
    }

    public boolean startUpdates() {

        if(this.eventManager == null) this.eventManager = (ListenerRegistryImpl) getBotInstance().getEventsManager();

        if(updaterThread == null && !this.running) {

            updaterThread = new Thread(new UpdaterRunnable(this.getPreviousUpdates));
            updaterThread.start();

            return true;
        }

        return false;
    }

    public void stopUpdates() {

        this.running = false;
        updaterThread.interrupt();
    }

    private class UpdaterRunnable implements Runnable {

        private boolean getPreviousUpdates;

        protected UpdaterRunnable(boolean getPreviousUpdates) {

            this.getPreviousUpdates = getPreviousUpdates;
        }

        @Override
        public void run() {

            running = true;

            int offset = 0;

            while (running) {

                HttpResponse<String> response = null;

                try {
                    response = Unirest.post(getBotInstance().getBotAPIUrl() + "getUpdates")
                            .field("offset", offset + 1, "application/json; charset=utf8;")
                            .field("timeout", 10).asString();
                } catch (UnirestException e) {
                    System.err.println("There was a connection error when trying to retrieve updates, waiting for 1 second and then trying again.");
                    System.err.println(e.getLocalizedMessage());

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                } catch (JSONException e) {
                    System.err.println("There was a JSON error, suspected API error, waiting for 1 second and then trying again.");
                    System.err.println(e.getMessage());

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }

                if (response != null && response.getStatus() == 200) {

                    JSONObject jsonResponse;

                    try {

                        jsonResponse = new JSONObject(response.getBody());
                    } catch (JSONException e) {

                        System.err.println("API didn't return a JSON response. Response content was: " + response.getBody());
                        continue;
                    }

                    if (jsonResponse.getBoolean("ok")) {

                        JSONArray updates = jsonResponse.getJSONArray("result");

                        if (updates.length() != 0)
                            offset = updates.getJSONObject(updates.length() - 1).getInt("update_id");

                        if (!getPreviousUpdates) {

                            if (updates.length() < 100) {

                                getPreviousUpdates = true;
                            }

                            continue;
                        }

                        for (int i = 0; i < updates.length(); ++i) {

                            Update update = UpdateImpl.createUpdate(updates.getJSONObject(i), getBotInstance());

                            try {

                                switch (update.getType()) {

                                    case MESSAGE:
                                    case CHANNEL_POST: {

                                        Message message = update.getType() == Update.UpdateType.MESSAGE ? update.getMessage() : update.getChannelPost();

                                        // if (getBotInstance().getConversationRegistry().processMessage(update.getMessage())) {
                                        //    break;
                                        // }

                                        MessageEvent event = new MessageReceivedEvent(message);
                                        eventManager.callEvent(event);
                                        boolean isCancelled = event.isCancelled();
                                        boolean hasEvent = true;
                                        switch (message.getContent().getType()) {

                                            case AUDIO:
                                                event = new AudioMessageReceivedEvent(message);
                                                break;
                                            case CONTACT:
                                                event = new ContactMessageReceivedEvent(message);
                                                break;
                                            case DELETE_CHAT_PHOTO:
                                                event = new DeleteGroupChatPhotoEvent(message);
                                                break;
                                            case DOCUMENT:
                                                event = new DocumentMessageReceivedEvent(message);
                                                break;
                                            case LOCATION:
                                                event = new LocationMessageReceivedEvent(message);
                                                break;
                                            case NEW_CHAT_TITLE:
                                                event = new NewGroupChatTitleEvent(message);
                                                break;
                                            case NEW_CHAT_PARTICIPANT:
                                                event = new ParticipantJoinGroupChatEvent(message);
                                                break;
                                            case NEW_CHAT_PARTICIPANTS:
                                                event = new ParticipantsJoinGroupChatEvent(message);
                                                break;
                                            case PHOTO:
                                                event = new PhotoMessageReceivedEvent(message);
                                                break;
                                            case STICKER:
                                                event = new StickerMessageReceivedEvent(message);
                                                break;
                                            case TEXT: {

                                                if (((TextContent) message.getContent()).getContent().startsWith("/")) {

                                                    event = new CommandMessageReceivedEvent(message);
                                                } else {

                                                    event = new TextMessageReceivedEvent(message);
                                                }

                                                break;
                                            }
                                            case VIDEO:
                                                event = new VideoMessageReceivedEvent(message);
                                                break;
                                            case VOICE:
                                                event = new VoiceMessageReceivedEvent(message);
                                                break;
                                            case GROUP_CHAT_CREATED:
                                                event = new GroupChatCreatedEvent(message);
                                                break;
                                            case LEFT_CHAT_PARTICIPANT:
                                                event = new ParticipantLeaveGroupChatEvent(message);
                                                break;
                                            case NEW_CHAT_PHOTO:
                                                event = new NewGroupChatPhotoEvent(message);
                                                break;
                                            case CHANNEL_CHAT_CREATED:
                                                event = new ChannelChatCreatedEvent(message);
                                                break;
                                            case MIGRATE_FROM_CHAT_ID:
                                                event = new MigrateFromChatEvent(message);
                                                break;
                                            case MIGRATE_TO_CHAT_ID:
                                                event = new MigrateToChatEvent(message);
                                                break;
                                            case SUPER_GROUP_CHAT_CREATED:
                                                event = new SuperGroupChatCreatedEvent(message);
                                                break;
                                            default:
                                                hasEvent = false;
                                                break;
                                        }
                                        if (hasEvent) {
                                            // Carry over the generic message event cancel state
                                            event.setCancelled(isCancelled);
                                            eventManager.callEvent(event);
                                        }
                                        break;
                                    }

                                    case EDITED_MESSAGE: {

                                        eventManager.callEvent(new MessageEditReceivedEvent(update.getEditedMessage()));
                                        break;
                                    }

                                    case EDITED_CHANNEL_POST: {

                                        eventManager.callEvent(new MessageEditReceivedEvent(update.getEditedMessage()));
                                        break;
                                    }

                                    case INLINE_QUERY: {

                                        eventManager.callEvent(new InlineQueryReceivedEvent(update.getInlineQuery()));
                                        break;
                                    }

                                    case CHOSEN_INLINE_RESULT: {

                                        eventManager.callEvent(new InlineResultChosenEvent(update.getChosenInlineResult()));
                                        break;
                                    }

                                    case CALLBACK_QUERY: {
                                        // if (getBotInstance().getInlineMenuRegistry().process(update.getCallbackQuery())) {
                                        //    break;
                                        // }

                                        //Make three events, one for callback queries overall, one for message callback queries and one for inline callback queries
                                        CallbackQueryReceivedEvent event = new CallbackQueryReceivedEvent(update.getCallbackQuery());
                                        eventManager.callEvent(event);
                                        boolean isCancelled = event.isCancelled();
                                        boolean hasEvent = true;
                                        switch (update.getCallbackQuery().getType()) {
                                            case MESSAGE: {
                                                event = new MessageCallbackQueryReceivedEvent((MessageCallbackQuery) update.getCallbackQuery());
                                                break;
                                            }
                                            case INLINE_MESSAGE: {
                                                event = new InlineCallbackQueryReceivedEvent((InlineCallbackQuery) update.getCallbackQuery());
                                                break;
                                            }
                                            case MESSAGE_GAME: {
                                                event = new GameMessageCallbackQueryReceivedEvent((GameMessageCallbackQuery) update.getCallbackQuery());
                                                break;
                                            }
                                            case INLINE_GAME: {
                                                event = new GameInlineCallbackQueryReceivedEvent((GameInlineCallbackQuery) update.getCallbackQuery());
                                                break;
                                            }
                                            default:
                                                hasEvent = false;
                                                break;
                                        }
                                        if (hasEvent) {
                                            // Carry over cancelled state from generic event
                                            event.setCancelled(isCancelled);
                                            eventManager.callEvent(event);
                                        }
                                        break;
                                    }
                                }
                            } catch (Exception e) {

                                System.err.println("An error occurred during an event, check the stacktrace below for a more detailed error.");
                                e.printStackTrace();
                            }
                        }
                    } else {

                        System.err.println("The API returned the following error: " + jsonResponse.getString("description"));
                    }
                }

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}