package com.teach.toyrobot.DAO;

import com.teach.toyrobot.Classes.SaveToFile;
import com.teach.toyrobot.Classes.ToyRobot;
import com.teach.toyrobot.aspect.annotations.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Qualifier("ToyRobotDaoImpl")
public class ToyRobotDaoImpl implements ToyRobotDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ToyRobot> findAll() {
        Session session = sessionFactory.openSession();
        return session.createCriteria(ToyRobot.class).list();
    }

    @Override
    public ToyRobot findById(int id) {
        Session session = sessionFactory.openSession();
        return session.get(ToyRobot.class, id);
    }

    @Override
    public String report(int id) {
        return this.findById(id).report();
    }

    @Override
    public void turnRight(int id) {
        Session session = sessionFactory.openSession();
        ToyRobot toyRobot = this.findById(id);
        toyRobot.turnRight();

        session.beginTransaction();
        session.update(toyRobot);
        session.getTransaction().commit();
    }

    @Override
    public void turnLeft(int id) {
        Session session = sessionFactory.openSession();
        ToyRobot toyRobot = this.findById(id);
        toyRobot.turnLeft();

        session.beginTransaction();
        session.update(toyRobot);
        session.getTransaction().commit();
    }

    @Override
    public void create(ToyRobot toyRobot) {
        Session session = sessionFactory.openSession();
        Integer id = (Integer) session.save(toyRobot);
    }

    @Override
    public void move(int id) {
        Session session = sessionFactory.openSession();
        ToyRobot toyRobot = this.findById(id);
        toyRobot.move();

        session.beginTransaction();
        session.update(toyRobot);
        session.getTransaction().commit();
    }

    @Override
    public void deleteToyRobotById(int id) {
        Session session = sessionFactory.openSession();
        session.delete(id);
    }
}
