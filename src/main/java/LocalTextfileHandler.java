import java.io.*;
import java.util.Arrays;
import java.util.Properties;

public class LocalTextfileHandler {

    CommandHandler cmd = new CommandHandler();

    public void newServer(TempDB tempdb){
        try {
            File f = new File(tempdb.getHost() + ".txt");
            BufferedWriter out = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(f), "UTF-8"));
            out.write("ip=" + tempdb.getIp());
            out.newLine();
            out.write("port=" + tempdb.getPort());
            out.newLine();
            out.write("user=" + tempdb.getUser());
            out.newLine();
            out.write("password=" + tempdb.getPassword());
            out.close();
        } catch (IOException e) {
            System.out.println("https://stackoverflow.com/search?q=[java]" + e.getMessage());
        }
    }
}