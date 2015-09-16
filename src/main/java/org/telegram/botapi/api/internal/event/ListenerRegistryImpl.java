package org.telegram.botapi.api.internal.event;

import org.telegram.botapi.api.event.Event;
import org.telegram.botapi.api.event.Listener;
import org.telegram.botapi.api.event.ListenerRegistry;
import org.telegram.botapi.api.event.chat.*;
import org.telegram.botapi.api.event.chat.message.*;

import java.lang.reflect.Method;
import java.util.*;
import java.util.function.BiConsumer;

/**
 * @author DarkSeraphim.
 */
public class ListenerRegistryImpl implements ListenerRegistry {

	private final Map<Class<?>, BiConsumer<Listener, ? extends Event>> invokers = new HashMap<Class<?>, BiConsumer<Listener, ? extends Event>>() {{
		register(AudioMessageReceivedEvent.class, Listener::on);
		register(ContactMessageReceivedEvent.class, Listener::on);
		register(DocumentMessageReceivedEvent.class, Listener::on);
		register(LocationMessageReceivedEvent.class, Listener::on);
		register(MessageReceivedEvent.class, Listener::on);
		register(PhotoMessageReceivedEvent.class, Listener::on);
		register(StickerMessageReceivedEvent.class, Listener::on);
		register(TextMessageReceivedEvent.class, Listener::on);
		register(VideoMessageReceivedEvent.class, Listener::on);
		register(VoiceMessageReceivedEvent.class, Listener::on);

		register(DeleteGroupChatPhotoEvent.class, Listener::on);
		register(GroupChatCreatedEvent.class, Listener::on);
		register(NewGroupChatPhotoEvent.class, Listener::on);
		register(NewGroupChatTitleEvent.class, Listener::on);
		register(ParticipantJoinGroupChatEvent.class, Listener::on);
		register(ParticipantLeaveGroupChatEvent.class, Listener::on);
	}

		private <T extends Event> void register(Class<T> clazz, BiConsumer<Listener, T> invoker) {
			this.put(clazz, invoker);
		}
	};

	// LinkedHashSet for iteration speed
	private final Map<Class<?>, Set<Listener>> listenerByContent = new HashMap<>();

	public void register(Listener listener) {
		for (Method m : listener.getClass().getDeclaredMethods()) {
			Class<?>[] classes = m.getParameterTypes();
			if (classes.length == 1) {
				Set<Listener> listeners = listenerByContent.computeIfAbsent(classes[0], (c) -> new LinkedHashSet<>());
				listeners.add(listener);
			}
		}
	}

	public void callEvent(Event event) {
		BiConsumer<Listener, Event> invoker = (BiConsumer<Listener, Event>) this.invokers.get(event.getClass());
		listenerByContent.getOrDefault(event.getClass(), Collections.emptySet()).forEach(listener -> invoker.accept(listener, event));
	}

	private ListenerRegistryImpl() {
	}

	public static ListenerRegistry getNewInstance() {

		return new ListenerRegistryImpl();
	}
}