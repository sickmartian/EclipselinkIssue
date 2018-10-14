package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EntityThatContains {
    @Id
    @GeneratedValue
    private Long id;
    private MyEntity myEntity;
    private String containsA;
    private String containsB;

    private EntityThatContains() {}

    public EntityThatContains(MyEntity myEntity, String containsA, String containsB) {
        this.myEntity = myEntity;
        this.containsA = containsA;
        this.containsB = containsB;
    }

    public MyEntity getMyEntity() {
        return myEntity;
    }

    public String getContainsA() {
        return containsA;
    }

    public String getContainsB() {
        return containsB;
    }

    @Override
    public String toString() {
        return "EntityThatContains{" +
                "myEntity=" + myEntity +
                ", containsA='" + containsA + '\'' +
                ", containsB='" + containsB + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }
}
