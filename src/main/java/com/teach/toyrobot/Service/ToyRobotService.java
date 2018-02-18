package com.teach.toyrobot.Service;

import com.teach.toyrobot.Classes.ToyRobot;
import java.util.List;

public interface ToyRobotService {
    void move(int id);

    void turnLeft(int id);

    void turnRight(int id);

    String report(int id);

    void create(ToyRobot toyRobot);

    List<ToyRobot> findAll();

    ToyRobot findById(int id);

    void deleteToyRobotById(int id);
}
