package com.example;

import com.example.entities.MyEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@RunWith(JUnit4.class)
public class MyTest {

    @Test
    public void myTest() {
        EntityManager em = Persistence.createEntityManagerFactory("").createEntityManager();

        MyEntity e = new MyEntity("first", "a", "b");

        em.persist(e);

        assert em.contains(e);
    }

}
