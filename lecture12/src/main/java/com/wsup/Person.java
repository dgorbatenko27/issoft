package com.wsup;

import lombok.Getter;
import lombok.ToString;

import static com.google.common.base.Preconditions.checkArgument;

@ToString
@Getter
public class Person {

    static int nextId;
    @ToString.Exclude
    private final int id;
    private final int startFloor;
    private final int targetFloor;
    private final int weight;

    public Person(int startFloor, int targetFloor, int weight) {
        checkArgument(startFloor != targetFloor);
        checkArgument(weight > 2);

        id = nextId++;
        this.startFloor = startFloor;
        this.targetFloor = targetFloor;
        this.weight = weight;
    }
}
