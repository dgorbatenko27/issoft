package entity.carriage;

import entity.roles.Driver;
import lombok.Getter;
import lombok.Setter;

public class Locomotive extends Carriage {

    @Getter
    @Setter
    Driver driver;

    public Locomotive() {
        super();
    }

    private Locomotive(Driver driver) {
        super();
        this.driver = driver;
    }

    public static Locomotive of(Driver driver) {
        return new Locomotive(driver);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Locomotive{");
        sb.append("id=").append(getId());
        sb.append(", driver=").append(driver);
        sb.append('}');
        return sb.toString();
    }
}
