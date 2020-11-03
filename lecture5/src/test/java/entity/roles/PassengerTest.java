package entity.roles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

class PassengerTest {

    @Test
    void passengerAgeTest() {
        Exception exceptionToLow = assertThrows(IllegalArgumentException.class, () -> {
            Passenger.of("test", -1);
        });

        String expectedMessage = "age to low";
        String actualMessage = exceptionToLow.getMessage();

        assertThat(actualMessage, containsStringIgnoringCase(expectedMessage));
    }
}