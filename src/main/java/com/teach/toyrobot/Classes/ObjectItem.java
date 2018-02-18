package com.teach.toyrobot.Classes;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.MessageFormat;

@Entity
@Table(name = "object_items")
abstract class ObjectItem {

    protected final static String DIRECTION_LEFT = "LEFT";
    protected final static String DIRECTION_RIGHT = "RIGHT";


    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "id", unique = true)
    protected int id;

    @NotNull
    @Range(min=TableBoundaries.LEFT, max=TableBoundaries.RIGHT)
    @Column(name = "pointX")
    protected int pointX;

    @NotNull
    @Range(min=TableBoundaries.BOTTOM, max=TableBoundaries.TOP)
    @Column(name = "pointY")
    protected int pointY;

    @NotNull
    @Column(name = "direction")
    @Enumerated(EnumType.STRING)
    protected Direction direction;

    protected abstract String report();

    // no-argument constructor (Hibernate needs it)
    public ObjectItem() { }

    public ObjectItem(int id, int pointX, int pointY, Direction direction){
        this.id = id;
        this.pointX = pointX;
        this.pointY = pointY;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return MessageFormat.format("Output: {0}, {1}, {2}", this.pointX, this.pointY, this.direction);
    }


    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPointX() {
        return pointX;
    }

    public void setPointX(int pointX) {
        this.pointX = pointX;
    }

    public int getPointY() {
        return pointY;
    }

    public void setPointY(int pointY) {
        this.pointY = pointY;
    }
}
