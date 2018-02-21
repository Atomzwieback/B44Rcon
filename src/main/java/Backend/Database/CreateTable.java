package Backend.Database;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {

    public static void createTable() {

        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:B44Rcon.db");
            System.out.println("Open database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE USERDATA " +
                    "(ID INTEGER PRIMARY KEY AUTOINCREMENT     NOT NULL," +
                    " IP              TEXT    NOT NULL, " +
                    " PORT            INTEGER     NOT NULL, " +
                    " USERNAME        TEXT    NOT NULL , " +
                    " PASSWORD        TEXT NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
            System.out.println("Creating tables successfully");

        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }




}
