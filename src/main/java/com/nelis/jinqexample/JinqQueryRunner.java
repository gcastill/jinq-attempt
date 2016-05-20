package com.nelis.jinqexample;

import static java.util.stream.Collectors.toList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jinq.jpa.JinqJPAStreamProvider;

public class JinqQueryRunner {
  public void runQueries() {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("derby");
    EntityManager entityManager = factory.createEntityManager();
    JinqJPAStreamProvider streams = new JinqJPAStreamProvider(factory);

    System.out.println(streams.streamAll(entityManager, Address.class).count());
    System.out.println(streams.streamAll(entityManager, Address.class).collect(toList()));

  }
}
