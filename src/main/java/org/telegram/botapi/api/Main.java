package org.telegram.botapi.api;

import org.telegram.botapi.api.chat.message.send.InputFile;
import org.telegram.botapi.api.chat.message.send.SendableLocationMessage;
import org.telegram.botapi.api.chat.message.send.SendablePhotoMessage;
import org.telegram.botapi.api.chat.message.send.SendableTextMessage;
import org.telegram.botapi.api.keyboards.ReplyKeyboardHide;
import org.telegram.botapi.api.keyboards.ReplyKeyboardMarkup;
import org.telegram.botapi.api.updates.UpdateManager;

import java.io.File;

/**
 * @author Zack Pollard
 */
public class Main {

	public static void main(String[] args) {

		TelegramBot telegramBot = TelegramBot.login("76680143:AAFa8pL7MpseM8MsmJq8TS5H495mHmrDW2I");

		telegramBot.setUpdateMethod(UpdateManager.UpdateMethod.REQUEST_UPDATES);

		while(true) {

			//lelelel
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		/**telegramBot.sendMessage(TelegramBot.getChat(-17349250), SendableAudioMessage.builder().audio(new InputFile(new File("D:\\OwnCloud\\Music\\Taylor Swift - Red\\Taylor Swift - 22.mp3"))).title("22").build());

		 telegramBot.sendMessage(TelegramBot.getChat(-17349250), SendablePhotoMessage.builder().photo(new InputFile(new File("D:\\OwnCloud\\Pictures\\Wallpapers\\Aston Martin Supercars_Ultra HD.jpg"))).build());
		 */
		/**telegramBot.sendMessage(TelegramBot.getChat(-17349250),
				SendablePhotoMessage.builder()
						.photo(new InputFile(new File("D:\\OwnCloud\\Pictures\\Wallpapers\\Aston Martin Supercars_Ultra HD.jpg")))
						.caption("Is this image sexy?")
						.replyMarkup(ReplyKeyboardMarkup.builder().oneTime(true).resize(true).addRow("Yes", "No").build()
						).build()
		);

		telegramBot.sendMessage(TelegramBot.getChat(-17349250), SendableTextMessage.builder().message("So this should make the keyboard vanish???").replyMarkup(ReplyKeyboardHide.builder().build()).build());
		 */
		/**
		telegramBot.sendMessage(TelegramBot.getChat(-17349250), SendableLocationMessage.builder().longitude(4.53487).latitude(52.1916).build());
		*/
		/**
		 HttpResponse<JsonNode> jsonResponse = null;

		 try {

		 jsonResponse = Unirest.post("https://api.telegram.org/bot76680143:AAHS9ApwB1e6FV1UFbTCvQL3iTiV6B-iAiw/sendPhoto")
		 .field("chat_id", -17349250)
		 .field("photo", "AgADAgADTvwxG176WQdNr9iIrX2qbepKhCoABM2yeWaynIeCoEUAAgI")
		 .field("caption", (String) null).asJson();

		 System.out.println(jsonResponse.getBody().getObject());

		 Message message = MessageImpl.createMessage(jsonResponse.getBody().getObject());

		 System.out.println(message.getContent().getType());
		 System.out.println(((PhotoContent) message.getContent()).getCaption());


		 jsonResponse = Unirest.post("https://api.telegram.org/bot76680143:AAHS9ApwB1e6FV1UFbTCvQL3iTiV6B-iAiw/sendChatAction")
		 .queryString("chat_id", -17349250)
		 .queryString("action", "find_location").asJson();

		 System.out.println(jsonResponse.getBody().getObject());


		 jsonResponse = Unirest.post("https://api.telegram.org/bot76680143:AAHS9ApwB1e6FV1UFbTCvQL3iTiV6B-iAiw/sendMessage")
		 .queryString("chat_id", -17349250)
		 .queryString("text", "Boet, you're unnecessary").asJson();

		 System.out.println(jsonResponse.getBody().getObject());

		 message = MessageImpl.createMessage(jsonResponse.getBody().getObject());

		 System.out.println(message.forwardMessage(message.getChat(), telegramBot));

		 jsonResponse = Unirest.post("https://api.telegram.org/bot76680143:AAHS9ApwB1e6FV1UFbTCvQL3iTiV6B-iAiw/forwardMessage")
		 .queryString("chat_id", -17349250)
		 .queryString("from_chat_id", -17349250)
		 .queryString("message_id", 111).asJson();

		 System.out.println(jsonResponse.getBody().toString());
		 } catch (UnirestException e) {
		 e.printStackTrace();
		 }*/
	}
}
