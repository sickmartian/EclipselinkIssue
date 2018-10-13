package com.example.entities;

import org.eclipse.persistence.annotations.Index;

import javax.persistence.Entity;

@Entity
public class EntityThatContains extends ETCParent {

    @Index
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
}
