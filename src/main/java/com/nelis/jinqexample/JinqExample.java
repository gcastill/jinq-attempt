package com.nelis.jinqexample;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JinqExample {

  public static void main(String[] args) throws Exception {

    AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:config/spring/spring-beans.xml");

    // database initializer is done in spring as a init-method

    // address store implementation uses Jinq
    AddressStore store = ctx.getBean("addressStore", AddressStore.class);

    // Run some queries on the database
    AddressQueryRunner queryRunner = new AddressQueryRunner();

    queryRunner.runQueries(store);

    ctx.close();
  }
}
