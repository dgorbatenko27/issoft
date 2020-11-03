package entity;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CargoTest {

    @Test
    void ofNegativeHeight() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Cargo.of("CargoTest1", -1, 1, 1, 1);
        });

        String expectedMessage = "argument to low";
        String actualMessage = exception.getMessage();

        assertThat(actualMessage, containsStringIgnoringCase(expectedMessage));

    }

    @Test
    void ofNegativeLength() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Cargo.of("CargoTest1", 1, 1, -1, 1);
        });

        String expectedMessage = "argument to low";
        String actualMessage = exception.getMessage();

        assertThat(actualMessage, containsStringIgnoringCase(expectedMessage));

    }

    @Test
    void ofNegativeWidth() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Cargo.of("CargoTest1", 1, -1, 1, 1);
        });

        String expectedMessage = "argument to low";
        String actualMessage = exception.getMessage();

        assertThat(actualMessage, containsStringIgnoringCase(expectedMessage));

    }

    @Test
    void ofNegativeWeight() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Cargo.of("CargoTest1", 1, 1, 1, -1);
        });

        String expectedMessage = "argument to low";
        String actualMessage = exception.getMessage();

        assertThat(actualMessage, containsStringIgnoringCase(expectedMessage));

    }
}