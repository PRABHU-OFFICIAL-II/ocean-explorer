package com.oceanexplorer.dto;

import java.util.List;

public class ProbeRequest {

    private int startX;
    private int startY;
    private String direction;
    private String commands;
    private int gridWidth;
    private int gridHeight;
    private List<int[]> obstacles;


    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    public int getGridWidth() {
        return gridWidth;
    }

    public void setGridWidth(int gridWidth) {
        this.gridWidth = gridWidth;
    }

    public int getGridHeight() {
        return gridHeight;
    }

    public void setGridHeight(int gridHeight) {
        this.gridHeight = gridHeight;
    }

    public List<int[]> getObstacles() {
        return obstacles;
    }

    public void setObstacles(List<int[]> obstacles) {
        this.obstacles = obstacles;
    }
}