package com.wsup;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.google.common.base.Preconditions.*;

@Slf4j
public class PersonGenerator implements Runnable {

    private final Building building;
    private final Random random;
    boolean isRunning;

    @Setter
    private int frequency;

    public PersonGenerator(Building building, int frequency) {
        this.building = building;
        this.frequency = frequency;
        random = new Random();
    }

    public Person generatePerson(int minFloor, int maxFloor) {
        checkArgument(minFloor < maxFloor,
                "minFloor must be less than the maxFloor");

        int bound = maxFloor - minFloor;
        int sum = minFloor >= 0 ? 1 : 2;

        int weight = random.nextInt(70) + 50;
        int startFloor = random.nextInt(bound + sum) + minFloor;
        int targetFloor;

        do {
            targetFloor = random.nextInt(bound + sum) + minFloor;
        } while (startFloor == targetFloor);

        return new Person(startFloor, targetFloor, weight);

    }

    public void addPersonToBuilding(Person p) {
        log.info("Added person to floor {}, targetFloor {}",
                p.getStartFloor(), p.getTargetFloor());
        building.addPerson(p);
    }

    @Override
    public void run() {

        isRunning = true;
        log.info("Person generator start work");

        try {
            while (isRunning) {
                int minFloor = building.getMinFloor();
                int maxFloor = building.getMaxFloor();
                Person person = generatePerson(minFloor, maxFloor);
                addPersonToBuilding(person);
                Thread.sleep(TimeUnit.SECONDS.toMillis(frequency));
            }
        } catch (InterruptedException e) {
            log.warn("Person generator interrupted: {}", e.getMessage());
        } finally {
            isRunning = false;
        }
    }
}
