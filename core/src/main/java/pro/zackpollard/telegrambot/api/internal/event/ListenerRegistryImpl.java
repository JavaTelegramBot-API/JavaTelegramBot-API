package pro.zackpollard.telegrambot.api.internal.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pro.zackpollard.telegrambot.api.event.Cancellable;
import pro.zackpollard.telegrambot.api.event.Event;
import pro.zackpollard.telegrambot.api.event.Listener;
import pro.zackpollard.telegrambot.api.event.ListenerRegistry;
import pro.zackpollard.telegrambot.api.event.chat.*;
import pro.zackpollard.telegrambot.api.event.chat.inline.InlineCallbackQueryReceivedEvent;
import pro.zackpollard.telegrambot.api.event.chat.inline.InlineQueryReceivedEvent;
import pro.zackpollard.telegrambot.api.event.chat.inline.InlineResultChosenEvent;
import pro.zackpollard.telegrambot.api.event.chat.message.*;

import java.lang.reflect.Method;
import java.util.*;
import java.util.function.BiConsumer;

/**
 * @author DarkSeraphim.
 */
public class ListenerRegistryImpl implements ListenerRegistry {

    private static class PrioritisedSet<E> implements Iterable<E> {

        private static final Event.Priority[] PRIORITIES = Event.Priority.values();

        private static final PrioritisedSet EMPTY = new PrioritisedSet();

        private Map<Event.Priority, Set<E>> priorised = new EnumMap<>(Event.Priority.class);

        private Map<E, Event.Priority> byListener = new HashMap<>();

        public void add(Event.Priority p, E e) {
            if (this.byListener.putIfAbsent(e, p) != p) {
                this.priorised.computeIfAbsent(p, $ -> new LinkedHashSet<>()).add(e);
            }
        }

        public boolean remove(E e) {
            Event.Priority p = this.byListener.remove(e);
            if (p != null) {
                return this.priorised.getOrDefault(e, Collections.emptySet()).remove(e);
            }
            return false;
        }

        public static <E> PrioritisedSet<E> empty() {
            return EMPTY;
        }

        public int size() {
            return this.priorised.values().stream().map(Collection::size).reduce(Integer::sum).orElse(0);
        }

        @Override
        public Iterator<E> iterator() {
            return new Iterator<E>() {
                private int priorityIndex = 0;

                private Iterator<E> iterator;

                private void findNextIterator() {
                    while ((this.iterator == null || !this.iterator.hasNext())) {
                        if (this.priorityIndex >= PRIORITIES.length) {
                            break;
                        }
                        this.iterator = priorised.getOrDefault(PRIORITIES[priorityIndex++], Collections.emptySet()).iterator();
                    }
                }

                @Override
                public boolean hasNext() {
                    findNextIterator();
                    return this.iterator != null && this.iterator.hasNext();
                }

                @Override
                public E next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    return this.iterator.next();
                }
            };
        }
    }

    @RequiredArgsConstructor
    @Getter
    private static class RegisteredListener {
        private final Listener listener;

        private final Class<?> eventType;

        private final boolean ignoreCancelled;

        @Override
        public int hashCode() {
            return Objects.hash(this.listener, this.eventType);
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof RegisteredListener && Objects.equals(((RegisteredListener) obj).getListener(), listener);
        }
    }

    private final Map<Class<?>, BiConsumer<Listener, ? extends Event>> invokers = new HashMap<Class<?>, BiConsumer<Listener, ? extends Event>>() {
        {
            register(AudioMessageReceivedEvent.class, Listener::onAudioMessageReceived);
            register(CommandMessageReceivedEvent.class, Listener::onCommandMessageReceived);
            register(ContactMessageReceivedEvent.class, Listener::onContactMessageReceived);
            register(DocumentMessageReceivedEvent.class, Listener::onDocumentMessageReceived);
            register(LocationMessageReceivedEvent.class, Listener::onLocationMessageReceived);
            register(MessageReceivedEvent.class, Listener::onMessageReceived);
            register(MessageEditReceivedEvent.class, Listener::onMessageEditReceived);
            register(PhotoMessageReceivedEvent.class, Listener::onPhotoMessageReceived);
            register(StickerMessageReceivedEvent.class, Listener::onStickerMessageReceived);
            register(TextMessageReceivedEvent.class, Listener::onTextMessageReceived);
            register(VideoMessageReceivedEvent.class, Listener::onVideoMessageReceived);
            register(VoiceMessageReceivedEvent.class, Listener::onVoiceMessageReceived);

            register(DeleteGroupChatPhotoEvent.class, Listener::onDeleteGroupChatPhoto);
            register(GroupChatCreatedEvent.class, Listener::onGroupChatCreated);
            register(ChannelChatCreatedEvent.class, Listener::onChannelChatCreated);
            register(NewGroupChatPhotoEvent.class, Listener::onNewGroupChatPhoto);
            register(NewGroupChatTitleEvent.class, Listener::onNewGroupChatTitle);
            register(ParticipantJoinGroupChatEvent.class, Listener::onParticipantJoinGroupChat);
            register(ParticipantLeaveGroupChatEvent.class, Listener::onParticipantLeaveGroupChat);

            register(InlineQueryReceivedEvent.class, Listener::onInlineQueryReceived);
            register(InlineResultChosenEvent.class, Listener::onInlineResultChosen);

            register(CallbackQueryReceivedEvent.class, Listener::onCallbackQueryReceivedEvent);
            register(MessageCallbackQueryReceivedEvent.class, Listener::onMessageCallbackQueryReceivedEvent);
            register(InlineCallbackQueryReceivedEvent.class, Listener::onInlineCallbackQueryReceivedEvent);
        }

        private <T extends Event> void register(Class<T> clazz, BiConsumer<Listener, T> invoker) {
            this.put(clazz, invoker);
        }
    };

    private final Map<Class<?>, PrioritisedSet<RegisteredListener>> listenerByContent = new HashMap<>();

    public void register(Listener listener) {
        boolean globalIgnore = Optional.ofNullable(listener.getClass().getAnnotation(Event.Handler.class))
                                       .map(Event.Handler::ignoreCancelled)
                                       .orElse(false);
        Event.Priority globalPriority = Optional.ofNullable(listener.getClass().getAnnotation(Event.Handler.class))
                .map(Event.Handler::priority)
                .orElse(Event.Priority.NORMAL);
        for (Method m : listener.getClass().getDeclaredMethods()) {
            Class<?>[] classes = m.getParameterTypes();
            if (classes.length == 1) {
                PrioritisedSet<RegisteredListener> listeners = listenerByContent.computeIfAbsent(classes[0], (c) -> new PrioritisedSet<>());
                boolean ignore = Optional.ofNullable(m.getAnnotation(Event.Handler.class))
                                         .map(Event.Handler::ignoreCancelled)
                                         .orElse(globalIgnore);
                Event.Priority priority = Optional.ofNullable(m.getAnnotation(Event.Handler.class))
                        .map(Event.Handler::priority)
                        .orElse(globalPriority);
                listeners.add(priority, new RegisteredListener(listener, classes[0], ignore));
            }
        }
    }

    public void unregister(Listener listener) {
        for (Method m : listener.getClass().getDeclaredMethods()) {
            Class<?>[] classes = m.getParameterTypes();
            if(classes.length == 1) {
                RegisteredListener registeredListener = new RegisteredListener(listener, classes[0], false);
                listenerByContent.computeIfPresent(classes[0], (c, s) -> (s.remove(registeredListener) && s.size() == 0 ? null : s));
            }
        }
    }

    public void callEvent(Event event) {
        boolean cancellable = event instanceof Cancellable;
        BiConsumer<Listener, Event> invoker = (BiConsumer<Listener, Event>) this.invokers.get(event.getClass());
        this.listenerByContent.getOrDefault(event.getClass(), PrioritisedSet.empty())
                         .forEach(listener -> {
                             if (!cancellable || listener.isIgnoreCancelled() ||!((Cancellable) event).isCancelled()) {
                                 invoker.accept(listener.getListener(), event);
                             }
                         });
    }

    private ListenerRegistryImpl() {
    }

    public static ListenerRegistry getNewInstance() {

        return new ListenerRegistryImpl();
    }
}