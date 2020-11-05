package entity.carriage;

import entity.Cargo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import static org.junit.jupiter.api.Assertions.*;

class CargoCarriageTest {

    @Test
    void load() {

        Cargo cargo = aCargo(1);
        CargoCarriage car1 = TestCarriage.cargoCarriage();
        car1.load(cargo);

        List<Cargo> expected = new ArrayList<>(List.of(cargo));
        List<Cargo> actual = car1.getCargos();

        assertThat(actual, equalToObject(expected));

    }

    @Test
    void loadTooBigCargo() {

        Cargo cargo = aCargo(65_000);
        CargoCarriage car1 = TestCarriage.cargoCarriage();

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> car1.load(cargo));

        String expected = "no place";
        String actual = exception.getMessage();

        assertThat(actual, containsStringIgnoringCase(expected));

    }

    @Test
    void unload() {

        Cargo cargo1 = aCargo(10);
        Cargo cargo2 = aCargo(15);
        CargoCarriage car1 = TestCarriage.cargoCarriage();

        car1.load(cargo1);
        car1.load(cargo2);

        List<Cargo> expected = new ArrayList<>();
        car1.unload(cargo1);
        car1.unload(cargo2);
        List<Cargo> actual = car1.getCargos();

        assertThat(actual, equalToObject(expected));

    }

    @Test
    void getTotalCargosWeight() {

        Cargo cargo1 = aCargo(10);
        Cargo cargo2 = aCargo(15);
        CargoCarriage car = CargoCarriage.of(200);

        car.load(cargo1);
        car.load(cargo2);

        assertEquals(10 + 15, car.getTotalCargosWeight());

    }

    private static Cargo aCargo(int weight) {
        return Cargo.of("Box", 1, 1, 1, weight);
    }
}