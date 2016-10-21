package pro.zackpollard.telegrambot.api.conversations.prompt;

import pro.zackpollard.telegrambot.api.chat.message.content.TextContent;
import pro.zackpollard.telegrambot.api.conversations.ConversationContext;

import java.util.regex.Pattern;

/**
 * Validation prompt based on regex, extends text validating.
 *
 * @see TextValidatingPrompt
 * @author Mazen Kotb
 */
public abstract class RegexPrompt extends TextValidatingPrompt {
    protected final Pattern pattern;

    /**
     * Creates a new prompt with pattern, calls Pattern.compile
     *
     * @param pattern Pattern as a string
     * @see Pattern#compile(String)
     */
    protected RegexPrompt(String pattern) {
        this(Pattern.compile(pattern));
    }

    /**
     * Creates new prompt with provided pattern
     * @param pattern compiled regex pattern
     */
    protected RegexPrompt(Pattern pattern) {
        this.pattern = pattern;
    }

    @Override
    protected boolean validate(ConversationContext context, TextContent input) {
        return pattern.matcher(input.getContent()).matches();
    }
}
