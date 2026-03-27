package com.oceanexplorer.unit;

import com.oceanexplorer.domain.command.*;
import com.oceanexplorer.domain.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommandTest {

    @Test
    void shouldExecuteSequence() {
        Grid grid = new Grid(5, 5);
        Probe probe = new Probe(new Position(0, 0), Direction.NORTH, grid);

        Command forward = new MoveForwardCommand();
        Command right = new TurnRightCommand();

        forward.execute(probe);
        right.execute(probe);
        forward.execute(probe);

        assertEquals(1, probe.getPosition().getX());
        assertEquals(1, probe.getPosition().getY());
        assertEquals(Direction.EAST, probe.getDirection());
    }
}