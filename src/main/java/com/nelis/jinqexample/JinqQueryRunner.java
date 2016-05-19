package com.nelis.jinqexample;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jinq.jpa.JinqJPAStreamProvider;

public class JinqQueryRunner {
  public void runQueries() {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("usingjinq");
    EntityManager entityManager = factory.createEntityManager();
    JinqJPAStreamProvider streams = new JinqJPAStreamProvider(factory);

    // List<String> firstNames = streams.streamAll(entityManager, Address.class)
    // .select(c -> c.getNum(), c -> c.getAddr())
    // .collect(toList());
  }
}
