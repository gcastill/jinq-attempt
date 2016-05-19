package com.nelis.jinqexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Properties;


public class DatabaseInitializer
{
  private static final String FRAMEWORK = "embedded";
  private static final String PROTOCOL = "jdbc:derby:";


  public void initializeDatabase()
    throws Exception
  {
    Connection conn = null;
    PreparedStatement psInsert = null;
    Statement s = null;

    try
    {
      // Set up database connection properties
      Properties props = new Properties();
      props.put("user", "user1");
      props.put("password", "user1");

      String dbName = "derbyDB"; // the name of the database

      // Set up database connection
      conn = DriverManager.getConnection(PROTOCOL + dbName + ";create=true", props);
      System.out.println("Connected to and created database " + dbName);
      conn.setAutoCommit(false);

      // Create a table
      s = conn.createStatement();
      s.execute("create table location(num int, addr varchar(40))");
      System.out.println("Created table location");

      // Add some records
      psInsert = conn.prepareStatement("insert into location values (?, ?)");

      psInsert.setInt(1, 1956);
      psInsert.setString(2, "Webster St.");
      psInsert.executeUpdate();
      System.out.println("Inserted 1956 Webster");

      psInsert.setInt(1, 1910);
      psInsert.setString(2, "Union St.");
      psInsert.executeUpdate();
      System.out.println("Inserted 1910 Union");

      // Shut down the database
      if (FRAMEWORK.equals("embedded"))
      {
         try
         {
            // the shutdown=true attribute shuts down Derby
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
          }
          catch (SQLException se)
          {
            if (( (se.getErrorCode() == 50000) && ("XJ015".equals(se.getSQLState()) )))
            {
                // We got the expected exception
                System.out.println("Derby shut down normally");
            }
            else
            {
                // If the error code or SQLState is different, we have
                // an unexpected exception (shutdown failed)
                System.err.println("Derby did not shut down normally");
                printSQLException(se);
            }
         }
      }
    }
    catch (SQLException sqle)
    {
      printSQLException(sqle);
    }
    finally
    {
      // Close the statements
      try
      {
        if (s != null)
        {
          s.close();
          s = null;
        }
        if (psInsert != null)
        {
          psInsert.close();
          psInsert = null;
        }
      }
      catch (SQLException sqle)
      {
        printSQLException(sqle);
      }

      //Connection
      try
      {
        if (conn != null)
        {
          conn.close();
          conn = null;
        }
      }
      catch (SQLException sqle)
      {
        printSQLException(sqle);
      }
    }
  }


  /**
   * Print out the details of an SQLException
   *
   * @param e The SQLException for which to print details.
   */
  public static void printSQLException(SQLException e)
  {
      // Unwraps the entire exception chain to unveil the real cause of the
      // Exception.
      while (e != null)
      {
          System.err.println("\n----- SQLException -----");
          System.err.println("  SQL State:  " + e.getSQLState());
          System.err.println("  Error Code: " + e.getErrorCode());
          System.err.println("  Message:    " + e.getMessage());
          e = e.getNextException();
      }
  }
}
