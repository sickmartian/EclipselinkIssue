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

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "parent", fetch = FetchType.LAZY)
    private SubEntity subEntity;

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

    public SubEntity getSubEntity() {
        return subEntity;
    }

    public void setSubEntity(SubEntity subEntity) {
        this.subEntity = subEntity;
    }

    @Override
    public String toString() {
        return "MyEntity{" +
                "myId='" + myId + '\'' +
                ", entityFieldA='" + entityFieldA + '\'' +
                ", entityFieldB='" + entityFieldB + '\'' +
                ", subEntity=" + subEntity +
                '}';
    }
}
