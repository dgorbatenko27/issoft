package com.issoft.entity.elevator;

public class ElevatorEvent {

    private final int targetFloor;
    private final Direction direction;

    ElevatorEvent(int targetFloor, Direction direction) {
        this.direction = direction;
        this.targetFloor = targetFloor;
    }
}
