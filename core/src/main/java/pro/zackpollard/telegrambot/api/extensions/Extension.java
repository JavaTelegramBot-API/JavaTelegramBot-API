package pro.zackpollard.telegrambot.api.extensions;

import pro.zackpollard.telegrambot.api.TelegramBot;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author DarkSeraphim.
 */
public interface Extension {

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @interface DefaultProvider {
        Class<? extends Extension.Provider> value();
    }

    @FunctionalInterface
    interface Provider<T extends Extension> {
        T create(TelegramBot bot);
    }
}
