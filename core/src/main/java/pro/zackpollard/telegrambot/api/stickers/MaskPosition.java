package pro.zackpollard.telegrambot.api.stickers;

import lombok.*;

@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class MaskPosition {

    @Getter
    @NonNull
    private final MaskPoint point;
    private final double xShift;
    private final double yShift;
    private final double scale;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return A MaskPositionBuilder object used to construct the MaskPosition object
     */
    public static MaskPositionBuilder builder() {
        return new MaskPositionBuilder();
    }

    @ToString
    public static class MaskPositionBuilder {
        private MaskPoint point;
        private double xShift = 0.0D;
        private double yShift = 0.0D;
        private double scale = 1.0D;

        MaskPositionBuilder() {
        }

        /**
         * *Required*
         * The part of the face relative to which the mask should be placed
         *
         * @param point The MaskPoint you want the mask to be placed on
         *
         * @return The builder object
         */
        public MaskPositionBuilder point(MaskPoint point) {
            this.point = point;
            return this;
        }

        /**
         * *Optional*
         * Sets the shift by X-axis measured in widths of the mask scaled to the face size, from left to right. For
         * example, choosing -1.0 will place mask just to the left of the default mask position
         *
         * @param xShift The shift in the x-axis that you want this mask to have, -1.0 will place the mask just to the
         *               left of the default mask position
         *
         * @return The builder object
         */
        public MaskPositionBuilder xShift(double xShift) {
            this.xShift = xShift;
            return this;
        }

        /**
         * *Optional*
         * Sets the shift by Y-axis measured in heights of the mask scaled to the face size, from top to bottom. For
         * example, 1.0 will place the mask just below the default mask position
         *
         * @param yShift The shift in the y-axis that you want this mask to have, 1.0 will place the mask just below the
         *               default mask position
         *
         * @return The builder object
         */
        public MaskPositionBuilder yShift(double yShift) {
            this.yShift = yShift;
            return this;
        }

        /**
         * *Optional*
         * Sets the mask scaling coefficient. For example, 2.0 means double size
         *
         * @param scale The scale of the mask, 2.0 means double size
         *
         * @return The builder object
         */
        public MaskPositionBuilder scale(double scale) {
            this.scale = scale;
            return this;
        }

        /**
         * Builds the MaskPosition object
         *
         * @return A MaskPosition object based on the previously provided values
         */
        public MaskPosition build() {
            return new MaskPosition(point, xShift, yShift, scale);
        }
    }
}
