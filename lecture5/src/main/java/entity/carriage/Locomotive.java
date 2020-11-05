package entity.carriage;

import entity.roles.Driver;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Locomotive extends Carriage {

    @Getter
    @Setter
    Driver driver;

    public Locomotive() {
        super();
        log.debug("Locomotive created: {}", this);
    }

    private Locomotive(Driver driver) {
        super();
        this.driver = driver;
        log.debug("Locomotive created: {}", this);
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
