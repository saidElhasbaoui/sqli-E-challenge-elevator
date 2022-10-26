package com.example.elevatorproblem;

import com.example.elevatorproblem.states.RestingState;
import com.example.elevatorproblem.states.interfaces.ElevatorState;

public class Elevator  {
    private int numberOfFloors = 0;
    private ElevatorState elevatorState;
    private String id;
    private int currentFloor;


    public Elevator(final String elevatorId, final int elevatorCurrentFloor, final int buildingFloors) {
        this.id = elevatorId;
        this.currentFloor = elevatorCurrentFloor;
        elevatorState = new RestingState();
        numberOfFloors = buildingFloors;
    }


    public ElevatorState getElevatorState() {
        return elevatorState;
    }


    public void setElevatorState(final ElevatorState elevatorNewState) {
        this.elevatorState = elevatorNewState;
    }


    public String getId() {
        return id;
    }

    public void setId(final String elevatorId) {
        this.id = elevatorId;
    }


    public int getCurrentFloor() {
        return currentFloor;
    }


    public void setCurrentFloor(final int elevatorCurrentFloor) {
        this.currentFloor = elevatorCurrentFloor;
    }


    public void serve(final int floor) {
        if (floor > currentFloor) {
            try {
                elevatorState.up(this, floor);
            } catch (IllegalStateException e) {
                elevatorState.down(this, 1);
                elevatorState.up(this, floor);
            }
        } else if (floor < currentFloor) {
            try {
                elevatorState.down(this, floor);
            } catch (IllegalStateException e) {
                elevatorState.up(this, numberOfFloors);
                elevatorState.down(this, floor);
            }
        }
    }


    public void stop(final int floor) {
        serve(floor);
        elevatorState.stop(this);
    }


    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
