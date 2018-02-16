package Midend.Handler;

import Backend.TempDB;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class SSHCommandHandler {


    public void commandExecutor(String command) {
        try {
            JSch jsch = new JSch();
            LocalTextfileHandler localTextfileHandler = new LocalTextfileHandler();
            Session session = jsch.getSession(
                    localTextfileHandler.loadConfig().getProperty("user"),
                    localTextfileHandler.loadConfig().getProperty("ip"),
                    Integer.parseInt(localTextfileHandler.loadConfig().getProperty("port")));
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.setPassword(localTextfileHandler.loadConfig().getProperty("password"));
            session.connect();

            Channel channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(command);
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);

            InputStream input = channel.getInputStream();
            channel.connect();

            System.out.println("Channel Connected to machine " + localTextfileHandler.loadConfig().getProperty("ip") + " server with command: " + command);

            try {
                InputStreamReader inputReader = new InputStreamReader(input);
                BufferedReader bufferedReader = new BufferedReader(inputReader);
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
                bufferedReader.close();
                inputReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            channel.disconnect();
            session.disconnect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}