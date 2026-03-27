package com.oceanexplorer.unit;

import com.oceanexplorer.domain.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProbeTest {

    @Test
    void shouldMoveForward() {
        Grid grid = new Grid(5, 5);
        Probe probe = new Probe(new Position(0, 0), Direction.NORTH, grid);

        probe.moveForward();

        assertEquals(0, probe.getPosition().getX());
        assertEquals(1, probe.getPosition().getY());
    }

    @Test
    void shouldTurnRight() {
        Grid grid = new Grid(5, 5);
        Probe probe = new Probe(new Position(0, 0), Direction.NORTH, grid);

        probe.turnRight();

        assertEquals(Direction.EAST, probe.getDirection());
    }

    @Test
    void shouldNotCrossBoundary() {
        Grid grid = new Grid(5, 5);
        Probe probe = new Probe(new Position(0, 4), Direction.NORTH, grid);

        probe.moveForward();

        assertEquals(4, probe.getPosition().getY()); // stays
    }

    @Test
    void shouldAvoidObstacle() {
        Grid grid = new Grid(5, 5);
        grid.addObstacle(0, 1);

        Probe probe = new Probe(new Position(0, 0), Direction.NORTH, grid);

        probe.moveForward();

        assertEquals(0, probe.getPosition().getY()); // blocked
    }
}