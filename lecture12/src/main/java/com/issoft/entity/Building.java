package com.issoft.entity;

import com.issoft.controller.Controller;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import static com.google.common.base.Preconditions.*;

public class Building {

    private Controller controller;

    private Map<Integer, Floor> floors;
    @Getter
    private final int minFloor;
    @Getter
    private final int maxFloor;

    public Building(int minFloor, int maxFloor) {
        checkArgument(minFloor < maxFloor);
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        floors = new HashMap<>();
        for (int i = minFloor; i < maxFloor; i++) {
           floors.put(i, new Floor(this, i));
        }
    }

}
