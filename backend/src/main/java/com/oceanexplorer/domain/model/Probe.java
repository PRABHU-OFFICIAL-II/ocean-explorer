package com.oceanexplorer.domain.model;

public class Probe {

    private Position position;
    private Direction direction;
    private Grid grid;

    public Probe(Position position, Direction direction, Grid grid) {
        this.position = position;
        this.direction = direction;
        this.grid = grid;
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void moveForward() {
        int newX = position.getX();
        int newY = position.getY();

        switch (direction) {
            case NORTH -> newY++;
            case SOUTH -> newY--;
            case EAST -> newX++;
            case WEST -> newX--;
        }

        // Boundary check
        if (grid.isInside(newX, newY) && !grid.isObstacle(newX, newY)) {
            position = new Position(newX, newY);
        }
    }

    public void moveBackward() {
        int newX = position.getX();
        int newY = position.getY();

        switch (direction) {
            case NORTH -> newY--;
            case SOUTH -> newY++;
            case EAST -> newX--;
            case WEST -> newX++;
        }

        if (grid.isInside(newX, newY) && !grid.isObstacle(newX, newY)) {
            position = new Position(newX, newY);
        }
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }
}