package com.wsup;

public class ElevatorSimulation {

    public static void main(String[] args) {

        startSim(15, 3, 1);

    }

    public static void startSim(int buildingHeight, int amountOfElevators, int peopleGeneratorFrequency) {

        Building building = new Building(buildingHeight, amountOfElevators);
        building.startController();

        PersonGenerator generator = new PersonGenerator(building, peopleGeneratorFrequency);
        new Thread(generator).start();

    }
}
