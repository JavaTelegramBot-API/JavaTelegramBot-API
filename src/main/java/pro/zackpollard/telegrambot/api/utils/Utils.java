package pro.zackpollard.telegrambot.api.utils;

import java.util.Random;

/**
 * @author Zack Pollard
 */
public class Utils {

    public static String generateRandomString(int length) {

        char[] chars = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }

        return sb.toString();
    }
}
