package com.wsup;

import lombok.Getter;

import java.util.*;

import static com.google.common.base.Preconditions.*;

public class Building {

    private static final int MINIMUM_HEIGHT = 2;

    @Getter
    private final Controller controller;

    @Getter
    private final Map<Integer, Floor> floors;

    @Getter
    private final int minFloor;
    @Getter
    private final int maxFloor;

    public Building(int height, int amountOfElevators) {
        checkArgument(height >= MINIMUM_HEIGHT);
        checkArgument(amountOfElevators > 0);

        this.minFloor = 0;
        this.maxFloor = height - 1;

        floors = new HashMap<>();
        for (int i = minFloor; i <= maxFloor; i++)
            floors.put(i, new Floor(this, i));
        controller = new Controller(this, amountOfElevators);
    }

    public void startController() {
        controller.startElevators();
    }

    public void addPerson(Person p) {
        int startFloor = p.getStartFloor();
        floors.get(startFloor).addPerson(p);
        controller.doRequest(new Call(p));
    }

    // todo test
    public List<Person> getPersonsList(int floor, Direction direction, int permittedWeight) {

        List<Person> personList = new ArrayList<>();
        Queue<Person> queue;
        if (direction == Direction.Up)
            queue = floors.get(floor).getUpQueue();
        else if (direction == Direction.Down)
            queue = floors.get(floor).getDownQueue();
        else {
            throw new IllegalArgumentException();
        }

        int personsWeight = 0;
        while (queue.peek() != null && personsWeight < permittedWeight - queue.peek().getWeight()) {
            Person person = queue.poll();
            personList.add(person);
        }
        if (!queue.isEmpty())
            controller.doRequest(new Call(floor, direction));
        return personList;

    }

}
