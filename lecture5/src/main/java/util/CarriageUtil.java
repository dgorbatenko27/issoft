package util;

import entity.carriage.CargoCarriage;
import entity.carriage.Carriage;
import entity.carriage.Locomotive;
import entity.carriage.PassengerCarriage;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Stream;

@Slf4j
public class CarriageUtil {

    public static void printTrainInfo(Carriage carriage) {

        boolean first = false;
        int number = 0;
        while (true) {
            if (!first) {

                if (carriage.getPrev() == null) {
                    first = true;
                } else {
                    carriage = carriage.getPrev();
                }

            } else {

                if (carriage instanceof CargoCarriage) {
                    CargoCarriage car = (CargoCarriage) carriage;
                    log.debug("{}. {}", number, car);
                } else if (carriage instanceof Locomotive) {
                    Locomotive car = (Locomotive) carriage;
                    log.debug("{}. {}", number, car);
                } else if (carriage instanceof PassengerCarriage) {
                    PassengerCarriage car = (PassengerCarriage) carriage;
                    log.debug("{}. {}", number, car);
                } else {
                    // do nothing
                }
                number++;
                if (carriage.getNext() == null) {
                    break;
                } else {
                    carriage = carriage.getNext();
                }

            }
        }
    }

    public static List<Carriage> bindedCarriages(Carriage carriage) {
        List<Carriage> train = new ArrayList<>();

        boolean first = false;

        while (true) {
            if (!first) {

                if (carriage.getPrev() == null) {
                    first = true;
                } else {
                    carriage = carriage.getPrev();
                }

            } else {

                if (carriage.getNext() == null) {
                    train.add(carriage);
                    break;
                } else {
                    train.add(carriage);
                    carriage = carriage.getNext();
                }

            }
        }
        return train;
    }

    public static Carriage getHead(Carriage carriage) {

        while (carriage.getPrev() != null) {
            carriage = carriage.getPrev();
        }

        return carriage;

    }

    public static Carriage getTail(Carriage carriage) {

        while (carriage.getNext() != null) {
            carriage = carriage.getNext();
        }

        return carriage;

    }

    // todo
    public static void doTrain(Carriage ... args) {
        boolean canDo =
                Stream.of(args).anyMatch(car -> !car.isBinded());

        if (canDo) {
            Set<Carriage> carriages = new LinkedHashSet<>();
            carriages.addAll(Arrays.asList(args));
            Iterator<Carriage> iterator = carriages.iterator();

            for (int i = 0; i < carriages.size(); i++) {
                if (i == 0) {
                    throw new UnsupportedOperationException("not yet");
                }
            }
        } else {
            throw new UnsupportedOperationException("not yet");
        }
    }
}
