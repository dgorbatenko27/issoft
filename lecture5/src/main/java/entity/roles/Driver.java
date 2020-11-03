package entity.roles;

import lombok.Getter;
import lombok.Setter;

public class Driver {

    @Getter
    private final String name;
    @Getter
    @Setter
    private int age;
    @Getter
    @Setter
    private int experience;

    public Driver(String name, int age, int experience) {
        if (age >= 18) {
            this.name = name;
            this.age = age;
            this.experience = experience;
        } else {
            throw new IllegalArgumentException("Driver is too young: " + age);
        }
    }

    public static Driver of(String name, int age, int experience) {
        return new Driver(name, age, experience);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Driver{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", experience=").append(experience);
        sb.append('}');
        return sb.toString();
    }
}
