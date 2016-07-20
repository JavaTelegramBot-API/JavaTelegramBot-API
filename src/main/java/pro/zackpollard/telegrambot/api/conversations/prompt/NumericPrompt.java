package pro.zackpollard.telegrambot.api.conversations.prompt;

import pro.zackpollard.telegrambot.api.chat.message.content.TextContent;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableMessage;
import pro.zackpollard.telegrambot.api.conversations.ConversationContext;

import java.util.regex.Pattern;

public abstract class NumericPrompt extends TextValidatingPrompt {
    private static final Pattern INTEGER_PATTERN = Pattern.compile("^[1-9]{1,10}$");
    private static final Pattern DOUBLE_PATTERN = Pattern.compile("^[1-9]{1,309}\\.[1-9]{1,2}$");
    private static final Pattern FLOAT_PATTERN = Pattern.compile("^[1-9]{1,29}\\.[1-9]{3,9}$");

    @Override
    protected boolean validate(ConversationContext context, TextContent input) {
        Number number = parseNumber(input.getContent());
        return number != null && validateNumber(context, number);
    }

    @Override
    protected SendableMessage invalidationMessage(ConversationContext context, TextContent input) {
        return parseNumber(input.getContent()) == null ? notNumericMessage(context, input) :
                invalidInputMessage(context, input);
    }

    @Override
    protected boolean accept(ConversationContext context, TextContent input) {
        return accept(context, parseNumber(input.getContent()));
    }

    protected Number parseNumber(String text) {
        if (INTEGER_PATTERN.matcher(text).matches()) {
            return Integer.parseInt(text);
        }

        if (DOUBLE_PATTERN.matcher(text).matches()) {
            return Double.parseDouble(text);
        }

        if (FLOAT_PATTERN.matcher(text).matches()) {
            return Float.parseFloat(text);
        }

        return null;
    }

    protected abstract boolean validateNumber(ConversationContext context, Number input);
    protected abstract boolean accept(ConversationContext context, Number input);
    protected abstract SendableMessage invalidInputMessage(ConversationContext context, TextContent input);
    protected abstract SendableMessage notNumericMessage(ConversationContext context, TextContent input);
}
