package pro.zackpollard.telegrambot.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequestWithBody;
import com.mashape.unirest.request.body.MultipartBody;
import lombok.Getter;
import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.Chat;
import pro.zackpollard.telegrambot.api.chat.edit.UserRestrictions;
import pro.zackpollard.telegrambot.api.chat.inline.InlineReplyMarkup;
import pro.zackpollard.telegrambot.api.chat.inline.send.InlineQueryResponse;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.content.*;
import pro.zackpollard.telegrambot.api.chat.message.content.type.*;
import pro.zackpollard.telegrambot.api.chat.message.send.*;
import pro.zackpollard.telegrambot.api.event.ListenerRegistry;
import pro.zackpollard.telegrambot.api.extensions.Extension;
import pro.zackpollard.telegrambot.api.games.GameHighScore;
import pro.zackpollard.telegrambot.api.games.GameScoreEditResponse;
import pro.zackpollard.telegrambot.api.games.GameScoreRequest;
import pro.zackpollard.telegrambot.api.games.SendableGameScore;
import pro.zackpollard.telegrambot.api.internal.chat.ChatImpl;
import pro.zackpollard.telegrambot.api.internal.chat.game.GameHighScoreImpl;
import pro.zackpollard.telegrambot.api.internal.chat.game.GameScoreEditResponseImpl;
import pro.zackpollard.telegrambot.api.internal.chat.message.MessageImpl;
import pro.zackpollard.telegrambot.api.internal.event.ListenerRegistryImpl;
import pro.zackpollard.telegrambot.api.internal.managers.FileManager;
import pro.zackpollard.telegrambot.api.internal.updates.RequestUpdatesManager;
import pro.zackpollard.telegrambot.api.keyboards.InlineKeyboardMarkup;
import pro.zackpollard.telegrambot.api.updates.UpdateManager;
import pro.zackpollard.telegrambot.api.utils.Utils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Zack Pollard
 */
public final class TelegramBot {

    /**
     * The API URL endpoint that is constant for all bots
     */
    public static final String API_URL = "https://api.telegram.org/";
    /**
     * A GSON instance that is used throughout the project wherever GSON is needed
     */
    public static final Gson GSON = new GsonBuilder().create();

    @Getter
    private final static FileManager fileManager = new FileManager();


    private final Map<Class<?>, Extension.Provider<? extends Extension>> extensions = new HashMap<>();

    @Getter
    private final String authToken;
    private final ListenerRegistry listenerRegistry;
    private UpdateManager updateManager = null;

    @Getter
    private final int botID;
    @Getter
    private final String botName;
    @Getter
    private final String botUsername;

    private TelegramBot(String authToken, int botID, String botName, String botUsername) {

        this.authToken = authToken;
        this.botID = botID;
        this.botName = botName;
        this.botUsername = "@" + botUsername;

        listenerRegistry = ListenerRegistryImpl.getNewInstance();
    }

    /**
     * Use this method to get a new TelegramBot instance with the selected auth token
     *
     * @param authToken The bots auth token
     *
     * @return A new TelegramBot instance or null if something failed
     */
    public static TelegramBot login(String authToken) {

        try {

            HttpRequestWithBody request = Unirest.post(API_URL + "bot" + authToken + "/getMe");
            HttpResponse<String> response = request.asString();
            JSONObject jsonResponse = Utils.processResponse(response);

            if (jsonResponse != null && Utils.checkResponseStatus(jsonResponse)) {

                JSONObject result = jsonResponse.getJSONObject("result");

                return new TelegramBot(authToken, result.getInt("id"), result.getString("first_name"), result.getString("username"));
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * A method used to get a Chat object via the chats ID
     *
     * @param chatID The Chat ID of the chat you want a Chat object of
     *
     * @return A Chat object or null if the chat does not exist or you don't have permission to get this chat
     */
    public Chat getChat(long chatID) {

        return getChat(String.valueOf(chatID));
    }

    /**
     * A method used to get a Chat object via the chats ID
     *
     * @param chatID The Chat ID of the chat you want a Chat object of
     *
     * @return A Chat object or null if the chat does not exist or you don't have permission to get this chat
     */
    public Chat getChat(String chatID) {

        try {

            MultipartBody request = Unirest.post(getBotAPIUrl() + "getChat")
                    .field("chat_id", chatID, "application/json; charset=utf8;");
            HttpResponse<String> response = request.asString();
            JSONObject jsonResponse = Utils.processResponse(response);

            if (jsonResponse != null && Utils.checkResponseStatus(jsonResponse)) {

                JSONObject result = jsonResponse.getJSONObject("result");

                return ChatImpl.createChat(result, this);
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * This provides the URL used to make all the API calls to the bot API
     *
     * @return The URL used to make all the API calls to the bot API
     */
    public String getBotAPIUrl() {

        return API_URL + "bot" + authToken + "/";
    }

    /**
     * This will send the provided SendableMessage object to the Chat that the Chat object represents
     *
     * @param chat      The chat you want to send the message to
     * @param message   The message you want to send to the chat
     *
     * @return A Message object that represents the message you sent, or null if sending failed
     */
    public Message sendMessage(Chat chat, SendableMessage message) {

        HttpResponse<String> response;
        JSONObject jsonResponse = null;
        Message messageResponse = null;

        switch (message.getType()) {

            case TEXT: {

                SendableTextMessage textMessage = (SendableTextMessage) message;

                try {
                    MultipartBody request = Unirest.post(getBotAPIUrl() + "sendMessage")
                            .field("chat_id", chat.getId(), "application/json; charset=utf8;")
                            .field("text", textMessage.getMessage(), "application/json; charset=utf8;")
                            .field("disable_web_page_preview", textMessage.isDisableWebPagePreview())
                            .field("parse_mode", textMessage.getParseMode() != null ? textMessage.getParseMode().getModeName() : ParseMode.NONE);

                    Utils.processReplyContent(request, textMessage);
                    Utils.processNotificationContent(request, textMessage);

                    response = request.asString();
                    jsonResponse = Utils.processResponse(response);
                } catch (UnirestException e) {
                    e.printStackTrace();
                }

                break;
            }
            case FORWARDED: {

                SendableForwardMessage forwardMessage = (SendableForwardMessage) message;

                try {
                    MultipartBody request = Unirest.post(getBotAPIUrl() + "forwardMessage")
                            .field("chat_id", chat.getId(), "application/json; charset=utf8;")
                            .field("from_chat_id", forwardMessage.getChatID())
                            .field("message_id", forwardMessage.getMessageID());

                    Utils.processNotificationContent(request, forwardMessage);

                    response = request.asString();
                    jsonResponse = Utils.processResponse(response);
                } catch (UnirestException e) {
                    e.printStackTrace();
                }

                break;
            }
            case PHOTO: {

                SendablePhotoMessage photoMessage = (SendablePhotoMessage) message;

                try {
                    MultipartBody request = Unirest.post(getBotAPIUrl() + "sendPhoto")
                            .field("chat_id", chat.getId(), "application/json; charset=utf8;");

                    InputFile inputFile = photoMessage.getPhoto();
                    Utils.processInputFileField(request, "photo", inputFile);

                    if (photoMessage.getCaption() != null)
                        request.field("caption", photoMessage.getCaption(), "application/json; charset=utf8;");

                    Utils.processReplyContent(request, photoMessage);
                    Utils.processNotificationContent(request, photoMessage);

                    response = request.asString();
                    jsonResponse = Utils.processResponse(response);
                } catch (UnirestException e) {
                    e.printStackTrace();
                }

                messageResponse = Utils.checkResponseStatus(jsonResponse) ? (MessageImpl.createMessage(jsonResponse != null ? jsonResponse : null, this)) : null;

                //Photo cacheing to FileManager
                if (photoMessage.getPhoto().getFile() != null && messageResponse != null) {

                    if (!messageResponse.getContent().getType().equals(ContentType.PHOTO)) {

                        System.err.println("The API returned content type " + messageResponse.getContent().getType().name() + " when a " + message.getType() + " type was sent, this is not supported by this API and will break cacheing, please create an issue on github or message @zackpollard on telegram.");
                        break;
                    }

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
                            .field("chat_id", chat.getId(), "application/json; charset=utf8;");

                    InputFile inputFile = audioMessage.getAudio();
                    Utils.processInputFileField(request, "audio", inputFile);

                    Utils.processReplyContent(request, audioMessage);
                    Utils.processNotificationContent(request, audioMessage);

                    if (audioMessage.getDuration() != 0) request.field("duration", audioMessage.getDuration());
                    if (audioMessage.getPerformer() != null)
                        request.field("performer", audioMessage.getPerformer(), "application/json; charset=utf8;");
                    if (audioMessage.getTitle() != null)
                        request.field("title", audioMessage.getTitle(), "application/json; charset=utf8;");
                    if (audioMessage.getCaption() != null)
                        request.field("caption", audioMessage.getCaption(), "application/json; charset=utf8;");

                    response = request.asString();
                    jsonResponse = Utils.processResponse(response);
                } catch (UnirestException e) {
                    e.printStackTrace();
                }

                messageResponse = Utils.checkResponseStatus(jsonResponse) ? (MessageImpl.createMessage(jsonResponse != null ? jsonResponse : null, this)) : null;

                //Audio cacheing to FileManager
                if (audioMessage.getAudio().getFile() != null && messageResponse != null) {

                    String fileID;

                    switch (messageResponse.getContent().getType()) {

                        case AUDIO:
                            fileID = ((AudioContent) messageResponse.getContent()).getContent().getFileId();
                            break;
                        case VOICE:

                            fileID = ((VoiceContent) messageResponse.getContent()).getContent().getFileId();
                            break;
                        default:
                            System.err.println("The API returned content type " + messageResponse.getContent().getType().name() + " when an audio type was sent, this is not supported by this API, please create an issue on github or message @zackpollard on telegram.");
                            return null;
                    }

                    fileManager.cacheFileID(audioMessage.getAudio().getFile(), fileID);
                }

                break;
            }
            case DOCUMENT: {

                SendableDocumentMessage documentMessage = (SendableDocumentMessage) message;

                try {
                    MultipartBody request = Unirest.post(getBotAPIUrl() + "sendDocument")
                            .field("chat_id", chat.getId(), "application/json; charset=utf8;");

                    InputFile inputFile = documentMessage.getDocument();
                    Utils.processInputFileField(request, "document", inputFile);

                    if (documentMessage.getCaption() != null)
                        request.field("caption", documentMessage.getCaption(), "application/json; charset=utf8;");

                    Utils.processReplyContent(request, documentMessage);
                    Utils.processNotificationContent(request, documentMessage);

                    response = request.asString();
                    jsonResponse = Utils.processResponse(response);
                } catch (UnirestException e) {
                    e.printStackTrace();
                }

                messageResponse = Utils.checkResponseStatus(jsonResponse) ? (MessageImpl.createMessage(jsonResponse != null ? jsonResponse : null, this)) : null;

                //Document cacheing to FileManager
                if (documentMessage.getDocument().getFile() != null && messageResponse != null) {

                    String fileID;

                    switch (messageResponse.getContent().getType()) {

                        case AUDIO:
                            fileID = ((AudioContent) messageResponse.getContent()).getContent().getFileId();
                            break;
                        case DOCUMENT:
                            fileID = ((DocumentContent) messageResponse.getContent()).getContent().getFileId();
                            break;
                        default:
                            System.err.println("The API returned content type " + messageResponse.getContent().getType().name() + " when a document type was sent, this is not supported by this API, please create an issue on github or message @zackpollard on telegram.");
                            return null;
                    }

                    fileManager.cacheFileID(documentMessage.getDocument().getFile(), fileID);
                }

                break;
            }
            case STICKER: {

                SendableStickerMessage stickerMessage = (SendableStickerMessage) message;

                try {
                    MultipartBody request = Unirest.post(getBotAPIUrl() + "sendSticker")
                            .field("chat_id", chat.getId(), "application/json; charset=utf8;");

                    InputFile inputFile = stickerMessage.getSticker();
                    Utils.processInputFileField(request, "sticker", inputFile);

                    Utils.processReplyContent(request, stickerMessage);
                    Utils.processNotificationContent(request, stickerMessage);

                    response = request.asString();
                    jsonResponse = Utils.processResponse(response);
                } catch (UnirestException e) {
                    e.printStackTrace();
                }

                messageResponse = Utils.checkResponseStatus(jsonResponse) ? (MessageImpl.createMessage(jsonResponse != null ? jsonResponse : null, this)) : null;

                //Sticker cacheing to FileManager
                if (stickerMessage.getSticker().getFile() != null && messageResponse != null) {

                    if (!messageResponse.getContent().getType().equals(ContentType.STICKER)) {

                        System.err.println("The API returned content type " + messageResponse.getContent().getType().name() + " when a " + message.getType() + " type was sent, this is not supported by this API and will break cacheing, please create an issue on github or message @zackpollard on telegram.");
                        break;
                    }

                    Sticker sticker = ((StickerContent) messageResponse.getContent()).getContent();

                    fileManager.cacheFileID(stickerMessage.getSticker().getFile(), sticker.getFileId());
                }

                break;
            }
            case VIDEO: {

                SendableVideoMessage videoMessage = (SendableVideoMessage) message;

                try {
                    MultipartBody request = Unirest.post(getBotAPIUrl() + "sendVideo")
                            .field("chat_id", chat.getId(), "application/json; charset=utf8;");

                    InputFile inputFile = videoMessage.getVideo();
                    Utils.processInputFileField(request, "video", inputFile);

                    if (videoMessage.getDuration() > 0) request.field("duration", videoMessage.getDuration());
                    if (videoMessage.getWidth() > 0) request.field("width", videoMessage.getWidth());
                    if (videoMessage.getHeight() > 0) request.field("height", videoMessage.getHeight());
                    if (videoMessage.getCaption() != null)
                        request.field("caption", videoMessage.getCaption(), "application/json; charset=utf8;");

                    Utils.processReplyContent(request, videoMessage);
                    Utils.processNotificationContent(request, videoMessage);

                    response = request.asString();
                    jsonResponse = Utils.processResponse(response);
                } catch (UnirestException e) {
                    e.printStackTrace();
                }

                messageResponse = Utils.checkResponseStatus(jsonResponse) ? (MessageImpl.createMessage(jsonResponse != null ? jsonResponse : null, this)) : null;

                //Video cacheing to FileManager
                if (videoMessage.getVideo().getFile() != null && messageResponse != null) {

                    if (!messageResponse.getContent().getType().equals(ContentType.VIDEO)) {

                        System.err.println("The API returned content type " + messageResponse.getContent().getType().name() + " when a " + message.getType() + " type was sent, this is not supported by this API and will break cacheing, please create an issue on github or message @zackpollard on telegram.");
                        break;
                    }

                    Video video = ((VideoContent) messageResponse.getContent()).getContent();

                    fileManager.cacheFileID(videoMessage.getVideo().getFile(), video.getFileId());
                }

                break;
            }
            case VIDEO_NOTE: {
                
                SendableVideoNoteMessage videoNoteMessage = (SendableVideoNoteMessage) message;

                try {
                    MultipartBody request = Unirest.post(getBotAPIUrl() + "sendVideo")
                            .field("chat_id", chat.getId(), "application/json; charset=utf8;");

                    InputFile inputFile = videoNoteMessage.getVideoNote();
                    Utils.processInputFileField(request, "video", inputFile);

                    if (videoNoteMessage.getDuration() > 0) request.field("duration", videoNoteMessage.getDuration());
                    if (videoNoteMessage.getLength() > 0) request.field("width", videoNoteMessage.getLength());

                    Utils.processReplyContent(request, videoNoteMessage);
                    Utils.processNotificationContent(request, videoNoteMessage);

                    response = request.asString();
                    jsonResponse = Utils.processResponse(response);
                } catch (UnirestException e) {
                    e.printStackTrace();
                }

                messageResponse = Utils.checkResponseStatus(jsonResponse) ? (MessageImpl.createMessage(jsonResponse != null ? jsonResponse : null, this)) : null;

                //VideoNote cacheing to FileManager
                if (videoNoteMessage.getVideoNote().getFile() != null && messageResponse != null) {

                    if (!messageResponse.getContent().getType().equals(ContentType.VIDEO_NOTE)) {

                        System.err.println("The API returned content type " + messageResponse.getContent().getType().name() + " when a " + message.getType() + " type was sent, this is not supported by this API and will break cacheing, please create an issue on github or message @zackpollard on telegram.");
                        break;
                    }

                    VideoNote videoNote = ((VideoNoteContent) messageResponse.getContent()).getContent();

                    fileManager.cacheFileID(videoNoteMessage.getVideoNote().getFile(), videoNote.getFileId());
                }

                break;
            }
            case VOICE: {

                SendableVoiceMessage voiceMessage = (SendableVoiceMessage) message;

                try {
                    MultipartBody request = Unirest.post(getBotAPIUrl() + "sendVoice")
                            .field("chat_id", chat.getId(), "application/json; charset=utf8;");

                    InputFile inputFile = voiceMessage.getVoice();
                    Utils.processInputFileField(request, "voice", inputFile);

                    if (voiceMessage.getDuration() > 0) request.field("duration", voiceMessage.getDuration());

                    if (voiceMessage.getCaption() != null)
                        request.field("caption", voiceMessage.getCaption(), "application/json; charset=utf8;");

                    Utils.processReplyContent(request, voiceMessage);
                    Utils.processNotificationContent(request, voiceMessage);

                    response = request.asString();
                    jsonResponse = Utils.processResponse(response);
                } catch (UnirestException e) {
                    e.printStackTrace();
                }

                messageResponse = Utils.checkResponseStatus(jsonResponse) ? (MessageImpl.createMessage(jsonResponse != null ? jsonResponse : null, this)) : null;

                //Voice cacheing to FileManager
                if (voiceMessage.getVoice().getFile() != null && messageResponse != null) {

                    if (!messageResponse.getContent().getType().equals(ContentType.VOICE)) {

                        System.err.println("The API returned content type " + messageResponse.getContent().getType().name() + " when a " + message.getType() + " type was sent, this is not supported by this API and will break cacheing, please create an issue on github or message @zackpollard on telegram.");
                        break;
                    }

                    Voice voice = ((VoiceContent) messageResponse.getContent()).getContent();

                    fileManager.cacheFileID(voiceMessage.getVoice().getFile(), voice.getFileId());
                }

                break;
            }
            case LOCATION: {

                SendableLocationMessage locationMessage = (SendableLocationMessage) message;

                try {
                    MultipartBody request = Unirest.post(getBotAPIUrl() + "sendLocation")
                            .field("chat_id", chat.getId(), "application/json; charset=utf8;")
                            .field("latitude", locationMessage.getLatitude())
                            .field("longitude", locationMessage.getLongitude());

                    Utils.processReplyContent(request, locationMessage);
                    Utils.processNotificationContent(request, locationMessage);

                    response = request.asString();
                    jsonResponse = Utils.processResponse(response);
                } catch (UnirestException e) {
                    e.printStackTrace();
                }

                break;
            }
            case VENUE: {

                SendableVenueMessage venueMessage = (SendableVenueMessage) message;

                try {

                    MultipartBody request = Unirest.post(getBotAPIUrl() + "sendLocation")
                            .field("chat_id", chat.getId(), "application/json; charset=utf8;")
                            .field("latitude", venueMessage.getLatitude())
                            .field("longitude", venueMessage.getLongitude())
                            .field("title", venueMessage.getTitle())
                            .field("address", venueMessage.getAddress());

                    if (venueMessage.getFoursquareId() != null)
                        request.field("foursquare_id", venueMessage.getFoursquareId());

                    Utils.processReplyContent(request, venueMessage);
                    Utils.processNotificationContent(request, venueMessage);

                    response = request.asString();
                    jsonResponse = Utils.processResponse(response);
                } catch (UnirestException e) {
                    e.printStackTrace();
                }

                break;
            }
            case GAME: {

                SendableGameMessage gameMessage = (SendableGameMessage) message;

                try {
                    MultipartBody request = Unirest.post(getBotAPIUrl() + "sendGame")
                            .field("chat_id", chat.getId(), "application/json; charset=utf8;")
                            .field("game_short_name", gameMessage.getGameShortName(), "application/json; charset=utf8;");

                    Utils.processReplyContent(request, gameMessage);
                    Utils.processNotificationContent(request, gameMessage);

                    response = request.asString();
                    jsonResponse = Utils.processResponse(response);
                } catch (UnirestException e) {
                    e.printStackTrace();
                }

                break;
            }
            case CHAT_ACTION: {

                SendableChatAction sendableChatAction = (SendableChatAction) message;

                try {
                    MultipartBody request = Unirest.post(getBotAPIUrl() + "sendChatAction")
                            .field("chat_id", chat.getId(), "application/json; charset=utf8;")
                            .field("action", sendableChatAction.getChatAction().getName());

                    response = request.asString();
                } catch (UnirestException e) {
                    e.printStackTrace();
                }

                return null;
            }
        }

        return Utils.checkResponseStatus(jsonResponse) ? (messageResponse != null ? messageResponse : MessageImpl.createMessage(jsonResponse, this)) : null;
    }

    private JSONObject editMessageText(String chatId, Long messageId, String inlineMessageId, String text, ParseMode parseMode, boolean disableWebPagePreview, InlineReplyMarkup inlineReplyMarkup) {

        HttpResponse<String> response;
        JSONObject jsonResponse = null;

        try {
            MultipartBody requests = Unirest.post(getBotAPIUrl() + "editMessageText")
                    .field("text", text, "application/json; charset=utf8;")
                    .field("disable_web_page_preview", disableWebPagePreview);

            if(chatId != null) requests.field("chat_id", chatId, "application/json; charset=utf8;");
            if(messageId != null) requests.field("message_id", messageId);
            if(inlineMessageId != null) requests.field("inline_message_id", inlineMessageId, "application/json; charset=utf8;");
            if(parseMode != null) requests.field("parse_mode", parseMode.getModeName(), "application/json; charset=utf8;");
            if(inlineReplyMarkup != null) requests.field("reply_markup", GSON.toJson(inlineReplyMarkup, InlineKeyboardMarkup.class), "application/json; charset=utf8;");

            response = requests.asString();
            jsonResponse = Utils.processResponse(response);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return jsonResponse;
    }

    /**
     * This allows you to edit the text of a message you have already sent previously
     *
     * @param oldMessage                The Message object that represents the message you want to edit
     * @param text                      The new text you want to display
     * @param parseMode                 The ParseMode that should be used with this new text
     * @param disableWebPagePreview     Whether any URLs should be displayed with a preview of their content
     * @param inlineReplyMarkup         Any InlineReplyMarkup object you want to edit into the message
     *
     * @return A new Message object representing the edited message
     */
    public Message editMessageText(Message oldMessage, String text, ParseMode parseMode, boolean disableWebPagePreview, InlineReplyMarkup inlineReplyMarkup) {

        return this.editMessageText(oldMessage.getChat().getId(), oldMessage.getMessageId(), text, parseMode, disableWebPagePreview, inlineReplyMarkup);
    }

    /**
     * This allows you to edit the text of a message you have already sent previously
     *
     * @param chatId                    The chat ID of the chat containing the message you want to edit
     * @param messageId                 The message ID of the message you want to edit
     * @param text                      The new text you want to display
     * @param parseMode                 The ParseMode that should be used with this new text
     * @param disableWebPagePreview     Whether any URLs should be displayed with a preview of their content
     * @param inlineReplyMarkup         Any InlineReplyMarkup object you want to edit into the message
     *
     * @return A new Message object representing the edited message
     */
    public Message editMessageText(String chatId, Long messageId, String text, ParseMode parseMode, boolean disableWebPagePreview, InlineReplyMarkup inlineReplyMarkup) {

        if(chatId != null && messageId != null && text != null) {

            JSONObject jsonResponse = this.editMessageText(chatId, messageId, null, text, parseMode, disableWebPagePreview, inlineReplyMarkup);

            if (jsonResponse != null) {

                return MessageImpl.createMessage(jsonResponse.getJSONObject("result"), this);
            }
        }

        return null;
    }

    /**
     * This allows you to edit the text of an inline message you have sent previously. (The inline message must have an
     * InlineReplyMarkup object attached in order to be editable)
     *
     * @param inlineMessageId           The ID of the inline message you want to edit
     * @param text                      The new text you want to display
     * @param parseMode                 The ParseMode that should be used with this new text
     * @param disableWebPagePreview     Whether any URLs should be displayed with a preview of their content
     * @param inlineReplyMarkup         Any InlineReplyMarkup object you want to edit into the message
     *
     * @return True if the edit succeeded, otherwise false
     */
    public boolean editInlineMessageText(String inlineMessageId, String text, ParseMode parseMode, boolean disableWebPagePreview, InlineReplyMarkup inlineReplyMarkup) {

        if(inlineMessageId != null && text != null) {

            JSONObject jsonResponse = this.editMessageText(null, null, inlineMessageId, text, parseMode, disableWebPagePreview, inlineReplyMarkup);

            if (jsonResponse != null) {

                if (jsonResponse.getBoolean("result")) return true;
            }
        }

        return false;
    }

    private JSONObject editMessageCaption(String chatId, Long messageId, String inlineMessageId, String caption, InlineReplyMarkup inlineReplyMarkup) {

        HttpResponse<String> response;
        JSONObject jsonResponse = null;

        try {
            MultipartBody requests = Unirest.post(getBotAPIUrl() + "editMessageCaption")
                    .field("caption", caption, "application/json; charset=utf8;");

            if(chatId != null) requests.field("chat_id", chatId, "application/json; charset=utf8;");
            if(messageId != null) requests.field("message_id", messageId);
            if(inlineMessageId != null) requests.field("inline_message_id", inlineMessageId, "application/json; charset=utf8;");
            if(inlineReplyMarkup != null) requests.field("reply_markup", GSON.toJson(inlineReplyMarkup, InlineKeyboardMarkup.class), "application/json; charset=utf8;");

            response = requests.asString();
            jsonResponse = Utils.processResponse(response);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return jsonResponse;
    }

    /**
     * This allows you to edit the caption of any captionable message you have sent previously
     *
     * @param oldMessage            The Message object that represents the message you want to edit
     * @param caption               The new caption you want to display
     * @param inlineReplyMarkup     Any InlineReplyMarkup object you want to edit into the message
     *
     * @return A new Message object representing the edited message
     */
    public Message editMessageCaption(Message oldMessage, String caption, InlineReplyMarkup inlineReplyMarkup) {

        return this.editMessageCaption(oldMessage.getChat().getId(), oldMessage.getMessageId(), caption, inlineReplyMarkup);
    }

    /**
     * This allows you to edit the caption of any captionable message you have sent previously
     *
     * @param chatId                The chat ID of the chat containing the message you want to edit
     * @param messageId             The message ID of the message you want to edit
     * @param caption               The new caption you want to display
     * @param inlineReplyMarkup     Any InlineReplyMarkup object you want to edit into the message
     *
     * @return A new Message object representing the edited message
     */
    public Message editMessageCaption(String chatId, Long messageId, String caption, InlineReplyMarkup inlineReplyMarkup) {

        if(caption != null && chatId != null && messageId != null) {

            JSONObject jsonResponse = this.editMessageCaption(chatId, messageId, null, caption, inlineReplyMarkup);

            if(jsonResponse != null) {

                return MessageImpl.createMessage(jsonResponse.getJSONObject("result"), this);
            }
        }

        return null;
    }

    /**
     * This allows you to edit the caption of any captionable inline message you have sent previously (The inline
     * message must have an InlineReplyMarkup object attached in order to be editable)
     *
     * @param inlineMessageId       The ID of the inline message you want to edit
     * @param caption               The new caption you want to display
     * @param inlineReplyMarkup     Any InlineReplyMarkup object you want to edit into the message
     *
     * @return True if the edit succeeded, otherwise False
     */
    public boolean editInlineCaption(String inlineMessageId, String caption, InlineReplyMarkup inlineReplyMarkup) {

        if(caption != null && inlineReplyMarkup != null) {

            JSONObject jsonResponse = this.editMessageCaption(null, null, inlineMessageId, caption, inlineReplyMarkup);

            if(jsonResponse != null) {

                if(jsonResponse.getBoolean("result")) return true;
            }
        }

        return false;
    }

    private JSONObject editMessageReplyMarkup(String chatId, Long messageId, String inlineMessageId, InlineReplyMarkup inlineReplyMarkup) {

        HttpResponse<String> response;
        JSONObject jsonResponse = null;

        try {
            MultipartBody requests = Unirest.post(getBotAPIUrl() + "editMessageReplyMarkup")
                    .field("reply_markup", GSON.toJson(inlineReplyMarkup, InlineKeyboardMarkup.class), "application/json; charset=utf8;");

            if(chatId != null) requests.field("chat_id", chatId, "application/json; charset=utf8;");
            if(messageId != null) requests.field("message_id", messageId);
            if(inlineMessageId != null) requests.field("inline_message_id", inlineMessageId, "application/json; charset=utf8;");

            response = requests.asString();
            jsonResponse = Utils.processResponse(response);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return jsonResponse;
    }

    /**
     * This allows you to edit the InlineReplyMarkup of any message that you have sent previously.
     *
     * @param oldMessage            The Message object that represents the message you want to edit
     * @param inlineReplyMarkup     Any InlineReplyMarkup object you want to edit into the message
     *
     * @return A new Message object representing the edited message
     */
    public Message editMessageReplyMarkup(Message oldMessage, InlineReplyMarkup inlineReplyMarkup) {

        return this.editMessageReplyMarkup(oldMessage.getChat().getId(), oldMessage.getMessageId(), inlineReplyMarkup);
    }

    /**
     * This allows you to edit the InlineReplyMarkup of any message that you have sent previously.
     *
     * @param chatId                The chat ID of the chat containing the message you want to edit
     * @param messageId             The message ID of the message you want to edit
     * @param inlineReplyMarkup     Any InlineReplyMarkup object you want to edit into the message
     *
     * @return A new Message object representing the edited message
     */
    public Message editMessageReplyMarkup(String chatId, Long messageId, InlineReplyMarkup inlineReplyMarkup) {

        if(inlineReplyMarkup != null && chatId != null && messageId != null) {

            JSONObject jsonResponse = this.editMessageReplyMarkup(chatId, messageId, null, inlineReplyMarkup);

            if(jsonResponse != null) {

                return MessageImpl.createMessage(jsonResponse.getJSONObject("result"), this);
            }
        }

        return null;
    }

    /**
     * This allows you to edit the InlineReplyMarkup of any inline message that you have sent previously. (The inline
     * message must have an InlineReplyMarkup object attached in order to be editable)
     *
     * @param inlineMessageId The ID of the inline message you want to edit
     * @param inlineReplyMarkup Any InlineReplyMarkup object you want to edit into the message
     *
     * @return True if the edit succeeded, otherwise False
     */
    public boolean editInlineMessageReplyMarkup(String inlineMessageId, InlineReplyMarkup inlineReplyMarkup) {

        if(inlineMessageId != null && inlineReplyMarkup != null) {

            JSONObject jsonResponse = this.editMessageReplyMarkup(null, null, inlineMessageId, inlineReplyMarkup);

            if(jsonResponse != null) {

                if(jsonResponse.getBoolean("result")) return true;
            }
        }

        return false;
    }
    
    public boolean deleteMessage(Message message) {
        return this.deleteMessage(message.getChat().getId(), message.getMessageId());
    }
    
    public boolean deleteMessage(String chatId, Long messageId) {
        if(chatId != null && messageId != null) {

            HttpResponse<String> response;
            JSONObject jsonResponse = null;

            try {
                MultipartBody requests = Unirest.post(getBotAPIUrl() + "deleteMessage")
                        .field("chat_id", chatId, "application/json; charset=utf8;")
                        .field("message_id", messageId);

                response = requests.asString();
                jsonResponse = Utils.processResponse(response);
            } catch (UnirestException e) {
                e.printStackTrace();
            }

            if(jsonResponse != null) {

                if(jsonResponse.getBoolean("result")) return true;
            }
        }

        return false;
    }

    /**
     * This allows you to respond to an inline query with an InlineQueryResponse object
     *
     * @param inlineQueryId         The ID of the inline query you are responding to
     * @param inlineQueryResponse   The InlineQueryResponse object that you want to send to the user
     *
     * @return True if the response was sent successfully, otherwise False
     */
    public boolean answerInlineQuery(String inlineQueryId, InlineQueryResponse inlineQueryResponse) {

        if (inlineQueryId != null && inlineQueryResponse != null) {

            HttpResponse<String> response;
            JSONObject jsonResponse;

            try {
                MultipartBody requests = Unirest.post(getBotAPIUrl() + "answerInlineQuery")
                        .field("inline_query_id", inlineQueryId)
                        .field("results", GSON.toJson(inlineQueryResponse.getResults()))
                        .field("cache_time", inlineQueryResponse.getCacheTime())
                        .field("is_personal", inlineQueryResponse.isPersonal())
                        .field("next_offset", inlineQueryResponse.getNextOffset())
                        .field("switch_pm_text", inlineQueryResponse.getSwitchPmText())
                        .field("switch_pm_parameter", inlineQueryResponse.getSwitchPmParameter());

                response = requests.asString();
                jsonResponse = Utils.processResponse(response);

                if (jsonResponse != null) {

                    if (jsonResponse.getBoolean("result")) return true;
                }
            } catch (UnirestException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    /**
     * This allows you to respond to a callback query with some text as a response. This will either show up as an
     * alert or as a toast on the telegram client
     *
     * @param callbackQueryId   The ID of the callback query you are responding to
     * @param text              The text you would like to respond with
     * @param showAlert         True will show the text as an alert, false will show it as a toast notification
     *
     * @deprecated  This method is deprecated in favour of the {@link #answerCallbackQuery(String, CallbackQueryResponse)}
     *              method, this should be used for all new implementations
     *
     * @return True if the response was sent successfully, otherwise False
     */
    @Deprecated
    public boolean answerCallbackQuery(String callbackQueryId, String text, boolean showAlert) {

        return this.answerCallbackQuery(callbackQueryId, CallbackQueryResponse.builder().text(text).showAlert(showAlert).build());
    }

    /**
     * This allows you to respond to a callback query with some text as a response. This will either show up as an
     * alert or as a toast on the telegram client
     *
     * @param callbackQueryId       The ID of the callback query you are responding to
     * @param callbackQueryResponse The response that you would like to send in reply to this callback query
     *
     * @return True if the response was sent successfully, otherwise False
     */
    public boolean answerCallbackQuery(String callbackQueryId, CallbackQueryResponse callbackQueryResponse) {

        if(callbackQueryId != null && callbackQueryResponse.getText() != null) {

            HttpResponse<String> response;
            JSONObject jsonResponse;

            try {
                MultipartBody requests = Unirest.post(getBotAPIUrl() + "answerCallbackQuery")
                        .field("callback_query_id", callbackQueryId, "application/json; charset=utf8;")
                        .field("text", callbackQueryResponse.getText(), "application/json; charset=utf8;")
                        .field("show_alert", callbackQueryResponse.isShowAlert())
                        .field("cache_time", callbackQueryResponse.getCacheTime())
                        .field("url", callbackQueryResponse.getURL() != null ? callbackQueryResponse.getURL().toExternalForm() : null, "application/json; charset=utf8;");


                response = requests.asString();
                jsonResponse = Utils.processResponse(response);

                if (jsonResponse != null) {

                    if (jsonResponse.getBoolean("result")) return true;
                }
            } catch (UnirestException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    /**
     * Use this method to kick a user from a group or a supergroup. In the case of supergroups, the user will not be
     * able to return to the group on their own using invite links, etc., unless unbanned first. The bot must be
     * an administrator in the group for this to work
     *
     * @param chatId    The ID of the chat that you want to kick the user from
     * @param userId    The ID of the user that you want to kick from the chat
     *
     * @return True if the user was kicked successfully, otherwise False
     */
    public boolean kickChatMember(String chatId, int userId, long until_date) {

        HttpResponse<String> response;
        JSONObject jsonResponse;

        try {
            MultipartBody request = Unirest.post(getBotAPIUrl() + "kickChatMember")
                    .field("chat_id", chatId, "application/json; charset=utf8;")
                    .field("user_id", userId)
                    .field("until_date", until_date);

            response = request.asString();
            jsonResponse = Utils.processResponse(response);

            if(jsonResponse != null) {

                if(jsonResponse.getBoolean("result")) return true;
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Use this method to unban a previously kicked user in a supergroup. The user will not return to the group
     * automatically, but will be able to join via link, etc. The bot must be an administrator in the group for
     * this to work
     *
     * @param chatId    The ID of the chat that you want to unban the user from
     * @param userId    The ID of the user that you want to unban from the chat
     *
     * @return True if the user was unbanned, otherwise False
     */
    public boolean unbanChatMember(String chatId, int userId) {

        HttpResponse<String> response;
        JSONObject jsonResponse;

        try {
            MultipartBody request = Unirest.post(getBotAPIUrl() + "unbanChatMember")
                    .field("chat_id", chatId, "application/json; charset=utf8;")
                    .field("user_id", userId);

            response = request.asString();
            jsonResponse = Utils.processResponse(response);

            if(jsonResponse != null) {

                if(jsonResponse.getBoolean("result")) return true;
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Use this method to restrict a user in a supergroup. The bot must be an administrator in the supergroup for this
     * to work and must have the appropriate admin rights. Pass True for all boolean parameters to lift restrictions
     * from a user
     *
     * @param chatId            The ID of the chat that you want to restrict the user in
     * @param userId            The ID of the user that you want to restrict
     * @param userRestrictions  The UserRestrictions object containing the restrictions you want to place on the user
     *
     * @return Returns True if the restrictions were applied successfully, False otherwise
     */
    public boolean restrictChatMember(String chatId, int userId, UserRestrictions userRestrictions) {

        HttpResponse<String> response;
        JSONObject jsonResponse;

        try {
            MultipartBody request = Unirest.post(getBotAPIUrl() + "restrictChatMember")
                    .field("chat_id", chatId, "application/json; charset=utf8;")
                    .field("user_id", userId)
                    .field("until_date", userRestrictions.getUntilDate())
                    .field("can_send_messages", userRestrictions.getCanSendMessages())
                    .field("can_send_media_messages", userRestrictions.getCanSendMediaMessages())
                    .field("can_send_other_messages", userRestrictions.getCanSendOtherMessages())
                    .field("can_add_web_page_previews", userRestrictions.getCanAddWebPagePreviews());

            response = request.asString();
            jsonResponse = Utils.processResponse(response);

            if(jsonResponse != null) {

                if(jsonResponse.getBoolean("result")) return true;
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return false;
    }

    public GameScoreEditResponse setGameScore(SendableGameScore sendableGameScore) {

        HttpResponse<String> response;
        JSONObject jsonResponse;

        try {
            MultipartBody request = Unirest.post(getBotAPIUrl() + "setGameScore")
                    .field("user_id", sendableGameScore.getUserId(), "application/json; charset=utf8;")
                    .field("score", sendableGameScore.getScore())
                    .field("force", sendableGameScore.isForce())
                    .field("disable_edit_message", sendableGameScore.isDisableEditMessage())
                    .field("chat_id", sendableGameScore.getChatId())
                    .field("message_id", sendableGameScore.getMessageId())
                    .field("inline_message_id", sendableGameScore.getInlineMessageId());

            response = request.asString();
            jsonResponse = Utils.processResponse(response);

            if(jsonResponse != null) {

                return GameScoreEditResponseImpl.createGameScoreEditResponse(jsonResponse.getJSONObject("result"), this);
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<GameHighScore> getGameHighScores(GameScoreRequest gameScoreRequest) {

        HttpResponse<String> response;
        JSONObject jsonResponse;

        try {
            MultipartBody request = Unirest.post(getBotAPIUrl() + "setGameScore")
                    .field("user_id", gameScoreRequest.getUserId(), "application/json; charset=utf8;")
                    .field("chat_id", gameScoreRequest.getChatId())
                    .field("message_id", gameScoreRequest.getMessageId())
                    .field("inline_message_id", gameScoreRequest.getInlineMessageId());

            response = request.asString();
            jsonResponse = Utils.processResponse(response);

            if (jsonResponse != null) {

                List<GameHighScore> highScores = new LinkedList<>();

                for (Object object : jsonResponse.getJSONArray("result")) {

                    JSONObject jsonObject = (JSONObject) object;

                    highScores.add(GameHighScoreImpl.createGameHighscore(jsonObject));
                }

                return highScores;
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Use this method to start the update thread which will begin retrieving messages from the API and firing the
     * relevant events for you to process the data
     *
     * @param getPreviousUpdates Whether you want to retrieve any updates that haven't been processed before, but were
     *                           created prior to calling the startUpdates method
     * @return True if the updater was started, otherwise False
     */
    public boolean startUpdates(boolean getPreviousUpdates) {

        if(updateManager == null) updateManager = new RequestUpdatesManager(this, getPreviousUpdates);

        if(!updateManager.isRunning()) {

            updateManager.startUpdates();
            return true;
        }

        return false;
    }

    /**
     * Calling this method will stop the updater from running and therefore no more events will be fired
     */
    public void stopUpdates() {

        updateManager.stopUpdates();
    }

    /**
     * This provides access to the events manager which can be used to register and unregister Listeners
     *
     * @return The current events manager as a ListenerRegistry object
     */
    public ListenerRegistry getEventsManager() {

        return listenerRegistry;
    }
}
