package com.example.entities;

import org.eclipse.persistence.annotations.Index;

import javax.persistence.*;

@Entity
public class MyEntity {
    @Id
    private String myId;

    @Index
    private String entityFieldA;
    private String entityFieldB;

    private MyEntity() {}

    public MyEntity(String myId) {
        this.myId = myId;
    }

    public String getMyId() {
        return myId;
    }

    public String getEntityFieldA() {
        return entityFieldA;
    }

    public void setEntityFieldA(String entityFieldA) {
        this.entityFieldA = entityFieldA;
    }

    public String getEntityFieldB() {
        return entityFieldB;
    }

    public void setEntityFieldB(String entityFieldB) {
        this.entityFieldB = entityFieldB;
    }

    @Override
    public String toString() {
        return "MyEntity{" +
                "myId='" + myId + '\'' +
                ", entityFieldA='" + entityFieldA + '\'' +
                ", entityFieldB='" + entityFieldB + '\'' +
                '}';
    }
}
