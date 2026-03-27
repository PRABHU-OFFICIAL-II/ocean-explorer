package com.oceanexplorer.dto;

public class ProbeResponse {

    private int finalX;
    private int finalY;
    private String direction;

    public ProbeResponse(int finalX, int finalY, String direction) {
        this.finalX = finalX;
        this.finalY = finalY;
        this.direction = direction;
    }

    public int getFinalX() {
        return finalX;
    }

    public int getFinalY() {
        return finalY;
    }

    public String getDirection() {
        return direction;
    }
}