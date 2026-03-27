package com.oceanexplorer.service;

import com.oceanexplorer.domain.command.*;
import com.oceanexplorer.domain.model.*;
import com.oceanexplorer.dto.ProbeRequest;
import com.oceanexplorer.dto.ProbeResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProbeService {

    public ProbeResponse execute(ProbeRequest request) {

        Grid grid = new Grid(request.getGridWidth(), request.getGridHeight());
        Probe probe = new Probe(
                new Position(request.getStartX(), request.getStartY()),
                Direction.valueOf(request.getDirection()),
                grid
        );

        for (char cmd : request.getCommands().toCharArray()) {
            switch (cmd) {
                case 'F' -> probe.moveForward();
                case 'B' -> probe.moveBackward();
                case 'L' -> probe.turnLeft();
                case 'R' -> probe.turnRight();
            }
        }

        return new ProbeResponse(
                probe.getPosition().getX(),
                probe.getPosition().getY(),
                probe.getDirection().name()
        );
    }

    private List<Command> parseCommands(String commandStr) {
        List<Command> commands = new ArrayList<>();

        for (char c : commandStr.toCharArray()) {
            switch (c) {
                case 'F' -> commands.add(new MoveForwardCommand());
                case 'B' -> commands.add(new MoveBackwardCommand());
                case 'L' -> commands.add(new TurnLeftCommand());
                case 'R' -> commands.add(new TurnRightCommand());
                default -> throw new IllegalArgumentException("Invalid command: " + c);
            }
        }

        return commands;
    }
}