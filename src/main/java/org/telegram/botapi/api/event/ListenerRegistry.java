package org.telegram.botapi.api.event;

/**
 * @author Zack Pollard
 */
public interface ListenerRegistry {

    void register(Listener listener);
}
