package pro.zackpollard.telegrambot.api.chat.inline.send;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import pro.zackpollard.telegrambot.api.chat.inline.send.results.InlineQueryResult;

import java.util.Arrays;
import java.util.List;

/**
 * @author Zack Pollard
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class InlineQueryResponse {

    @NonNull
    private final List<InlineQueryResult> results;
    private final Integer cache_time;
    private final boolean is_personal;
    private final String next_offset;
    private final String switch_pm_text;
    private final String switch_pm_parameter;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return An InlineQueryResponseBuilder object used to construct the InlineQueryResponse object
     */
    public static InlineQueryResponseBuilder builder() {
        return new InlineQueryResponseBuilder();
    }

    /**
     * Gets a list of all the result objects that will be sent with this response
     *
     * @return List of result objects that will be sent
     */
    @NonNull
    public List<InlineQueryResult> getResults() {
        return this.results;
    }

    /**
     * Gets the cache time for this result in seconds
     *
     * @return The cache time for this result in seconds
     */
    public Integer getCacheTime() {
        return this.cache_time;
    }

    /**
     * Gets whether this result is personal. If isPersonal() is false, it means that the cache can be shared between
     * users. If isPersonal() is true the cache will not be shared and will be specific to the user
     *
     * @return Whether the response is personal or not
     */
    public boolean isPersonal() {
        return this.is_personal;
    }

    /**
     * Gets the offset key that has been set for if the user scrolls to the end of the list of results and requires more
     *
     * @return The next offset key or a blank string if none was set
     */
    public String getNextOffset() {
        return this.next_offset;
    }

    /**
     * Gets the switch PM text. If passed, clients will display a button with specified text that switches the user
     * to a private chat with the bot and sends the bot a start message with the parameter from
     * {@link #getSwitchPmParameter()}
     *
     * @return The switch pm text
     */
    public String getSwitchPmText() {
        return switch_pm_text;
    }

    /**
     * Gets the parameter for the start message sent to the bot when user presses the switch button, if set
     *
     * Example: An inline bot that sends YouTube videos can ask the user to connect the bot to their YouTube account to
     * adapt search results accordingly. To do this, it displays a ‘Connect your YouTube account’ button above the
     * results, or even before showing any. The user presses the button, switches to a private chat with the bot and,
     * in doing so, passes a start parameter that instructs the bot to return an oauth link. Once done, the bot can
     * offer a switch_inline button so that the user can easily return to the chat where they wanted to use the bot's
     * inline capabilities.
     *
     * @return The switch pm parameter
     */
    public String getSwitchPmParameter() {
        return switch_pm_parameter;
    }

    @ToString
    public static class InlineQueryResponseBuilder {

        private List<InlineQueryResult> results;
        private Integer cache_time = 300;
        private boolean is_personal = false;
        private String next_offset = "";
        private String switch_pm_text;
        private String switch_pm_parameter;

        InlineQueryResponseBuilder() {
        }

        /**
         * *Required*
         * Sets the list of InlineQueryResult's for the response
         *
         * @param results The list of InlineQueryResult objects
         *
         * @return The builder object
         */
        public InlineQueryResponse.InlineQueryResponseBuilder results(List<InlineQueryResult> results) {
            this.results = results;
            return this;
        }

        /**
         * *Required*
         * Sets the InlineQueryResult's for the response
         *
         * @param results A collection of InlineQueryResult objects
         *
         * @return The builder object
         */
        public InlineQueryResponse.InlineQueryResponseBuilder results(InlineQueryResult... results) {
            this.results = Arrays.asList(results);
            return this;
        }

        /**
         * *Optional*
         * Sets the cache time for this response in seconds. If not set this will default to 300 seconds
         *
         * @param cacheTime The cache time for the response in seconds
         *
         * @return The builder object
         */
        public InlineQueryResponse.InlineQueryResponseBuilder cacheTime(Integer cacheTime) {
            this.cache_time = cacheTime;
            return this;
        }

        /**
         * *Optional*
         * Sets whether the response is personal to the user or not. If set to true then the cached response won't
         * be served to anyone apart from the original user. New users will send new requests to the bot
         *
         * @param isPersonal Sets whether the response is personal or not
         *
         * @return The builder object
         */
        public InlineQueryResponse.InlineQueryResponseBuilder isPersonal(boolean isPersonal) {
            this.is_personal = isPersonal;
            return this;
        }

        /**
         * *Optional*
         * Sets the offset that a client should send in the next query with the same text to receive more results.
         * Ignore this if there are no more results or if you don‘t support pagination.
         * Offset length can’t exceed 64 bytes.
         *
         * @param nextOffset The next offset for the results
         *
         * @return The builder object
         */
        public InlineQueryResponse.InlineQueryResponseBuilder nextOffset(String nextOffset) {
            this.next_offset = nextOffset;
            return this;
        }

        /**
         * *Optional*
         * Sets the switch pm text for the response.
         * If set, clients will display a button with specified text that switches the user to a private chat with
         * the bot and sends the bot a start message with the parameter switch_pm_parameter
         *
         * @param switchPmText The switch pm text
         *
         * @return The builder object
         */
        public InlineQueryResponse.InlineQueryResponseBuilder switchPMText(String switchPmText) {
            this.switch_pm_text = switchPmText;
            return this;
        }

        /**
         * *Optional*
         * Sets the switch pm parameter for the response.
         *
         * Parameter for the start message sent to the bot when user presses the switch button
         *
         * Example: An inline bot that sends YouTube videos can ask the user to connect the bot to their YouTube account
         * to adapt search results accordingly. To do this, it displays a ‘Connect your YouTube account’ button above
         * the results, or even before showing any. The user presses the button, switches to a private chat with the
         * bot and, in doing so, passes a start parameter that instructs the bot to return an oauth link. Once done,
         * the bot can offer a switch_inline button so that the user can easily return to the chat where they wanted
         * to use the bot's inline capabilities.
         *
         * @param switchPmParameter The switch pm parameter
         *
         * @return The builder object
         */
        public InlineQueryResponse.InlineQueryResponseBuilder switchPMParameter(String switchPmParameter) {
            this.switch_pm_parameter = switchPmParameter;
            return this;
        }

        /**
         * Builds the InlineQueryResultVoice object
         *
         * @return An InlineQueryResultVoice object based on the previously provided values
         */
        public InlineQueryResponse build() {
            return new InlineQueryResponse(results, cache_time, is_personal, next_offset, switch_pm_text, switch_pm_parameter);
        }
    }
}
