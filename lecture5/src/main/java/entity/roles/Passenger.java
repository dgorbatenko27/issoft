package entity.roles;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

public class Passenger {

    public static int nextID = 0;

    @Getter
    private final int id;
    @Getter
    private final String name;
    @Getter
    @Setter
    private int age;

    private Passenger(String name, int age) {
        id = nextID++;
        this.name = name;
        this.age = age;
    }

    public static Passenger of(String name, int age) {
        if (age >= 0) {
            return new Passenger(name, age);
        } else {
            throw new IllegalArgumentException("age to low");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger)) return false;
        Passenger passenger = (Passenger) o;
        return id == passenger.id &&
                name.equals(passenger.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Passenger{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
