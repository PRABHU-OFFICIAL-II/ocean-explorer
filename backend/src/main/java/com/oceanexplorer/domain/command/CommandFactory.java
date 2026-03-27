package com.oceanexplorer.domain.command;

import java.util.Map;

public class CommandFactory {

    private static final Map<Character, Command> commands = Map.of(
            'F', new MoveForwardCommand(),
            'B', new MoveBackwardCommand(),
            'L', new TurnLeftCommand(),
            'R', new TurnRightCommand()
    );

    public static Command get(char c) {
        if (!commands.containsKey(c)) {
            throw new RuntimeException("Invalid command: " + c);
        }
        return commands.get(c);
    }
}