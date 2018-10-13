package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MyEntity {
    @Id
    private String myId;
    private String entityFieldA;
    private String entityFieldB;
    private SubEntity subEntity;

    private MyEntity() {}

    public MyEntity(String myId, String entityFieldA, String entityFieldB) {
        this.myId = myId;
        this.entityFieldA = entityFieldA;
        this.entityFieldB = entityFieldB;
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

    public SubEntity getSubEntity() {
        return subEntity;
    }

    public void setSubEntity(SubEntity subEntity) {
        this.subEntity = subEntity;
    }
}
