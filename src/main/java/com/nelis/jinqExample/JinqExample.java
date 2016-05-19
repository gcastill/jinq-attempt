package com.nelis.jinqExample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class JinqExample
{
  public static void main(String[] args)
    throws Exception
  {
    // Initialize spring
    String config[] = { "spring-beans.xml" };
    ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

    // Create our embedded database
    DatabaseInitializer dbInitializer = new DatabaseInitializer();
    dbInitializer.initializeDatabase();

    // Run some jinq queries on the database
    JinqQueryRunner queryRunner = new JinqQueryRunner();
    queryRunner.runQueries();
  }
}
