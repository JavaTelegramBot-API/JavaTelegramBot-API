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
import org.telegram.botapi.api.updates.Update;
import org.telegram.botapi.api.updates.UpdateManager;

/**
 * @author Zack Pollard
 */
public class RequestUpdatesManager extends UpdateManager {

	public RequestUpdatesManager(TelegramBot telegramBot) {

		super(telegramBot);

		new Thread(new UpdaterRunnable(this)).start();
	}

	public UpdateMethod getUpdateMethod() {

		return UpdateMethod.REQUEST_UPDATES;
	}

	private class UpdaterRunnable implements Runnable {

		private final RequestUpdatesManager requestUpdatesManager;

		protected UpdaterRunnable(RequestUpdatesManager requestUpdatesManager) {

			this.requestUpdatesManager = requestUpdatesManager;
		}

		@Override
		public void run() {

			int offset = 0;

			while(true) {

				try {
					HttpResponse<JsonNode> response = Unirest.post(requestUpdatesManager.getTelegramBot().getBotAPIUrl() + "getUpdates")
							.field("offset", offset + 1, "application/json")
							.field("timeout", 10).asJson();

					System.out.println(response.getBody());

					if(response.getStatus() == 200) {

						if(response.getBody().getObject().getBoolean("ok")) {

							JSONArray updates = response.getBody().getObject().getJSONArray("result");

							for(int i = 0; i < updates.length(); ++i) {

								Update update = UpdateImpl.createUpdate(updates.getJSONObject(i));

								if(update.getMessage().getContent().getType().equals(ContentType.TEXT)) {

									TextContent textContent = (TextContent) update.getMessage().getContent();

									if(textContent.getContent().toLowerCase().contains(" rip") || textContent.getContent().toLowerCase().contains("rip ") || textContent.getContent().equals("rip")) {

										getTelegramBot().sendMessage(update.getMessage().getChat(), SendableTextMessage.builder().message("in pieces").replyTo(update.getMessage()).build());
									}

									if(textContent.getContent().toLowerCase().contains("ayy") && textContent.getContent().toLowerCase().contains("lmao") || textContent.getContent().toLowerCase().contains("alien")) {

										getTelegramBot().sendMessage(update.getMessage().getChat(), SendableTextMessage.builder().message("ayy lmao").replyTo(update.getMessage()).build());
									} else if(textContent.getContent().toLowerCase().contains("ayy")) {

										getTelegramBot().sendMessage(update.getMessage().getChat(), SendableTextMessage.builder().message("lmao").replyTo(update.getMessage()).build());
									} else if(textContent.getContent().toLowerCase().contains("lmao")) {

										getTelegramBot().sendMessage(update.getMessage().getChat(), SendableTextMessage.builder().message("ayy").replyTo(update.getMessage()).build());
									}
								} else if(update.getMessage().getContent().getType().equals(ContentType.STICKER)) {

									StickerContent stickerContent = (StickerContent) update.getMessage().getContent();

									if(stickerContent.getContent().getFileId().equals("BQADBAADTQADzJm8AsWHAqcGmP2hAg")) {

										getTelegramBot().sendMessage(update.getMessage().getChat(), SendableStickerMessage.builder().sticker(new InputFile("BQADBAADVAADzJm8AlQq_rm3coV0Ag")).build());
									} else if(stickerContent.getContent().getFileId().equals("BQADBAADVAADzJm8AlQq_rm3coV0Ag")) {

										getTelegramBot().sendMessage(update.getMessage().getChat(), SendableStickerMessage.builder().sticker(new InputFile("BQADBAADTQADzJm8AsWHAqcGmP2hAg")).build());
									}
								}

								//TODO: Send these to the relevant events
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