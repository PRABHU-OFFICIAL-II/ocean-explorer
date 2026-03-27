package com.oceanexplorer.domain.command;

import com.oceanexplorer.domain.model.Probe;

public interface Command {
    void execute(Probe probe);
}