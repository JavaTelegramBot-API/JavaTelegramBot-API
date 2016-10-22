package pro.zackpollard.telegrambot.api.event;

/**
 * @author Zack Pollard
 */
public interface ListenerRegistry {

    /**
     * Use this method to register a Listener
     *
     * @param listener The Listener you want to register
     */
    void register(Listener listener);

    /**
     * Use this method to unregister a Listener
     *
     * @param listener The Listener you want to unregister
     */
    void unregister(Listener listener);
}
