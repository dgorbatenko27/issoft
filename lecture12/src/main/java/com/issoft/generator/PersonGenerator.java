package com.issoft.generator;

import com.issoft.entity.Building;
import com.issoft.entity.Person;

import java.util.Random;

public class PersonGenerator {

    private final Building building;
    public int frequency;
    private final Random random;

    public PersonGenerator(Building building, int frequency) {
        this.building = building;
        this.frequency = frequency;
        random = new Random();
    }

    public Person generatePerson(int minFloor, int maxFloor) {

        int bound = maxFloor - minFloor;

        int weight = random.nextInt(70) + 50;
        // todo normal bounds
        int startFloor = random.nextInt();
        int targetFloor;

        do {
            targetFloor = random.nextInt();
        } while (startFloor == targetFloor);

        return new Person(startFloor, targetFloor, weight);

    }
}
