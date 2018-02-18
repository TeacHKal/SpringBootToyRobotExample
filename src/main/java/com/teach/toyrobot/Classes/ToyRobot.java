package com.teach.toyrobot.Classes;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class ToyRobot extends ObjectItem implements IMove {

    private static final int MOVE_INTERVAL = 1;

    public ToyRobot() { super(); }

    public ToyRobot(int id, int pointX, int pointY, Direction direction) {
        super(id, pointX, pointY, direction);
    }

    @Override
    public void move() {
        switch (this.getDirection()) {
            case NORTH:
                if (this.pointY + this.moveInterval() <= TableBoundaries.TOP)
                    this.pointY += this.moveInterval();
                break;
            case SOUTH:
                if (this.pointY - this.moveInterval() >= TableBoundaries.BOTTOM)
                    this.pointY -= this.moveInterval();
                break;
            case WEST:
                if (this.pointX - this.moveInterval() >= TableBoundaries.LEFT)
                    this.pointX -= this.moveInterval();
                break;
            case EAST:
                if (this.pointX + this.moveInterval() <= TableBoundaries.RIGHT)
                    this.pointX += this.moveInterval();
                break;
            default: break;
        }
    }

    @Override
    public void turnLeft() {
        this.changeDirection(this.direction, DIRECTION_LEFT);
    }

    @Override
    public void turnRight() {
        this.changeDirection(this.direction, DIRECTION_RIGHT);
    }

    @Override
    public int moveInterval() {
        return this.MOVE_INTERVAL;
    }

    @Override
    public String report() {
        return this.toString();
    }

    private void changeDirection(Direction currentDirection, String turnTo){

        switch (currentDirection) {
            case NORTH:
                this.direction = (turnTo.equals(DIRECTION_LEFT)) ? Direction.WEST : Direction.EAST;
                break;
            case SOUTH:
                this.direction = (turnTo.equals(DIRECTION_LEFT)) ? Direction.EAST : Direction.WEST;
                break;
            case WEST:
                this.direction = (turnTo.equals(DIRECTION_LEFT)) ? Direction.SOUTH : Direction.NORTH;
                break;
            case EAST:
                this.direction = (turnTo.equals(DIRECTION_LEFT)) ? Direction.NORTH : Direction.SOUTH;
                break;
            default: break;
        }
    }

    public static String toCSVFormat(List<ToyRobot> toyRobots){
        StringBuilder sb = new StringBuilder();

        for (ToyRobot toyRobot : toyRobots) {
            sb.append(toCSVFormat(toyRobot));
            sb.append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }

    public static String toCSVFormat(ToyRobot toyRobot){

        final String CSV_SEPARATOR = ", ";
        StringBuilder sb = new StringBuilder();

        sb.append(toyRobot.id);
        sb.append(CSV_SEPARATOR);
        sb.append(toyRobot.direction);
        sb.append(CSV_SEPARATOR);
        sb.append(toyRobot.pointX);
        sb.append(CSV_SEPARATOR);
        sb.append(toyRobot.pointY);

        return sb.toString();
    }
}
