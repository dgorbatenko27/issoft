package entity;

import lombok.Getter;

public class Cargo {

    @Getter
    private final String info;

    @Getter
    private final int height;
    @Getter
    private final int width;
    @Getter
    private final int length;
    @Getter
    private final int weight;

    private Cargo(String info, int height, int width, int length, int weight) {
        if (height > 0 && width > 0 && length > 0 && weight > 0) {
            this.info = info;
            this.height = height;
            this.width = width;
            this.length = length;
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Cargo argument to low");
        }
    }

    public static Cargo of(String info, int height, int width, int length, int weight) {
        return new Cargo(info, height, width, length, weight);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Cargo{");
        sb.append("info='").append(info).append('\'');
        sb.append(", height=").append(height);
        sb.append(", width=").append(width);
        sb.append(", length=").append(length);
        sb.append(", weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }
}
