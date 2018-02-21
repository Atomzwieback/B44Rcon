package Backend.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class WriteDB {

    public static void writeDB() {

        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:B44Rcon.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO USERDATA (IP,PORT,USERNAME,PASSWORD) " +
                    "VALUES ('8.8.8.8', 22, 'root', 'test123' );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO USERDATA (IP,PORT,USERNAME,PASSWORD) " +
                    "VALUES ('8.8.8.8', 22, 'root', 'test123' );";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }
}

