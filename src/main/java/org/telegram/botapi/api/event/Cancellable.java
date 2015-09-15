package org.telegram.botapi.api.event;

/**
 * @author Zack Pollard
 */
public interface Cancellable {

	/**
	 * Gets the cancellation state of this event. A cancelled event will not
	 * be executed in the API, but will still pass to other registered listeners
	 *
	 * @return true if this event is cancelled
	 */
	boolean isCancelled();

	/**
	 * Sets the cancellation state of this event. A cancelled event will not
	 * be executed in the API, but will still pass to other registered listeners.
	 *
	 * @param cancel true if you wish to cancel this event
	 */
	void setCancelled(boolean cancel);
}
