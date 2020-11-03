package entity.carriage;

import entity.roles.Driver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CarriageFactory {

    private static final int DEFAULT_PASSENGER_CAPACITY = 100;

    private static final int DEFAULT_CARRYING_CAPACITY = 60_000;

    public static Carriage create(CarriageTypes type) {
        switch (type) {

            case PASSENGER_CARRIAGE:
                PassengerCarriage pas = PassengerCarriage.of(DEFAULT_PASSENGER_CAPACITY);
                log.debug("PassengerCarriage created: {}", pas);
                return pas;

            case CARGO_CARRIAGE:
                CargoCarriage cargo = CargoCarriage.of(DEFAULT_CARRYING_CAPACITY);
                log.debug("CargoCarriage created: {}", cargo);
                return cargo;

            case LOCOMOTIVE:
                Locomotive loc = Locomotive.of(new Driver("Jake", 25, 5));
                log.debug("Locomotive created: {}", loc);
                return loc;
            default:
                throw new IllegalArgumentException("type is not valid : " + type);
        }
    }

}
