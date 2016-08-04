package pro.zackpollard.telegrambot.api.conversations.prompt;

/**
 * A prompt which looks for an exact match, uses regex template:
 * ^match$
 *
 * @author Mazen Kotb
 * @see RegexPrompt
 */
public abstract class ExactMatchPrompt extends RegexPrompt {
    protected ExactMatchPrompt(String match) {
        super("^" + match + "$");
    }
}
