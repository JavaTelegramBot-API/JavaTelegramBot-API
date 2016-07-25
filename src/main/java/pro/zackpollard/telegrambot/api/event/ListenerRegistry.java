package pro.zackpollard.telegrambot.api.event;

/**
 * @author Zack Pollard
 */
public interface ListenerRegistry {

    void register(Listener listener);

    void unregister(Listener listener);
}
