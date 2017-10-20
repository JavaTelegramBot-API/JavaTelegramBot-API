package pro.zackpollard.telegrambot.api.stickers;

import lombok.*;
import pro.zackpollard.telegrambot.api.chat.message.send.InputFile;

import java.net.URL;

@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CreatableSticker {

    @Getter
    private final InputFile pngSticker;
    @Getter
    private final URL pngStickerUrl;
    @Getter
    @NonNull
    private final String emojis;
    @Getter
    private final MaskPosition maskPosition;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return A CreatableStickerBuilder object used to construct the CreatableSticker object
     */
    public static CreatableStickerBuilder builder() {
        return new CreatableStickerBuilder();
    }

    @ToString
    public static class CreatableStickerBuilder {
        private InputFile pngSticker;
        private URL pngStickerUrl;
        private String emojis;
        private MaskPosition maskPosition;

        CreatableStickerBuilder() {
        }

        /**
         * *Required* (This or pngStickerUrl(URL) must be populated)
         * Png image with the sticker, must be up to 512 kilobytes in size, dimensions must not exceed 512px, and either
         * width or height must be exactly 512px. Pass a file_id as a String to send a file that already exists on the
         * Telegram servers
         *
         * @param pngSticker Png image with the sticker, must be up to 512 kilobytes in size, dimensions must not exceed
         *                   512px, and either width or height must be exactly 512px. Pass a file_id as a String to send
         *                   a file that already exists on the Telegram servers
         *
         * @return The builder object
         */
        public CreatableStickerBuilder pngSticker(InputFile pngSticker) {
            this.pngSticker = pngSticker;
            this.pngStickerUrl = null;
            return this;
        }

        /**
         * *Required* (This or pngSticker(InputFile) must be populated)
         * Pass an HTTP URL for Telegram to get a file from the Internet
         *
         * @param pngStickerUrl The URL where the image is located that you want to upload as a sticker
         *
         * @return The builder object
         */
        public CreatableStickerBuilder pngStickerUrl(URL pngStickerUrl) {
            this.pngStickerUrl = pngStickerUrl;
            this.pngSticker = null;
            return this;
        }

        /**
         * *Required*
         * One or more emoji corresponding to the sticker
         *
         * @param emojis One or more emoji corresponding to the sticker
         *
         * @return The builder object
         */
        public CreatableStickerBuilder emojis(String emojis) {
            this.emojis = emojis;
            return this;
        }

        /**
         * *Optional*
         * A MaskPosition object for position where the mask should be placed on faces. Can be ignored if the sticker is
         * not a mask
         *
         * @param maskPosition position where the mask should be placed on faces
         *
         * @return The builder object
         */
        public CreatableStickerBuilder maskPosition(MaskPosition maskPosition) {
            this.maskPosition = maskPosition;
            return this;
        }

        /**
         * Builds the CreatableSticker object
         *
         * @return A CreatableSticker object based on the previously provided values
         */
        public CreatableSticker build() {
            if(pngSticker == null && pngStickerUrl == null) {
                throw new NullPointerException("Either pngSticker or pngStickerUrl must not be null when calling build().");
            }
            return new CreatableSticker(pngSticker, pngStickerUrl, emojis, maskPosition);
        }
    }
}
