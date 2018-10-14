package com.example;

import com.example.entities.EntityThatContains;
import com.example.entities.MyEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;

@RunWith(JUnit4.class)
public class MyTest {

    private EntityManager em = Persistence.createEntityManagerFactory("").createEntityManager();
    private static final int VOLUME = 15000;
    private static final int TIMES = 3;

    @Test
    public void myTest() {
        List<MyEntity> preExistingList = Arrays.asList(generatePreExisting("pa"),
                generatePreExisting("pb"), generatePreExisting("pc"), generatePreExisting("pd"),
                generatePreExisting("pe"), generatePreExisting("pf"), generatePreExisting("pg"),
                generatePreExisting("ph"), generatePreExisting("pi"), generatePreExisting("pj"),
                generatePreExisting("pk"), generatePreExisting("pl"), generatePreExisting("pm"));

        em.getTransaction().begin();
        int j = 0;
        for (MyEntity preExisting : preExistingList) {
            createOrReuse(preExisting, Integer.MAX_VALUE - j++);
        }
        for (int i = 0; i < VOLUME - preExistingList.size() ; i++) {
            createOrReuse(null, i);
        }
        em.getTransaction().commit();
        em.clear();

        for (int t = 1; t < TIMES; t++) {
            em.getTransaction().begin();
            for (int i = VOLUME * t - preExistingList.size(); i < VOLUME * (t + 1) - preExistingList.size(); i++) {
                createOrReuse(null, i);
            }
            em.getTransaction().commit();
            em.clear();
        }

        EntityThatContains c = new EntityThatContains(preExistingList.get(0), "etcA", "etcB");
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.getTransaction().begin();
        em.getTransaction().commit();

        System.out.println("ME: " + em.createQuery("SELECT me From MyEntity me").getResultList().size());
        System.out.println("ETC: " + em.createQuery("SELECT etc From EntityThatContains etc").getResultList().size());
    }

    private MyEntity generatePreExisting(String id) {
        em.getTransaction().begin();
        MyEntity preExisting = new MyEntity(id);
        preExisting.setEntityFieldA("preExistingA_" + id);
        preExisting.setEntityFieldB("preExistingB_" + id);
        em.persist(preExisting);
        em.getTransaction().commit();

        return preExisting;
    }

    private void createOrReuse(MyEntity preExisting, int i) {
        MyEntity e = preExisting == null ? new MyEntity("New" + i) : preExisting;
        e.setEntityFieldA("a" + i);
        e.setEntityFieldB("b" + i);
        em.merge(e);

        em.flush();
    }

}
