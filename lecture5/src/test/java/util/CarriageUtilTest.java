package util;

import entity.carriage.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarriageUtilTest {

    Locomotive loc;
    PassengerCarriage pas1;
    PassengerCarriage pas2;
    PassengerCarriage pas3;

    @BeforeEach
    void setUp() {

        loc = TestCarriage.locomotive();
        pas1 = TestCarriage.passengerCarriage();
        pas2 = TestCarriage.passengerCarriage();

    }

    @Test
    void blindedCarriages() {

        List<Carriage> expected = new ArrayList<>();
        expected.add(loc);
        expected.add(pas1);
        expected.add(pas2);

        loc.addNext(pas1);
        pas1.addNext(pas2);

        List<Carriage> actual = CarriageUtil.bindedCarriages(pas2);

        assertEquals(expected, actual);

    }

    @Test
    void getHead() {
        Locomotive expected = loc;

        expected.addNext(pas1);
        pas1.addNext(pas2);

        Carriage actual = CarriageUtil.getHead(pas2);

        assertEquals(expected, actual);

    }

    @Test
    void getTail() {

        loc.addNext(pas1);
        pas1.addNext(pas2);

        PassengerCarriage expected = pas2;

        Carriage actual1 = CarriageUtil.getTail(loc);
        Carriage actual2 = CarriageUtil.getTail(pas1);

        assertEquals(expected, actual1);
        assertEquals(expected, actual2);

    }

    @Test
    void doTrain() {

        // expected
        loc.addNext(pas1);
        pas1.addNext(pas2);
        List<Carriage> expected = new ArrayList<>(List.of(loc, pas1, pas2));
        // actual
        Locomotive acLoc = TestCarriage.locomotive();
        PassengerCarriage acPas1 = TestCarriage.passengerCarriage();
        PassengerCarriage acPas2 = TestCarriage.passengerCarriage();
        CarriageUtil.doTrain(acLoc, acPas1, acPas2);
        List<Carriage> actual = new ArrayList<>(List.of(acLoc, acPas1, acPas2));

        assertEquals(expected, actual);

    }

    private static void unBind(Carriage carriage) {

    }
    // todo "snake tail" problem
}