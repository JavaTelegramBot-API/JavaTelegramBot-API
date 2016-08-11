package pro.zackpollard.telegrambot.api.chat;

/**
 * @author Zack Pollard
 */
public interface ChannelChat extends Chat {

    String getUsername();

    default ChatType getType() {

        return ChatType.CHANNEL;
    }
}
