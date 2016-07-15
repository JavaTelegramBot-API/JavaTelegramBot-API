package pro.zackpollard.telegrambot.api.chat.message.content.type;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;

import java.io.IOException;
import java.net.URL;

/**
 * @author Zack Pollard
 */
public interface File {

    /**
     * Gets the Unique Identifier for this file
     *
     * @return The files ID
     */
    String getFileId();

    /**
     * Gets the size of the file
     *
     * @return The file size
     */
    int getSize();

    default String getFileDownloadLink(TelegramBot telegramBot) {

        JSONObject jsonObject = null;

        try {
            jsonObject = Unirest.post(telegramBot.getBotAPIUrl() + "getFile")
                    .field("file_id", getFileId(), "application/json; charset=utf8;")
                    .asJson().getBody().getObject();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        if (jsonObject != null) {

            if (jsonObject.getBoolean("ok")) {

                return "https://api.telegram.org/file/bot" + telegramBot.getAuthToken() + "/" + jsonObject.getJSONObject("result").getString("file_path");
            }
        }

        return null;
    }

    default java.io.File downloadFile(TelegramBot telegramBot, java.io.File downloadLocation) {

        String downloadLink = getFileDownloadLink(telegramBot);

        if (downloadLink != null) {

            try {
                FileUtils.copyURLToFile(new URL(downloadLink), downloadLocation);
            } catch (IOException e) {

                System.err.println("The file download failed due to the provided URL being malformed in some way. Provided URL was " + downloadLink);
            }
        }

        return downloadLocation;
    }
}