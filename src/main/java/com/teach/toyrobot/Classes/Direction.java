package com.teach.toyrobot.Classes;

public enum Direction {
    NORTH ("NORTH"),
    SOUTH ("SOUTH"),
    WEST ("WEST"),
    EAST ("EAST");

    private final String name;

    Direction(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
