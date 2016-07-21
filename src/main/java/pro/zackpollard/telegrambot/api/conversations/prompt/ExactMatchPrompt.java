package pro.zackpollard.telegrambot.api.conversations.prompt;

public abstract class ExactMatchPrompt extends RegexPrompt {
    protected ExactMatchPrompt(String match) {
        super("^" + match + "$");
    }
}
