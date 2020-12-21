package com.wsup;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Slf4j
public class Elevator implements Runnable {

    private static final int DEFAULT_CAPACITY = 600;
    private static final int DEFAULT_MOVING_SPEED = 2;
    private static final int DEFAULT_DOORS_SPEED = 1;
    private static final int DEFAULT_STANDING_TIME = 2;

    private static int nextId;
    @Getter
    private final int id;
    private final int capacity;
    private final int movingSpeed;
    private final int doorsSpeed;
    private final int standingTime;
    private final Building building;

    private final TreeSet<Integer> openRequests;
    private final List<Person> passengers;
    @Getter @Setter
    private Controller controller;
    @Getter
    private int totalFloor;
    @Getter
    private volatile Direction currentDirection;
    @Getter
    private volatile Direction requestDirection;
    @Getter
    boolean isRunning;

    public Elevator(int totalFloor, Building building, int movingSpeed, int doorsSpeed, int standingTime, int capacity) {

        this.building = building;
        this.totalFloor = totalFloor;
        this.movingSpeed = movingSpeed;
        this.doorsSpeed = doorsSpeed;
        this.standingTime = standingTime;
        this.capacity = capacity;

        id = nextId++;
        openRequests = new TreeSet<>();
        currentDirection = Direction.Wait;
        requestDirection = Direction.Wait;
        passengers = new ArrayList<>();

    }

    public static Elevator defaultElevator(int totalFloor, Building building) {
        return new Elevator(totalFloor, building,
                DEFAULT_MOVING_SPEED, DEFAULT_DOORS_SPEED, DEFAULT_STANDING_TIME, DEFAULT_CAPACITY);
    }

    @Override
    public void run() {
        log.info("Elevator#{} start work", getId());
        isRunning = true;
        try {
            work();
        } finally {
            isRunning = false;
        }
    }

    @SneakyThrows
    private void openDoors() {
        Thread.sleep(doorsSpeed);
    }

    @SneakyThrows
    private void closeDoors() {
        Thread.sleep(doorsSpeed);
    }

    private void loadPassengers() {
        currentDirection = requestDirection;

        List<Person> toLoad = building.getPersonsList(totalFloor, requestDirection, capacity - totalWeight());
        toLoad.forEach((p) -> openRequests.add(p.getTargetFloor()));

        passengers.addAll(toLoad);
        log.info("{} people entered on the {} floor", toLoad.size(), totalFloor);
    }

    private void unloadPassengers() {
        List<Person> toUnload = passengers.stream()
                .filter(person -> person.getTargetFloor() == totalFloor)
                .collect(Collectors.toList());

        passengers.removeAll(toUnload);
        log.info("{} people came out on the {} floor", toUnload.size(), totalFloor);
    }

    @SneakyThrows
    private void goToNextFloor() {
        Thread.sleep(movingSpeed);
        totalFloor++;
    }

    @SneakyThrows
    private void goToPrevFloor() {
        Thread.sleep(movingSpeed);
        totalFloor--;
    }

    private void moveTo(int floor) {
        while (totalFloor != floor) {
            log.debug("Elevator#{} current floor {}, moving to the floor {}", id, totalFloor, floor);
            if (totalFloor < floor)
                goToNextFloor();
            else
                goToPrevFloor();
        }
        openRequests.remove(floor);
    }

    @SneakyThrows
    public void work() {
        while (isRunning) {
            if (openRequests.size() != 0) {
                int nextFloor = nextRequestFloor();
                moveTo(nextFloor);
                openDoors();
                loadPassengers();
                Thread.sleep(standingTime);
                unloadPassengers();
                closeDoors();
                openRequests.remove(totalFloor);
                if (openRequests.isEmpty()) {
                    log.info("Elevator#{} is wait now", id);
                    currentDirection = Direction.Wait;
                    requestDirection = Direction.Wait;
                }
            } else if (controller.getStorage().size() != 0) {
                Call call = controller.getStorage().poll();
                addCall(call);
            } else {
                // do nothing
            }
        }
    }

    // TODO Tests
    public boolean addCall(Call call) {
        if (currentDirection == Direction.Wait) {
            requestDirection = call.getDirection();
            if (totalFloor == call.getFloor())
                currentDirection = call.getDirection();
            else {
                currentDirection = call.getFloor() - totalFloor > 0 ? Direction.Up : Direction.Down;
            }
            return openRequests.add(call.getFloor());

        } else {
            int nextRequestFloor = nextRequestFloor();
            if (currentDirection == call.getDirection() && requestDirection == currentDirection) {
                if (call.getDirection() == Direction.Up && nextRequestFloor < call.getFloor()) {
                    System.out.println("h1");
                    return openRequests.add(call.getFloor());
                }
                else if (call.getDirection() == Direction.Down && nextRequestFloor > call.getFloor()) {
                    System.out.println("h2");
                    return openRequests.add(call.getFloor());
                } else {
                    return false;
                }
            } else {
              return false;
            }
        }
    }

    public int totalWeight() {
        return passengers.stream()
                .reduce(0, ((integer, person) -> {
                    return integer + person.getWeight();
                }), Integer::sum);
    }

    // hm
    public int nextRequestFloor() {
        return currentDirection == Direction.Up ?
                openRequests.ceiling(totalFloor) : openRequests.floor(totalFloor);
    }
}
