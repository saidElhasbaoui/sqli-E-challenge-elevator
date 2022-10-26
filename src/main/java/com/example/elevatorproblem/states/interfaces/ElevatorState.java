package com.example.elevatorproblem.states.interfaces;

import com.example.elevatorproblem.Elevator;

public interface ElevatorState {

    void up(Elevator elevator, int where);

    void down(Elevator elevator, int where);

    void rest(Elevator elevator);

    void stop(Elevator elevator);
}
