package com.wsup;

import lombok.Getter;
import lombok.ToString;

@ToString
public class Call {

    @Getter
    int floor;
    @Getter
    Direction direction;

    public Call(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }

    public Call(Person p) {
            Direction dir = p.getTargetFloor() - p.getStartFloor() > 0 ? Direction.Up : Direction.Down;
            this.floor = p.getStartFloor();
            this.direction = dir;
    }

}
