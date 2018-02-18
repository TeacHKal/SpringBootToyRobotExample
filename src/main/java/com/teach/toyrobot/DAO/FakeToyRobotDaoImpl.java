package com.teach.toyrobot.DAO;

import com.teach.toyrobot.Classes.Direction;
import com.teach.toyrobot.Classes.ToyRobot;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Qualifier("FakeToyRobotDaoImpl")
public class FakeToyRobotDaoImpl implements ToyRobotDao {

    private static final String ROBOT_MISSING = "Output: ROBOT MISSING";

    private static List<ToyRobot> toyRobots;

    static {
        toyRobots = new ArrayList<>();
            toyRobots.add(new ToyRobot(1, 0, 0, Direction.NORTH));
            toyRobots.add(new ToyRobot(2, 0, 0, Direction.NORTH));
            toyRobots.add(new ToyRobot(3, 1, 2, Direction.EAST));
    }

    @Override
    public List<ToyRobot> findAll(){
        return this.toyRobots;
    }

    @Override
    public ToyRobot findById(int id) {
        return toyRobots.get(id);
    }

    @Override
    public String report(int id) {
        if(toyRobots.get(id) != null){
            return toyRobots.get(id).report();
        }
        return this.ROBOT_MISSING;
    }

    @Override
    public void turnRight(int id) {
        if(toyRobots.get(id) != null) {
            toyRobots.get(id).turnRight();
        }
    }

    @Override
    public void turnLeft(int id) {
        if(toyRobots.get(id) != null) {
            toyRobots.get(id).turnLeft();
        }
    }

    @Override
    public void create(ToyRobot toyRobot) {
            this.toyRobots.add(toyRobot.getId(), toyRobot);
    }

    @Override
    public void move(int id) {
        if(toyRobots.get(id) != null) {
            toyRobots.get(id).move();
        }
    }

    @Override
    public void deleteToyRobotById(int id) {
        toyRobots.remove(id);
    }
}
