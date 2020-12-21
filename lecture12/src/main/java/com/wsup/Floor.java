package com.wsup;

import lombok.Getter;

import java.util.LinkedList;
import java.util.Queue;

@Getter
public class Floor {

    private final Building building;
    private final int floorNumber;
    private final Queue<Person> upQueue;
    private final Queue<Person> downQueue;

    public Floor(Building building, int floorNumber) {
        upQueue = new LinkedList<>();
        downQueue = new LinkedList<>();
        this.building = building;
        this.floorNumber = floorNumber;
    }

    public void addPerson(Person p) {
        if (p.getTargetFloor() > floorNumber)
            upQueue.add(p);
        else if (p.getTargetFloor() < floorNumber)
            downQueue.add(p);
        else {
            // do nothing
        }
    }
}
