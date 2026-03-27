package com.oceanexplorer.domain.model;

import java.util.Objects;

public class Position {
    private int x;
    private int y;

    public Position() {}

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position move(Direction dir, boolean forward) {
        int step = forward ? 1 : -1;

        return switch (dir) {
            case NORTH -> new Position(x, y + step);
            case SOUTH -> new Position(x, y - step);
            case EAST -> new Position(x + step, y);
            case WEST -> new Position(x - step, y);
        };
    }

    public int getX() { return x; }
    public int getY() { return y; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position p)) return false;
        return x == p.x && y == p.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}