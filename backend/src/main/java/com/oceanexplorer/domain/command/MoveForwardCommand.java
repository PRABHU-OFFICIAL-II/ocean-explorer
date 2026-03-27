package com.oceanexplorer.domain.command;

import com.oceanexplorer.domain.model.Probe;

public class MoveForwardCommand implements Command {

    @Override
    public void execute(Probe probe) {
        probe.moveForward();
    }
}