package com.example.entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class ETCParent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
