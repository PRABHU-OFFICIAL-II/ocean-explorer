package com.oceanexplorer.domain.command;

import com.oceanexplorer.domain.model.Probe;

public class TurnRightCommand implements Command {

    @Override
    public void execute(Probe probe) {
        probe.turnRight();
    }
}