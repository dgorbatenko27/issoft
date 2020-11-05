package entity.carriage;

import entity.roles.Driver;

public class TestCarriage {

    private static final int DEFAULT_PASSENGER_CAPACITY = 100;

    private static final int DEFAULT_CARRYING_CAPACITY = 60_000;

    public static Locomotive locomotive() {
        return Locomotive.of(new Driver("Jake", 21, 3));
    }

    public static PassengerCarriage passengerCarriage() {
        return PassengerCarriage.of(DEFAULT_PASSENGER_CAPACITY);
    }

    public static CargoCarriage cargoCarriage() {
        return CargoCarriage.of(DEFAULT_CARRYING_CAPACITY);
    }
}
