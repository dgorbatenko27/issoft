package com.wsup;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

@Slf4j
public class Controller {

    @Getter
    private final Building building;

    @Getter
    private final ConcurrentLinkedQueue<Call> storage;

    private final List<Elevator> elevators;

    public Controller(Building building, List<Elevator> elevators) {
        this.building = building;
        this.elevators = elevators;
        storage = new ConcurrentLinkedQueue<>();
        elevators.forEach(elevator -> elevator.setController(this));
    }

    public Controller(Building building, int amountOfElevators) {
        this.building = building;

        elevators = new ArrayList<>();
        for (int i = 0; i < amountOfElevators; i++)
            elevators.add(Elevator.defaultElevator(0, building));
        elevators.forEach(elevator -> elevator.setController(this));
        storage = new ConcurrentLinkedQueue<>();
    }

    public void startElevators() {
        for (Elevator el : elevators)
            new Thread(el).start();
    }

    public void doRequest(Call call) {
        int elevatorId = getMostSuitableElevator(call);
        if (elevatorId != -1) {
            boolean added = elevators.get(elevatorId).addCall(call);
            if (added) {
                log.debug("request: {} sent to the elevator with id:{} ", call, elevatorId);
            } else {
                storage.add(call);
            }
        } else {
            storage.add(call);
            log.debug("request has been pushed to the storage");
        }
    }

    //todo test
    public int getMostSuitableElevator(Call call) {
        int elevatorId = -1;
        int floorDif = Integer.MAX_VALUE;
        for (int i = 0; i < elevators.size(); i++) {
            Elevator el = elevators.get(i);
            if (isSuitableElevator(el, call)) {
                int floorDifference = Math.abs(el.getTotalFloor() - call.getFloor());
                if ( floorDif > floorDifference) {
                    floorDif = floorDifference;
                    elevatorId = i;
                }
            }
        }
        return elevatorId;
    }

    public static boolean isSuitableElevator(Elevator elevator, Call call) {
        return elevator.getCurrentDirection() == Direction.Wait ||
                (elevator.getCurrentDirection() == Direction.Up &&
                        call.getDirection() == Direction.Up &&
                        elevator.getTotalFloor() < call.getFloor())
                || (elevator.getCurrentDirection() == Direction.Down &&
                call.getDirection() == Direction.Down &&
                elevator.getTotalFloor() > call.getFloor());
    }

    public List<Elevator> getElevators() {
        return List.copyOf(elevators);
    }
}
