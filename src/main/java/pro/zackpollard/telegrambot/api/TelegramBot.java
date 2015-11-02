package pro.zackpollard.telegrambot.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.body.MultipartBody;
import lombok.Getter;
import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.Chat;
import pro.zackpollard.telegrambot.api.chat.message.ForceReply;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.content.*;
import pro.zackpollard.telegrambot.api.chat.message.content.type.*;
import pro.zackpollard.telegrambot.api.chat.message.send.*;
import pro.zackpollard.telegrambot.api.event.ListenerRegistry;
import pro.zackpollard.telegrambot.api.internal.chat.ChannelChatImpl;
import pro.zackpollard.telegrambot.api.internal.chat.GroupChatImpl;
import pro.zackpollard.telegrambot.api.internal.chat.IndividualChatImpl;
import pro.zackpollard.telegrambot.api.internal.chat.message.MessageImpl;
import pro.zackpollard.telegrambot.api.internal.chat.message.send.FileContainer;
import pro.zackpollard.telegrambot.api.internal.updates.RequestUpdatesManager;
import pro.zackpollard.telegrambot.api.internal.event.ListenerRegistryImpl;
import pro.zackpollard.telegrambot.api.internal.managers.FileManager;
import pro.zackpollard.telegrambot.api.keyboards.ReplyKeyboardHide;
import pro.zackpollard.telegrambot.api.keyboards.ReplyKeyboardMarkup;
import pro.zackpollard.telegrambot.api.updates.UpdateManager;

/**
 * @author Zack Pollard
 */
public final class TelegramBot {

	public static final String API_URL = "https://api.telegram.org/";
	private static final Gson GSON = new GsonBuilder().create();
	@Getter
	private final static FileManager fileManager = new FileManager();

	@Getter
	private final String authToken;
	private final ListenerRegistry listenerRegistry;
	private UpdateManager updateManager = null;

	private TelegramBot(String authToken) {

		this.authToken = authToken;
		listenerRegistry = ListenerRegistryImpl.getNewInstance();
	}

	/**
	 * Use this method to get a new TelegramBot instance with the selected auth token.
	 *
	 * @param authToken The bots auth token.
	 * @return A new TelegramBot instance to base your bot around.
	 */

	public static TelegramBot login(String authToken) {

		return new TelegramBot(authToken);
	}

	public static Chat getChat(int chatID) {

		if (chatID < 0) {

			return GroupChatImpl.createGroupChat(chatID);
		} else {

			return IndividualChatImpl.createIndividualChat(chatID);
		}
	}

    public static Chat getChat(String chatID) {

		if(chatID != null && chatID.length() > 0) {

			if (chatID.charAt(0) == '@') {

				return ChannelChatImpl.createChannelChat(chatID);
			} else {

				int intChatID;

				try {

					intChatID = Integer.parseInt(chatID);
				} catch (NumberFormatException e) {

					System.err.println("TelegramBot#getChat(String chatID) was called with invalid ChatID.");
					return null;
				}

				return getChat(intChatID);
			}
		}

		return null;
    }

	public String getBotAPIUrl() {

		return API_URL + "bot" + authToken + "/";
	}

	public Message sendMessage(Chat chat, SendableMessage message) {

		JsonNode jsonResponse = null;
		Message messageResponse = null;

		switch (message.getType()) {

			case TEXT: {

				SendableTextMessage textMessage = (SendableTextMessage) message;

				try {
					MultipartBody request = Unirest.post(getBotAPIUrl() + "sendMessage")
							.field("chat_id", chat.getId(), "application/json")
							.field("text", textMessage.getMessage(), "application/json")
							.field("disable_web_page_preview", textMessage.isDisableWebPagePreview())
                            .field("parse_mode", textMessage.getParseMode().getModeName());

					processReplyContent(request, textMessage);

					jsonResponse = request.asJson().getBody();

				} catch (UnirestException e) {
					e.printStackTrace();
				}

				break;
			}
			case FORWARDED: {

				SendableForwardMessage forwardMessage = (SendableForwardMessage) message;

				try {
					MultipartBody request = Unirest.post(getBotAPIUrl() + "forwardMessage")
							.field("chat_id", chat.getId(), "application/json")
							.field("from_chat_id", forwardMessage.getForwardedMessage().getChat().getId())
							.field("message_id", forwardMessage.getForwardedMessage().getMessageId());

					jsonResponse = request.asJson().getBody();
				} catch (UnirestException e) {
					e.printStackTrace();
				}

				break;
			}
			case PHOTO: {

				SendablePhotoMessage photoMessage = (SendablePhotoMessage) message;

				try {
					MultipartBody request = Unirest.post(getBotAPIUrl() + "sendPhoto")
							.field("chat_id", chat.getId(), "application/json")
							.field("photo", photoMessage.getPhoto().getFileID() != null ? photoMessage.getPhoto().getFileID() : new FileContainer(photoMessage.getPhoto()), photoMessage.getPhoto().getFileID() == null);

					if (photoMessage.getCaption() != null)
						request.field("caption", photoMessage.getCaption(), "application/json");

					processReplyContent(request, photoMessage);

					HttpResponse<JsonNode> response = request.asJson();

					jsonResponse = response.getBody();

				} catch (UnirestException e) {
					e.printStackTrace();
				}

				messageResponse = checkResponseStatus(jsonResponse) ? (MessageImpl.createMessage(jsonResponse != null ? jsonResponse.getObject() : null)) : null;

				//Photo cacheing to FileManager
				if (photoMessage.getPhoto().getFile() != null && messageResponse != null) {

					PhotoSize[] photoSizes = ((PhotoContent) messageResponse.getContent()).getContent();

					int largestPhotoSize = 0;
					int largestPhotoID = 0;

					for (int i = 0; i < photoSizes.length; ++i) {

						int size = photoSizes[i].getHeight() * photoSizes[i].getWidth();

						if (largestPhotoSize < size) {

							largestPhotoSize = size;
							largestPhotoID = i;
						}
					}

					fileManager.cacheFileID(photoMessage.getPhoto().getFile(), photoSizes[largestPhotoID].getFileId());
				}

				break;
			}
			case AUDIO: {

				SendableAudioMessage audioMessage = (SendableAudioMessage) message;

				try {
					MultipartBody request = Unirest.post(getBotAPIUrl() + "sendAudio")
							.field("chat_id", chat.getId(), "application/json")
							.field("audio", audioMessage.getAudio().getFileID() != null ? audioMessage.getAudio().getFileID() : new FileContainer(audioMessage.getAudio()), audioMessage.getAudio().getFileID() == null);

					processReplyContent(request, audioMessage);

					if (audioMessage.getDuration() != 0) request.field("duration", audioMessage.getDuration());
					if (audioMessage.getPerformer() != null)
						request.field("performer", audioMessage.getPerformer(), "application/json");
					if (audioMessage.getTitle() != null)
						request.field("title", audioMessage.getTitle(), "application/json");

					jsonResponse = request.asJson().getBody();

				} catch (UnirestException e) {
					e.printStackTrace();
				}

				messageResponse = checkResponseStatus(jsonResponse) ? (MessageImpl.createMessage(jsonResponse != null ? jsonResponse.getObject() : null)) : null;

				//Audio cacheing to FileManager
				if (audioMessage.getAudio().getFile() != null && messageResponse != null) {

					if (messageResponse.getContent().getType().equals(ContentType.AUDIO)) {

						Audio audio = ((AudioContent) messageResponse.getContent()).getContent();

						fileManager.cacheFileID(audioMessage.getAudio().getFile(), audio.getFileId());
					} else if (messageResponse.getContent().getType().equals(ContentType.VOICE)) {

						Voice voice = ((VoiceContent) messageResponse.getContent()).getContent();

						fileManager.cacheFileID(audioMessage.getAudio().getFile(), voice.getFileId());
					}
				}

				break;
			}
			case DOCUMENT: {

				SendableDocumentMessage documentMessage = (SendableDocumentMessage) message;

				try {
					MultipartBody request = Unirest.post(getBotAPIUrl() + "sendDocument")
							.field("chat_id", chat.getId(), "application/json")
							.field("document", documentMessage.getDocument().getFileID() != null ? documentMessage.getDocument().getFileID() : new FileContainer(documentMessage.getDocument()), documentMessage.getDocument().getFileID() == null);

					processReplyContent(request, documentMessage);

					jsonResponse = request.asJson().getBody();
				} catch (UnirestException e) {
					e.printStackTrace();
				}

				messageResponse = checkResponseStatus(jsonResponse) ? (MessageImpl.createMessage(jsonResponse != null ? jsonResponse.getObject() : null)) : null;

				//Document cacheing to FileManager
				if (documentMessage.getDocument().getFile() != null && messageResponse != null) {

					Document document = ((DocumentContent) messageResponse.getContent()).getContent();

					fileManager.cacheFileID(documentMessage.getDocument().getFile(), document.getFileId());
				}

				break;
			}
			case STICKER:

				SendableStickerMessage stickerMessage = (SendableStickerMessage) message;

				try {
					MultipartBody request = Unirest.post(getBotAPIUrl() + "sendSticker")
							.field("chat_id", chat.getId(), "application/json")
							.field("sticker", stickerMessage.getSticker().getFileID() != null ? stickerMessage.getSticker().getFileID() : new FileContainer(stickerMessage.getSticker()), stickerMessage.getSticker().getFileID() == null);

					processReplyContent(request, stickerMessage);

					jsonResponse = request.asJson().getBody();
				} catch (UnirestException e) {
					e.printStackTrace();
				}

				messageResponse = checkResponseStatus(jsonResponse) ? (MessageImpl.createMessage(jsonResponse != null ? jsonResponse.getObject() : null)) : null;

				//Sticker cacheing to FileManager
				if (stickerMessage.getSticker().getFile() != null && messageResponse != null) {

					Sticker sticker = ((StickerContent) messageResponse.getContent()).getContent();

					fileManager.cacheFileID(stickerMessage.getSticker().getFile(), sticker.getFileId());
				}

				break;

			case VIDEO:

				SendableVideoMessage videoMessage = (SendableVideoMessage) message;

				try {
					MultipartBody request = Unirest.post(getBotAPIUrl() + "sendVideo")
							.field("chat_id", chat.getId(), "application/json")
							.field("video", videoMessage.getVideo().getFileID() != null ? videoMessage.getVideo().getFileID() : new FileContainer(videoMessage.getVideo()), videoMessage.getVideo().getFileID() == null);

					if (videoMessage.getCaption() != null)
						request.field("caption", videoMessage.getCaption(), "application/json");

					processReplyContent(request, videoMessage);

					jsonResponse = request.asJson().getBody();
				} catch (UnirestException e) {
					e.printStackTrace();
				}

				messageResponse = checkResponseStatus(jsonResponse) ? (MessageImpl.createMessage(jsonResponse != null ? jsonResponse.getObject() : null)) : null;

				//Video cacheing to FileManager
				if (videoMessage.getVideo().getFile() != null && messageResponse != null) {

					Video video = ((VideoContent) messageResponse.getContent()).getContent();

					fileManager.cacheFileID(videoMessage.getVideo().getFile(), video.getFileId());
				}

				break;
			case VOICE:

				SendableVoiceMessage voiceMessage = (SendableVoiceMessage) message;

				try {
					MultipartBody request = Unirest.post(getBotAPIUrl() + "sendVoice")
							.field("chat_id", chat.getId(), "application/json")
							.field("voice", voiceMessage.getVoice().getFileID() != null ? voiceMessage.getVoice().getFileID() : new FileContainer(voiceMessage.getVoice()), voiceMessage.getVoice().getFileID() == null);

					processReplyContent(request, voiceMessage);

					jsonResponse = request.asJson().getBody();
				} catch (UnirestException e) {
					e.printStackTrace();
				}

				messageResponse = checkResponseStatus(jsonResponse) ? (MessageImpl.createMessage(jsonResponse != null ? jsonResponse.getObject() : null)) : null;

				//Voice cacheing to FileManager
				if (voiceMessage.getVoice().getFile() != null && messageResponse != null) {

					Voice voice = ((VoiceContent) messageResponse.getContent()).getContent();

					fileManager.cacheFileID(voiceMessage.getVoice().getFile(), voice.getFileId());
				}

				break;

			case LOCATION:

				SendableLocationMessage sendableLocationMessage = (SendableLocationMessage) message;

				try {
					MultipartBody request = Unirest.post(getBotAPIUrl() + "sendLocation")
							.field("chat_id", chat.getId(), "application/json")
							.field("latitude", sendableLocationMessage.getLatitude())
							.field("longitude", sendableLocationMessage.getLongitude());

					processReplyContent(request, sendableLocationMessage);

					jsonResponse = request.asJson().getBody();
				} catch (UnirestException e) {
					e.printStackTrace();
				}

				break;
			case CHAT_ACTION:

				SendableChatAction sendableChatAction = (SendableChatAction) message;

				try {
					MultipartBody request = Unirest.post(getBotAPIUrl() + "sendChatAction")
							.field("chat_id", chat.getId(), "application/json")
							.field("action", sendableChatAction.getChatAction().getName());

					jsonResponse = request.asJson().getBody();
				} catch (UnirestException e) {
					e.printStackTrace();
				}

				return null;
		}

		return checkResponseStatus(jsonResponse) ? (messageResponse != null ? messageResponse : MessageImpl.createMessage(jsonResponse.getObject())) : null;
	}

	public void startUpdates(boolean getPreviousUpdates) {

		updateManager = new RequestUpdatesManager(this, getPreviousUpdates);
	}

	public ListenerRegistry getEventsManager() {

		return listenerRegistry;
	}

	private void processReplyContent(MultipartBody multipartBody, ReplyingOptions replyingOptions) {

		if (replyingOptions.getReplyTo() != null)
			multipartBody.field("reply_to_message_id", replyingOptions.getReplyTo().getMessageId());
		if (replyingOptions.getReplyMarkup() != null) {

			switch (replyingOptions.getReplyMarkup().getType()) {

				case FORCE_REPLY:
					multipartBody.field("reply_markup", GSON.toJson(replyingOptions.getReplyMarkup(), ForceReply.class), "application/json");
					break;
				case KEYBOARD_HIDE:
					multipartBody.field("reply_markup", GSON.toJson(replyingOptions.getReplyMarkup(), ReplyKeyboardHide.class), "application/json");
					break;
				case KEYBOARD_MARKUP:
					multipartBody.field("reply_markup", GSON.toJson(replyingOptions.getReplyMarkup(), ReplyKeyboardMarkup.class), "application/json");
					break;
			}
		}
	}

	private boolean checkResponseStatus(JsonNode jsonResponse) {

		if(jsonResponse != null) {

			JSONObject jsonObject = jsonResponse.getObject();

			if(jsonObject.getBoolean("ok")) {

				return true;
			} else {

				System.err.println("The API returned the following error: " + jsonObject.getString("description"));
			}
		} else {

			System.err.println("JSON Response was null, something went wrong...");
		}

		return false;
	}
}