package com.issoft.entity;

import java.util.LinkedList;
import java.util.Queue;

public class Floor {

    private final Building building;

    private final int floorNumber;
    private final Queue<Person> upQueue;
    private final Queue<Person> downQueue;

    public Floor(Building building, int floorNumber) {
        this.building = building;
        this.floorNumber = floorNumber;
        upQueue = new LinkedList<>();
        downQueue = new LinkedList<>();
    }


}
