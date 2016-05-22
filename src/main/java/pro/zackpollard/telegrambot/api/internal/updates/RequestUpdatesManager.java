package pro.zackpollard.telegrambot.api.internal.updates;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.inline.InlineCallbackQuery;
import pro.zackpollard.telegrambot.api.chat.message.MessageCallbackQuery;
import pro.zackpollard.telegrambot.api.chat.message.content.TextContent;
import pro.zackpollard.telegrambot.api.event.chat.*;
import pro.zackpollard.telegrambot.api.event.chat.inline.InlineCallbackQueryReceivedEvent;
import pro.zackpollard.telegrambot.api.event.chat.inline.InlineQueryReceivedEvent;
import pro.zackpollard.telegrambot.api.event.chat.inline.InlineResultChosenEvent;
import pro.zackpollard.telegrambot.api.event.chat.message.*;
import pro.zackpollard.telegrambot.api.internal.event.ListenerRegistryImpl;
import pro.zackpollard.telegrambot.api.updates.Update;
import pro.zackpollard.telegrambot.api.updates.UpdateManager;

/**
 * @author Zack Pollard
 */
public class RequestUpdatesManager extends UpdateManager {

    private final ListenerRegistryImpl eventManager;

    public RequestUpdatesManager(TelegramBot telegramBot, boolean getPreviousUpdates) {

        super(telegramBot);

        eventManager = (ListenerRegistryImpl) telegramBot.getEventsManager();
        new Thread(new UpdaterRunnable(this, getPreviousUpdates)).start();
    }

    public UpdateMethod getUpdateMethod() {

        return UpdateMethod.REQUEST_UPDATES;
    }

    private class UpdaterRunnable implements Runnable {

        private final RequestUpdatesManager requestUpdatesManager;
        private final long unixTime;
        private boolean getPreviousUpdates;

        protected UpdaterRunnable(RequestUpdatesManager requestUpdatesManager, boolean getPreviousUpdates) {

            this.requestUpdatesManager = requestUpdatesManager;
            this.getPreviousUpdates = getPreviousUpdates;
            this.unixTime = System.currentTimeMillis() / 1000;
        }

        @Override
        public void run() {

            int offset = 0;

            while (true) {

                HttpResponse<String> response = null;

                try {
                    response = Unirest.post(requestUpdatesManager.getBotInstance().getBotAPIUrl() + "getUpdates")
                            .field("offset", offset + 1, "application/json")
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

                                    case MESSAGE: {

                                        eventManager.callEvent(new MessageReceivedEvent(update.getMessage()));

                                        switch (update.getMessage().getContent().getType()) {

                                            case AUDIO:
                                                eventManager.callEvent(new AudioMessageReceivedEvent(update.getMessage()));
                                                break;
                                            case CONTACT:
                                                eventManager.callEvent(new ContactMessageReceivedEvent(update.getMessage()));
                                                break;
                                            case DELETE_CHAT_PHOTO:
                                                eventManager.callEvent(new DeleteGroupChatPhotoEvent(update.getMessage()));
                                                break;
                                            case DOCUMENT:
                                                eventManager.callEvent(new DocumentMessageReceivedEvent(update.getMessage()));
                                                break;
                                            case LOCATION:
                                                eventManager.callEvent(new LocationMessageReceivedEvent(update.getMessage()));
                                                break;
                                            case NEW_CHAT_TITLE:
                                                eventManager.callEvent(new NewGroupChatTitleEvent(update.getMessage()));
                                                break;
                                            case NEW_CHAT_PARTICIPANT:
                                                eventManager.callEvent(new ParticipantJoinGroupChatEvent(update.getMessage()));
                                                break;
                                            case PHOTO:
                                                eventManager.callEvent(new PhotoMessageReceivedEvent(update.getMessage()));
                                                break;
                                            case STICKER:
                                                eventManager.callEvent(new StickerMessageReceivedEvent(update.getMessage()));
                                                break;
                                            case TEXT: {

                                                if (((TextContent) update.getMessage().getContent()).getContent().startsWith("/")) {

                                                    eventManager.callEvent(new CommandMessageReceivedEvent(update.getMessage()));
                                                } else {

                                                    eventManager.callEvent(new TextMessageReceivedEvent(update.getMessage()));
                                                }

                                                break;
                                            }
                                            case VIDEO:
                                                eventManager.callEvent(new VideoMessageReceivedEvent(update.getMessage()));
                                                break;
                                            case VOICE:
                                                eventManager.callEvent(new VoiceMessageReceivedEvent(update.getMessage()));
                                                break;
                                            case GROUP_CHAT_CREATED:
                                                eventManager.callEvent(new GroupChatCreatedEvent(update.getMessage()));
                                                break;
                                            case LEFT_CHAT_PARTICIPANT:
                                                eventManager.callEvent(new ParticipantLeaveGroupChatEvent(update.getMessage()));
                                                break;
                                            case NEW_CHAT_PHOTO:
                                                eventManager.callEvent(new NewGroupChatPhotoEvent(update.getMessage()));
                                                break;
                                            case CHANNEL_CHAT_CREATED:
                                                eventManager.callEvent(new ChannelChatCreatedEvent(update.getMessage()));
                                                break;
                                            case MIGRATE_FROM_CHAT_ID:
                                                eventManager.callEvent(new MigrateFromChatEvent(update.getMessage()));
                                                break;
                                            case MIGRATE_TO_CHAT_ID:
                                                eventManager.callEvent(new MigrateToChatEvent(update.getMessage()));
                                                break;
                                            case SUPER_GROUP_CHAT_CREATED:
                                                eventManager.callEvent(new SuperGroupChatCreatedEvent(update.getMessage()));
                                                break;
                                        }
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

                                        //Make three events, one for callback queries overall, one for message callback queries and one for inline callback queries
                                        eventManager.callEvent(new CallbackQueryReceivedEvent(update.getCallbackQuery()));
                                        switch (update.getCallbackQuery().getType()) {
                                            case MESSAGE: {
                                                eventManager.callEvent(new MessageCallbackQueryReceivedEvent((MessageCallbackQuery) update.getCallbackQuery()));
                                                break;
                                            }
                                            case INLINE_MESSAGE: {
                                                eventManager.callEvent(new InlineCallbackQueryReceivedEvent((InlineCallbackQuery) update.getCallbackQuery()));
                                                break;
                                            }
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
                        System.err.println("The API returned the following error (code "  + jsonResponse.getInt("error_code") + "): " + jsonResponse.getString("errorDescription"));
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