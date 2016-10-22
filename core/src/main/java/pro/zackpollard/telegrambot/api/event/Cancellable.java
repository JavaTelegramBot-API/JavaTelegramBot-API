package pro.zackpollard.telegrambot.api.event;

/**
 * @author DarkSeraphim.
 */
public interface Cancellable {
    void setCancelled(boolean cancelled);

    boolean isCancelled();
}
