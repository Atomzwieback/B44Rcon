import BusinessLogic.LocalTextfileHandler;
import BusinessLogic.RandomString;
import BusinessLogic.TempDB;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import static org.junit.Assert.*;

public final class PropertiesHandlerTest {

    private static final RandomString RANDOM_STRING = new RandomString();

    @Test
    public void successfullyCreateProperties() throws IOException {
        final TempDB tempDB = new TempDB();
        tempDB.setHost(RANDOM_STRING.nextString());
        tempDB.setPassword(RANDOM_STRING.nextString());
        tempDB.setUser(RANDOM_STRING.nextString());
        tempDB.setIp(RANDOM_STRING.nextString());
        tempDB.setPort(50);
        assertNotNull(tempDB);

        final LocalTextfileHandler propertiesHandler = new LocalTextfileHandler();
        final Properties properties = propertiesHandler.newConfig(tempDB);

        assertNotNull(properties);

        properties.load(new FileInputStream(tempDB.getHost() + ".properties"));


        String ip = properties.getProperty("ip");

        assertEquals(ip, tempDB.getIp());

        Files.delete(Paths.get(tempDB.getHost() + ".properties"));
    }

}