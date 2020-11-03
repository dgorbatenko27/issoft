package entity.carriage;

import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

public abstract class Carriage {

    @Getter
    private final String id;
    @Getter
    private Carriage prev;
    @Getter
    private Carriage next;

    public Carriage() {
        id = UUID.randomUUID().toString();
    }

    public void addNext(Carriage carriage) {
        if (this.equals(carriage)) {
            throw new IllegalArgumentException("cannot add the same carriage");
        } else if (prev != null && prev.equals(carriage)) {
            throw new IllegalArgumentException("carriage is already tied");
        }
        this.next = carriage;
        carriage.prev = this;
    }

    public void addPrevious(Carriage carriage) {
        if (this.equals(carriage)) {
            throw new IllegalArgumentException("cannot add the same carriage");
        } else if (next.equals(carriage)) {
            throw new IllegalArgumentException("carriage is already tied");
        }
        this.prev = carriage;
        carriage.next = this;
    }

    public boolean isBinded() {
        return (prev == null && next == null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Carriage)) return false;
        Carriage carriage = (Carriage) o;
        return id.equals(carriage.id) &&
                Objects.equals(prev, carriage.prev) &&
                Objects.equals(next, carriage.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prev, next);
    }

}
