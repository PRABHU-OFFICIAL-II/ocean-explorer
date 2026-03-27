package com.oceanexplorer.domain.model;

import java.util.HashSet;
import java.util.Set;

public class Grid {

    private int width;
    private int height;
    private Set<String> obstacles = new HashSet<>();

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void addObstacle(int x, int y) {
        obstacles.add(x + "," + y);
    }

    public boolean isObstacle(int x, int y) {
        return obstacles.contains(x + "," + y);
    }

    public boolean isInside(int x, int y) {
        return x >= 0 && y >= 0 && x < width && y < height;
    }
}