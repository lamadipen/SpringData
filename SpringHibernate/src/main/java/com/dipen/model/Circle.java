package com.dipen.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by dipen on 6/9/2017.
 */
@Entity
public class Circle {
    @Id
    private int id;
    private String name;

    public Circle(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Circle() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
