package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class SubEntity {
    @Id
    @OneToOne
    private MyEntity parent;

    private String subFieldA;

    private String subFieldB;

    private SubEntity() {}

    public SubEntity(MyEntity parent, String subFieldA, String subFieldB) {
        this.parent = parent;
        this.subFieldA = subFieldA;
        this.subFieldB = subFieldB;
    }

    public MyEntity getParent() {
        return parent;
    }

    public String getSubFieldA() {
        return subFieldA;
    }

    public String getSubFieldB() {
        return subFieldB;
    }
}
