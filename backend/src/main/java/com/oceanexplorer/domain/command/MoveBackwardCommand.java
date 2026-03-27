package com.oceanexplorer.domain.command;

import com.oceanexplorer.domain.model.*;

public class MoveBackwardCommand implements Command {
    @Override
    public void execute(Probe probe) {
        probe.moveBackward();
    }
}