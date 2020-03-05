package org.geospatial.app;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    
    Connection c = null;
    
   public DB() {
       
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:SqliteJavaDB.db");
        }
        catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("database successfully created");
   }
    
}
