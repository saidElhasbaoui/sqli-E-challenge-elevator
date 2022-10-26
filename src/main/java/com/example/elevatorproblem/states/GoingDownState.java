package com.example.elevatorproblem.states;

import com.example.elevatorproblem.Elevator;
import com.example.elevatorproblem.states.interfaces.ElevatorState;


public final class GoingDownState implements ElevatorState {


    @Override
    public void up(final Elevator elevator, final int where) {
        throw new IllegalStateException("Elevator is descending, Wait until it reach bottom floor.");
    }

    @Override
    public void down(final Elevator elevator, final int where) {
        if (elevator.getCurrentFloor() != where) {
            elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
            down(elevator, where);
        } else {
            this.rest(elevator);
        }
    }

    @Override
    public void rest(final Elevator elevator) {
        elevator.setElevatorState(new RestingState());
        if (elevator.getCurrentFloor() != 1) {
            elevator.setElevatorState(this);
        } else {
            elevator.setElevatorState(new GoingUpState());
        }
    }

    @Override
    public void stop(Elevator elevator) {
        elevator.setElevatorState(new StopState());
    }
}
