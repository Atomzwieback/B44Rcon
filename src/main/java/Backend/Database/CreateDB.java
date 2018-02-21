package Backend.Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateDB {

    public static void createDB() {

        Connection c = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:B44Rcon.db");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + " " + e.getMessage());
            System.exit(0);
        }

        System.out.println("db sucessfully created");
    }
}
