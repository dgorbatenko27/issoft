package entity.carriage;

import entity.roles.Passenger;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Slf4j
public class PassengerCarriage extends Carriage {


    private final Passengers passengers;

    private PassengerCarriage(int capacity) {
        passengers = new Passengers(capacity);
        log.debug("PassengerCarriage created: {}", this);
    }

    public class Passengers {

        @Getter
        private final Passenger[] passengers;

        private Passengers(int capacity) {
            passengers = new Passenger[capacity];
        }

        public void addPassenger(int seatId, Passenger passenger) {

            if (passengers[seatId] == null) {
                passengers[seatId] = passenger;
            } else {
                throw new IllegalArgumentException("seat is busy");
            }

        }

        public void addPassenger(Passenger passenger) {

            if (totalAmountOfPassengers() < passengers.length) {
                for (int i = 0; i < passengers.length; i++) {
                    if (passengers[i] == null) {
                        passengers[i] = passenger;
                        break;
                    }
                }
            } else {
                throw new IndexOutOfBoundsException("all seats are busy");
            }

        }

        public void removePassenger(int seatId) {
            passengers[seatId] = null;
        }

        public void removePassenger(Passenger passenger) {

            for (int i = 0; i < passengers.length; i++) {
                if (passengers[i] != null && passengers[i].equals(passenger)) {
                    passengers[i] = null;
                }
            }

        }

        public int getCapacity() {
            return passengers.length;
        }

        public int totalAmountOfPassengers() {
            return (int) Arrays.stream(passengers)
                    .filter(Objects::nonNull)
                    .count();
        }

    }

    public List<Passenger> getPassengers() {
        // List.of() throws NPE
        return Arrays.asList(passengers.getPassengers());
    }

    public void addPassenger(int seatNumber, Passenger passenger) {
        passengers.addPassenger(seatNumber, passenger);
    }

    public void addPassenger(Passenger passenger) {
        passengers.addPassenger(passenger);
    }

    public void removePassenger(Passenger passenger) {
        passengers.removePassenger(passenger);
    }

    public void removePassenger(int seatNumber) {
        passengers.removePassenger(seatNumber);
    }

    public static PassengerCarriage of (int capacity) {
        return new PassengerCarriage(capacity);
    }

    public int totalAmountOfPassengers() {
        return passengers.totalAmountOfPassengers();
    }

    public int getCapacity() {
        return passengers.getCapacity();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PassengerCarriage{");
        sb.append("id=").append(getId());
        sb.append(", capacity=").append(getCapacity());
        sb.append(", total=").append(totalAmountOfPassengers());
        sb.append('}');
        return sb.toString();
    }
}
