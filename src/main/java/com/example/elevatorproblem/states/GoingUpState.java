package com.example.elevatorproblem.states;

import com.example.elevatorproblem.Elevator;
import com.example.elevatorproblem.states.interfaces.ElevatorState;



public final class GoingUpState implements ElevatorState {

    @Override
    public void up(final Elevator elevator, final int where) {
        if (elevator.getCurrentFloor() != where) {
            elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
            up(elevator, where);
        } else {
            this.rest(elevator);
        }
    }

    @Override
    public void down(final Elevator elevator, final int where) {
        throw new IllegalStateException("Elevator is ascending, Wait until it reach top floor.");
    }

    @Override
    public void rest(final Elevator elevator) {
        elevator.setElevatorState(new RestingState());
        if (elevator.getCurrentFloor() != elevator.getNumberOfFloors()) {
            elevator.setElevatorState(this);
        } else {
            elevator.setElevatorState(new GoingDownState());
        }
    }


    @Override
    public void stop(Elevator elevator) {
        elevator.setElevatorState(new StopState());
    }
}
