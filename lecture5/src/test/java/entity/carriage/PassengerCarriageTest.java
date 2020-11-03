package entity.carriage;

import entity.roles.Passenger;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

class PassengerCarriageTest {

    @Test
    void addPassenger() {

        PassengerCarriage pasCar = (PassengerCarriage) CarriageFactory.create(CarriageTypes.PASSENGER_CARRIAGE);
        Passenger passenger1 = Passenger.of("Alex", 19);
        Passenger passenger2 = Passenger.of("James", 21);

        pasCar.addPassenger(passenger1);
        pasCar.addPassenger(passenger2);

        List<Passenger> expected = new ArrayList<>(List.of(passenger1, passenger2));
        List<Passenger> actual = pasCar.getPassengers();
//        int actualTotal = pasCar.getCapacity() - pasCar.getPassengers().size();
//        int expectedTotal = pasCar.getCapacity() - 2;

        assertThat(actual, equalToObject(expected));
//        assertThat(actualTotal, is(expectedTotal));

    }

    @Test
    void addPassengerIndexSeat() {
        assertEquals(true, false);
    }

    @Test
    void removePassenger() {
        assertEquals(true, false);
    }

    @Test
    void removePassengerIndexSeat() {
        assertEquals(true, false);
    }
}