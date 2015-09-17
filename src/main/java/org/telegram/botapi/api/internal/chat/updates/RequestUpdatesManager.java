package org.telegram.botapi.api.internal.chat.updates;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.telegram.botapi.api.TelegramBot;
import org.telegram.botapi.api.chat.message.content.ContentType;
import org.telegram.botapi.api.chat.message.content.StickerContent;
import org.telegram.botapi.api.chat.message.content.TextContent;
import org.telegram.botapi.api.chat.message.send.InputFile;
import org.telegram.botapi.api.chat.message.send.SendableStickerMessage;
import org.telegram.botapi.api.chat.message.send.SendableTextMessage;
import org.telegram.botapi.api.event.chat.*;
import org.telegram.botapi.api.event.chat.message.*;
import org.telegram.botapi.api.internal.event.ListenerRegistryImpl;
import org.telegram.botapi.api.keyboards.ReplyKeyboardMarkup;
import org.telegram.botapi.api.updates.Update;
import org.telegram.botapi.api.updates.UpdateManager;

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
		private boolean getPreviousUpdates;
		private final long unixTime;

		protected UpdaterRunnable(RequestUpdatesManager requestUpdatesManager, boolean getPreviousUpdates) {

			this.requestUpdatesManager = requestUpdatesManager;
			this.getPreviousUpdates = getPreviousUpdates;
			this.unixTime = System.currentTimeMillis() / 1000;
		}

		@Override
		public void run() {

			int offset = 0;

			while(true) {

				try {
					HttpResponse<JsonNode> response = Unirest.post(requestUpdatesManager.getTelegramBot().getBotAPIUrl() + "getUpdates")
							.field("offset", offset + 1, "application/json")
							.field("timeout", 10).asJson();

					if(response.getStatus() == 200) {

						if(response.getBody().getObject().getBoolean("ok")) {

							JSONArray updates = response.getBody().getObject().getJSONArray("result");

							for(int i = 0; i < updates.length(); ++i) {

								Update update = UpdateImpl.createUpdate(updates.getJSONObject(i));

								if(!getPreviousUpdates) {

									if(update.getMessage().getTimeStamp() < unixTime) {

										break;
									} else {

										getPreviousUpdates = true;
									}
								}

								eventManager.callEvent(new MessageReceivedEvent(update.getMessage()));

								switch(update.getMessage().getContent().getType()) {

									case AUDIO: eventManager.callEvent(new AudioMessageReceivedEvent(update.getMessage())); break;
									case CONTACT: eventManager.callEvent(new ContactMessageReceivedEvent(update.getMessage())); break;
									case DELETE_CHAT_PHOTO: eventManager.callEvent(new DeleteGroupChatPhotoEvent(update.getMessage())); break;
									case DOCUMENT: eventManager.callEvent(new DocumentMessageReceivedEvent(update.getMessage())); break;
									case LOCATION: eventManager.callEvent(new LocationMessageReceivedEvent(update.getMessage())); break;
									case NEW_CHAT_TITLE: eventManager.callEvent(new NewGroupChatTitleEvent(update.getMessage())); break;
									case NEW_CHAT_PARTICIPANT: eventManager.callEvent(new ParticipantJoinGroupChatEvent(update.getMessage())); break;
									case PHOTO: eventManager.callEvent(new PhotoMessageReceivedEvent(update.getMessage())); break;
									case STICKER: eventManager.callEvent(new StickerMessageReceivedEvent(update.getMessage())); break;
									case TEXT: {

										if (((TextContent) update.getMessage().getContent()).getContent().startsWith("/")) {

											eventManager.callEvent(new CommandMessageReceivedEvent(update.getMessage()));
										} else {

											eventManager.callEvent(new TextMessageReceivedEvent(update.getMessage()));
										}

										break;
									}
									case VIDEO: eventManager.callEvent(new VideoMessageReceivedEvent(update.getMessage())); break;
									case VOICE: eventManager.callEvent(new VoiceMessageReceivedEvent(update.getMessage())); break;
									case GROUP_CHAT_CREATED: eventManager.callEvent(new GroupChatCreatedEvent(update.getMessage())); break;
									case LEFT_CHAT_PARTICIPANT: eventManager.callEvent(new ParticipantLeaveGroupChatEvent(update.getMessage())); break;
									case NEW_CHAT_PHOTO: eventManager.callEvent(new NewGroupChatPhotoEvent(update.getMessage())); break;
								}
							}

							if(updates.length() != 0) offset = updates.getJSONObject(updates.length() - 1).getInt("update_id");
						}
					}
				} catch (UnirestException e) {
					e.printStackTrace();
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