package pro.zackpollard.telegrambot.api.conversations.prompt;

import pro.zackpollard.telegrambot.api.chat.message.content.TextContent;
import pro.zackpollard.telegrambot.api.conversations.ConversationContext;

import java.util.regex.Pattern;

public abstract class RegexPrompt extends TextValidatingPrompt {
    protected final Pattern pattern;

    protected RegexPrompt(String pattern) {
        this(Pattern.compile(pattern));
    }

    protected RegexPrompt(Pattern pattern) {
        this.pattern = pattern;
    }

    @Override
    protected boolean validate(ConversationContext context, TextContent input) {
        return pattern.matcher(input.getContent()).matches();
    }
}
