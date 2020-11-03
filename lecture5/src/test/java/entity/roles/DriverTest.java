package entity.roles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

class DriverTest {

    @Test
    void of16YearsOldDriverTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                Driver.of("Test", 16, 0));

        String expectedMessage = "driver is too young";
        String actualMessage = exception.getMessage();

        assertThat(actualMessage, containsStringIgnoringCase(expectedMessage));
    }

}