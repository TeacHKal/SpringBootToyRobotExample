package com.teach.toyrobot.DAO;

import com.teach.toyrobot.Classes.ToyRobot;

import java.util.List;

public interface ToyRobotDao {

    List<ToyRobot> findAll();

    ToyRobot findById(int id);

    String report(int id);

    void turnRight(int id);

    void turnLeft(int id);

    void create(ToyRobot toyRobot);

    void move(int id);

    void deleteToyRobotById(int id);
}
