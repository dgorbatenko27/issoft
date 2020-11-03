package entity.carriage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

class CarriageTest {

    @Test
    void addNextSameCarriage() {
        PassengerCarriage car1 = (PassengerCarriage) CarriageFactory.create(CarriageTypes.PASSENGER_CARRIAGE);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            car1.addNext(car1);
        });

        String expected = exception.getMessage();
        String actual = "cannot add the same carriage";

        assertThat(expected, containsStringIgnoringCase(actual));
    }

    @Test
    void addPreviousSameCarriage() {
        PassengerCarriage car1 = (PassengerCarriage) CarriageFactory.create(CarriageTypes.PASSENGER_CARRIAGE);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            car1.addNext(car1);
        });

        String expected = exception.getMessage();
        String actual = "cannot add the same carriage";

        assertThat(expected, containsStringIgnoringCase(actual));
    }

    @Test
    void addPreviousNext() {
        PassengerCarriage car1 = (PassengerCarriage) CarriageFactory.create(CarriageTypes.PASSENGER_CARRIAGE);
        PassengerCarriage car2 = (PassengerCarriage) CarriageFactory.create(CarriageTypes.PASSENGER_CARRIAGE);

        car1.addNext(car2);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
           car1.addPrevious(car2);
        });

        String expected = "carriage is already tied";
        String actual = exception.getMessage();

        assertThat(actual, containsStringIgnoringCase(expected));
    }
}