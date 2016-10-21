package pro.zackpollard.telegrambot.api.conversations.prompt;

import pro.zackpollard.telegrambot.api.chat.message.content.TextContent;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableMessage;
import pro.zackpollard.telegrambot.api.conversations.ConversationContext;

import java.util.regex.Pattern;

/**
 * A prompt which accepts a number from the other participant.
 * The prompt will select the appropriate data type based on the user input.
 *
 * @author Mazen Kotb
 * @see NumericPrompt#INTEGER_PATTERN
 * @see NumericPrompt#DOUBLE_PATTERN
 * @see NumericPrompt#FLOAT_PATTERN
 */
public abstract class NumericPrompt extends TextValidatingPrompt {
    /**
     * Matches any numbers with 1 to 10 characters in length
     */
    private static final Pattern INTEGER_PATTERN = Pattern.compile("^[0-9]{1,10}$");
    /**
     * Matches any numbers with 1 to 309 characters in length with 1 to 2 decimal points
     */
    private static final Pattern DOUBLE_PATTERN = Pattern.compile("^[0-9]{1,309}\\.[0-9]{1,2}$");
    /**
     * Matches any numbers with 1 to 29 characters in length
     */
    private static final Pattern FLOAT_PATTERN = Pattern.compile("^[0-9]{1,29}\\.[0-9]{3,9}$");

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

    /**
     * Parses a number that matches the text, null if no matches
     * @param text Text to be parsed as a number
     * @return Number parsed, null if no match
     * @see NumericPrompt#INTEGER_PATTERN
     * @see NumericPrompt#DOUBLE_PATTERN
     * @see NumericPrompt#FLOAT_PATTERN
     */
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

    /**
     * Validates a number, for use cases where you may need the number to be within a range
     * @param context Context of the conversation
     * @param input User inputted number
     * @return Whether or not the number is valid
     */
    protected abstract boolean validateNumber(ConversationContext context, Number input);

    /**
     * Accepts validated number
     * @param context Context of the conversation
     * @param input User inputted number
     * @return Whether or not to repeat the current prompt
     */
    protected abstract boolean accept(ConversationContext context, Number input);

    /**
     * Message sent if validateNumber() returns false. Null is accepted
     * @param context Context of the conversation
     * @param input User input (is valid number, use parseNumber() with the text to get the value)
     * @return Invalid input message
     * @see NumericPrompt#validateNumber(ConversationContext, Number)
     * @see NumericPrompt#parseNumber(String)
     */
    protected abstract SendableMessage invalidInputMessage(ConversationContext context, TextContent input);

    /**
     * Message sent if parseNumber() returns null
     * @param context Context of the conversation
     * @param input User input
     * @return Invalid number message
     * @see NumericPrompt#parseNumber(String)
     */
    protected abstract SendableMessage notNumericMessage(ConversationContext context, TextContent input);
}
