package entity.carriage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

class CarriageTest {

    @Test
    void addNextSameCarriage() {
        PassengerCarriage car1 = TestCarriage.passengerCarriage();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            car1.addNext(car1);
        });

        String expected = exception.getMessage();
        String actual = "cannot add the same carriage";

        assertThat(expected, containsStringIgnoringCase(actual));
    }

    @Test
    void addPreviousSameCarriage() {
        PassengerCarriage car1 = TestCarriage.passengerCarriage();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            car1.addNext(car1);
        });

        String expected = exception.getMessage();
        String actual = "cannot add the same carriage";

        assertThat(expected, containsStringIgnoringCase(actual));
    }

    @Test
    void addPreviousNext() {
        PassengerCarriage car1 = TestCarriage.passengerCarriage();
        PassengerCarriage car2 = TestCarriage.passengerCarriage();

        car1.addNext(car2);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
           car1.addPrevious(car2);
        });

        String expected = "carriage is already tied";
        String actual = exception.getMessage();

        assertThat(actual, containsStringIgnoringCase(expected));
    }

    @Test
    void removePrevious() {
        PassengerCarriage car1 = TestCarriage.passengerCarriage();
        PassengerCarriage car2 = TestCarriage.passengerCarriage();

        car1.addNext(car2);
        assertEquals(car1, car2.getPrev());
        car2.removePrevious();

        assertThat(car2.getPrev(), is(nullValue()));
        assertThat(car1.getNext(), is(nullValue()));
    }

    @Test
    void removeNext() {
        PassengerCarriage car1 = TestCarriage.passengerCarriage();
        PassengerCarriage car2 = TestCarriage.passengerCarriage();

        car1.addNext(car2);
        assertEquals(car1, car2.getPrev());
        car1.removeNext();

        assertThat(car2.getPrev(), is(nullValue()));
        assertThat(car1.getNext(), is(nullValue()));
    }
}