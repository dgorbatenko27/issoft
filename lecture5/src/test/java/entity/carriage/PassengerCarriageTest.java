package entity.carriage;

import entity.roles.Passenger;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

class PassengerCarriageTest {

    @Test
    void addPassenger() {

        PassengerCarriage pasCar = TestCarriage.passengerCarriage();
        Passenger passenger1 = Passenger.of("Alex", 19);
        Passenger passenger2 = Passenger.of("James", 21);

        pasCar.addPassenger(passenger1);
        pasCar.addPassenger(passenger2);

        Passenger[] expectedArr = new Passenger[pasCar.getCapacity()];
        expectedArr[0] = passenger1;
        expectedArr[1] = passenger2;

        List<Passenger> expected = new ArrayList<>(Arrays.asList(expectedArr));  // List.of() throws NPO
        List<Passenger> actual = pasCar.getPassengers();

        assertThat(actual, equalToObject(expected));

    }

    @Test
    void addPassengerIndexSeat() {

        PassengerCarriage pasCar = PassengerCarriage.of(100);
        Passenger passenger1 = Passenger.of("Alex", 19);
        Passenger passenger2 = Passenger.of("James", 21);

        pasCar.addPassenger(2,passenger1);
        pasCar.addPassenger(15, passenger2);

        Passenger[] expectedArr = new Passenger[pasCar.getCapacity()];
        expectedArr[2] = passenger1;
        expectedArr[15] = passenger2;

        List<Passenger> expected = new ArrayList<>(Arrays.asList(expectedArr));
        List<Passenger> actual = pasCar.getPassengers();

        assertThat(actual, equalToObject(expected));

    }

    @Test
    void removePassenger() {

        PassengerCarriage pasCar = PassengerCarriage.of(100);
        Passenger passenger1 = Passenger.of("Alex", 19);

        pasCar.addPassenger(passenger1);

        assertThat(pasCar.totalAmountOfPassengers(),is(1));
        pasCar.removePassenger(passenger1);

        assertThat(pasCar.totalAmountOfPassengers(),is(0));

    }

    @Test
    void removePassengerIndexSeat() {

        PassengerCarriage pasCar = PassengerCarriage.of(100);
        Passenger passenger1 = Passenger.of("Alex", 19);

        pasCar.addPassenger(15, passenger1);

        assertThat(pasCar.totalAmountOfPassengers(),is(1));
        pasCar.removePassenger(15);

        assertThat(pasCar.totalAmountOfPassengers(),is(0));

    }
}