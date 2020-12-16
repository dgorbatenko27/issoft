package com.issoft.entity;

import lombok.Getter;

public class Person {

    private static int nextID = 0;

    @Getter
    private final int id;
    @Getter
    private final int startFloor;
    @Getter
    private final int targetFloor;
    @Getter
    private final int weight;

    public Person(int startFloor, int targetFloor, int weight) {
        id = nextID++;
        this.startFloor = startFloor;
        this.targetFloor = targetFloor;
        this.weight = weight;
    }

}
