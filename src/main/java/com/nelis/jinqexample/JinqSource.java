package com.nelis.jinqexample;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.jinq.jpa.JPAJinqStream;
import org.jinq.jpa.JinqJPAStreamProvider;

public class JinqSource {
  private JinqJPAStreamProvider streams;

  @PersistenceUnit
  public void setEntityManagerFactory(EntityManagerFactory emf) throws Exception {
    streams = new JinqJPAStreamProvider(emf);
    // Do any additional Jinq initialization needed here.
  }

  // Wrapper that passes through Jinq requests to Jinq
  public <T> JPAJinqStream<T> streamAll(EntityManager em, Class<T> entity) {
    return streams.streamAll(em, entity);
  }

  // You can include helper methods here too
  public JPAJinqStream<Address> addresses(EntityManager em) {
    return streams.streamAll(em, Address.class);
  }
}
