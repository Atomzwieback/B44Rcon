package Midend.Handler;

import Backend.TempDB;

import java.io.*;
import java.util.Properties;

public class LocalTextfileHandler {

    public Properties saveConfig(TempDB tempDB) {

        File file = new File("default.properties");
        if (file.exists()) {
            file.delete();
        } else {
            System.out.println("properties not exist");
        }

        Properties prop = new Properties();
        OutputStream output = null;

        try {

            output = new FileOutputStream(tempDB.getHost() + ".properties");

            // set the properties value
            prop.setProperty("ip", tempDB.getIp());
            prop.setProperty("port", Integer.toString(tempDB.getPort()));
            prop.setProperty("user", tempDB.getUser());
            prop.setProperty("password", tempDB.getPassword());

            // save properties to project root folder
            prop.store(output, null);
            output.close();

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    System.out.println("https://stackoverflow.com/search?q=[java]" + e.getMessage());
                }
            }

        }
        return prop;
    }




    public Properties loadConfig() {

        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream( "default.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out

//            tempDB.setUser(prop.getProperty("user"));
//            tempDB.setPort(Integer.parseInt(prop.getProperty("port")));
//            tempDB.setPassword(prop.getProperty("password"));
//            tempDB.setIp(prop.getProperty("ip"));
//            tempDB.setTempDB(tempDB);


        } catch (IOException ex) {
            System.out.println("default.properties does not exist. Please save your settings at least once.");
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return prop;
    }



}
