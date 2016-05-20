package com.nelis.jinqexample;

import static java.util.stream.Collectors.toList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jinq.jpa.JPAJinqStream;
import org.jinq.jpa.JinqJPAStreamProvider;

public class JinqAddressStore implements AddressStore {

  private EntityManagerFactory factory;
  private EntityManager entityManager;

  public JinqAddressStore() {
    factory = Persistence.createEntityManagerFactory("derby");
    entityManager = factory.createEntityManager();
  }

  @Override
  public long getCount() {
    return newStream().count();
  }

  @Override
  public List<Address> allAddresses() {
    return newStream().toList();
  }

  @Override
  public List<Address> allAddressesHigherThan(int number) {
    return newStream().filter(address -> address.getNumber() > number).collect(toList());

  }

  private JPAJinqStream<Address> newStream() {
    JinqJPAStreamProvider streams = new JinqJPAStreamProvider(factory);
    return streams.streamAll(entityManager, Address.class);
  }

}
