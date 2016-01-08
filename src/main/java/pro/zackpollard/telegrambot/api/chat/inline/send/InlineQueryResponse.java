package pro.zackpollard.telegrambot.api.chat.inline.send;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pro.zackpollard.telegrambot.api.chat.inline.send.results.InlineQueryResult;

import java.util.Arrays;
import java.util.List;

/**
 * @author Zack Pollard
 */
@RequiredArgsConstructor
public class InlineQueryResponse {

    @NonNull
    private final List<InlineQueryResult> results;
    private final Integer cache_time;
    private final boolean is_personal;
    private final String next_offset;

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

    public static class InlineQueryResponseBuilder {

        private List<InlineQueryResult> results;
        private Integer cache_time = 300;
        private boolean is_personal = false;
        private String next_offset = "";

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

        public InlineQueryResponse.InlineQueryResponseBuilder cache_time(Integer cache_time) {
            this.cache_time = cache_time;
            return this;
        }

        public InlineQueryResponse.InlineQueryResponseBuilder is_personal(boolean is_personal) {
            this.is_personal = is_personal;
            return this;
        }

        public InlineQueryResponse.InlineQueryResponseBuilder next_offset(String next_offset) {
            this.next_offset = next_offset;
            return this;
        }

        public InlineQueryResponse build() {
            return new InlineQueryResponse(results, cache_time, is_personal, next_offset);
        }

        public String toString() {
            return "pro.zackpollard.telegrambot.api.chat.inline.send.InlineQueryResponse.InlineQueryResponseBuilder(results=" + this.results + ", cache_time=" + this.cache_time + ", is_personal=" + this.is_personal + ", next_offset=" + this.next_offset + ")";
        }
    }
}
