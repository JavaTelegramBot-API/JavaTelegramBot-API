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

    @NonNull
    public List<InlineQueryResult> getResults() {
        return this.results;
    }

    public Integer getCacheTime() {
        return this.cache_time;
    }

    public boolean isPersonal() {
        return this.is_personal;
    }

    public String getNextOffset() {
        return this.next_offset;
    }

    public String getSwitchPmText() {
        return switch_pm_text;
    }

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

        public InlineQueryResponse.InlineQueryResponseBuilder results(List<InlineQueryResult> results) {
            this.results = results;
            return this;
        }

        public InlineQueryResponse.InlineQueryResponseBuilder results(InlineQueryResult... results) {
            this.results = Arrays.asList(results);
            return this;
        }

        public InlineQueryResponse.InlineQueryResponseBuilder cacheTime(Integer cache_time) {
            this.cache_time = cache_time;
            return this;
        }

        public InlineQueryResponse.InlineQueryResponseBuilder isPersonal(boolean is_personal) {
            this.is_personal = is_personal;
            return this;
        }

        public InlineQueryResponse.InlineQueryResponseBuilder nextOffset(String next_offset) {
            this.next_offset = next_offset;
            return this;
        }

        public InlineQueryResponse.InlineQueryResponseBuilder switchPMText(String switch_pm_text) {
            this.switch_pm_text = switch_pm_text;
            return this;
        }

        public InlineQueryResponse.InlineQueryResponseBuilder switchPMParameter(String switch_pm_parameter) {
            this.switch_pm_parameter = switch_pm_parameter;
            return this;
        }

        public InlineQueryResponse build() {
            return new InlineQueryResponse(results, cache_time, is_personal, next_offset, switch_pm_text, switch_pm_parameter);
        }
    }
}
