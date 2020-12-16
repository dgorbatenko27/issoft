package com.issoft.entity.elevator;

import com.issoft.controller.Controller;
import com.issoft.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Elevator {

    private Controller controller;

    private final int movingSpeed;
    private final int doorsSpeed;
    private final int capacity;

    private final AtomicInteger totalFloor;
    private final List<Person> passengers;

    private final int minFloor;
    private final int maxFloor;

//    private final Map<Integer, ElevatorEvent> elevatorEventMap;

    public Elevator(int minFloor, int maxFloor, int totalFloor, int movingSpeed,
                    int doorsSpeed, int capacity) {
        this.movingSpeed = movingSpeed;
        this.doorsSpeed = doorsSpeed;
        this.capacity = capacity;
        this.totalFloor = new AtomicInteger(totalFloor);
        this.passengers = new ArrayList<>();
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }
}
