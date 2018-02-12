import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesHandler {

    public Properties newConfig(TempDB tempdb) {

        Properties prop = new Properties();
        OutputStream output = null;

        try {

            output = new FileOutputStream(tempdb.getHost() + ".properties");

            // set the properties value
            prop.setProperty("ip", tempdb.getIp());
            prop.setProperty("port", Integer.toString(tempdb.getPort()));
            prop.setProperty("user", tempdb.getUser());
            prop.setProperty("password", tempdb.getPassword());

            // save properties to project root folder
            prop.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return prop;
    }
}
