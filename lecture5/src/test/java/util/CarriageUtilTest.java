package util;

import entity.carriage.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarriageUtilTest {

    @Test
    void blindedCarriages() {

        List<Carriage> expected = new ArrayList<>();

        Locomotive car1 = (Locomotive) CarriageFactory.create(CarriageTypes.LOCOMOTIVE);
        PassengerCarriage car2 = (PassengerCarriage) CarriageFactory.create(CarriageTypes.PASSENGER_CARRIAGE);
        PassengerCarriage car3 = (PassengerCarriage) CarriageFactory.create(CarriageTypes.PASSENGER_CARRIAGE);

        expected.add(car1);
        expected.add(car2);
        expected.add(car3);

        car1.addNext(car2);
        car2.addNext(car3);

        List<Carriage> actual = CarriageUtil.bindedCarriages(car3);

        assertEquals(expected, actual);

    }

    @Test
    void getHead() {
        Locomotive expected = (Locomotive) CarriageFactory.create(CarriageTypes.LOCOMOTIVE);

        PassengerCarriage car2 = (PassengerCarriage) CarriageFactory.create(CarriageTypes.PASSENGER_CARRIAGE);
        PassengerCarriage car3 = (PassengerCarriage) CarriageFactory.create(CarriageTypes.PASSENGER_CARRIAGE);
        expected.addNext(car2);
        car2.addNext(car3);

        Carriage actual = CarriageUtil.getHead(car3);

        assertEquals(expected, actual);
    }

    @Test
    void getTail() {

        Locomotive car1 = (Locomotive) CarriageFactory.create(CarriageTypes.LOCOMOTIVE);

        PassengerCarriage car2 = (PassengerCarriage) CarriageFactory.create(CarriageTypes.PASSENGER_CARRIAGE);
        PassengerCarriage expected = (PassengerCarriage) CarriageFactory.create(CarriageTypes.PASSENGER_CARRIAGE);
        car1.addNext(car2);
        car2.addNext(expected);

        Carriage actual1 = CarriageUtil.getTail(car1);
        Carriage actual2 = CarriageUtil.getTail(car2);

        assertEquals(expected, actual1);
        assertEquals(expected, actual2);

    }

    @Test
    void doTrain() {
        assertEquals(false, true);
    }

    // todo "snake tail" problem
}