package com.issoft.controller;

import com.issoft.entity.Building;
import com.issoft.entity.elevator.Elevator;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private final Building building;
    private final List<Elevator> elevators;

//    private final Queue<> storage;

    public Controller(Building building) {
        this.building = building;
        elevators = new ArrayList<>();
    }

    public void addElevators(List<Elevator> elevators) {
        this.elevators.addAll(elevators);
    }
}
