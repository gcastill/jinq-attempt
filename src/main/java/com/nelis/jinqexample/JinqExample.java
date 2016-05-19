package com.nelis.jinqexample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JinqExample {

  public static void main(String[] args) throws Exception {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:config/spring/spring-beans.xml");

    // Create our embedded database
    DatabaseInitializer dbInitializer = new DatabaseInitializer();
    dbInitializer.initializeDatabase();

    // Run some jinq queries on the database
    JinqQueryRunner queryRunner = new JinqQueryRunner();
    queryRunner.runQueries();
  }
}
