package pro.zackpollard.telegrambot.api.extensions;

import pro.zackpollard.telegrambot.api.TelegramBot;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author DarkSeraphim.
 */
public enum Extensions {
    INSTANCE;

    private final Map<Class<?>, Extension.Provider<? extends Extension>> providers = new HashMap<>();

    public static <T extends Extension, U extends T> void register(Class<T> cls, Extension.Provider<U> provider) {
        provider = CachedExtensionProvider.wrap(provider);
        INSTANCE.providers.put(cls, provider);
    }

    public static <T extends Extension> T get(TelegramBot bot, Class<T> cls) {
        Extension.Provider<? extends Extension> provider = INSTANCE.providers.get(cls);
        if (provider == null) {
            Extension.DefaultProvider def = cls.getAnnotation(Extension.DefaultProvider.class);
            if (def == null) {
                throw new IllegalArgumentException("No extension found for type " + cls.getName() + ", and no default implementation was provided.");
            }
            Extension.Provider<T> defaultProvider;
            try {
                Class<? extends Extension.Provider> extensionFactory = def.value();
                defaultProvider = extensionFactory.newInstance();
            } catch (ReflectiveOperationException ex) {
                throw new IllegalStateException("No provider was found for extension " + cls.getName() +
                                                ", and the default implementation did not have a constructor which accepts a TelegramBot instance", ex);
            }
            provider = INSTANCE.providers.computeIfAbsent(cls, $ -> CachedExtensionProvider.wrap(defaultProvider));
        }
        return cls.cast(provider.create(bot));
    }

    private static class CachedExtensionProvider<T extends Extension> implements Extension.Provider<T> {

        private final Extension.Provider<T> original;

        private Map<TelegramBot, T> extension;

        private CachedExtensionProvider(Extension.Provider<T> original) {
            this.original = original;
            this.extension = new WeakHashMap<>();
        }

        @Override
        public T create(TelegramBot bot) {
            return this.extension.computeIfAbsent(bot, this.original::create);
        }

        private static <T extends Extension> CachedExtensionProvider<T> wrap(Extension.Provider<T> original) {
            return original instanceof CachedExtensionProvider ? (CachedExtensionProvider<T>) original : new CachedExtensionProvider<>(original);
        }
    }
}
