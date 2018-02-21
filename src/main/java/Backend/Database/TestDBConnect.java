package Backend.Database;

public class TestDBConnect {

    public static void main(String[] args) {
        CreateDB.createDB();
        CreateTable.createTable();
        WriteDB.writeDB();
    }
}
