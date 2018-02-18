package com.teach.toyrobot.Service;

import com.teach.toyrobot.Classes.SaveToFile;
import com.teach.toyrobot.Classes.ToyRobot;
import com.teach.toyrobot.DAO.ToyRobotDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ToyRobotServiceImpl implements ToyRobotService{

    @Autowired
    //@Qualifier("FakeToyRobotDaoImpl")
    @Qualifier("ToyRobotDaoImpl")
    ToyRobotDao toyRobotDao;
    @Autowired
    private SaveToFile saveToFile;

    @Override
    public void move(int id) {
        toyRobotDao.move(id);
    }

    @Override
    public void turnLeft(int id) {
        toyRobotDao.turnLeft(id);
    }

    @Override
    public void turnRight(int id) {
        toyRobotDao.turnRight(id);
    }

    @Override
    public String report(int id) {
        return toyRobotDao.report(id);
    }

    @Override
    public void create(ToyRobot toyRobot) {
        toyRobotDao.create(toyRobot);
    }

    @Override
    public List<ToyRobot> findAll(){
        List<ToyRobot> robots = toyRobotDao.findAll();
        try {
            saveToFile.save(ToyRobot.toCSVFormat(robots));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return robots;
    }

    @Override
    public ToyRobot findById(int id) {
        ToyRobot toyRobot = toyRobotDao.findById(id);
        try {
            saveToFile.save(ToyRobot.toCSVFormat(toyRobot));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return toyRobot;
    }

    @Override
    public void deleteToyRobotById(int id) {
        toyRobotDao.deleteToyRobotById(id);
    }
}
