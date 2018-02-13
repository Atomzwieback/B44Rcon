package BusinessLogic;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class CommandHandler {

    TempDB tempdb = new TempDB();

    public void setTempdb(TempDB tempdb) {
        this.tempdb = tempdb;
    }

    public void commandExecutor() {
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(tempdb.getUser(), tempdb.getIp(), tempdb.getPort());
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.setPassword(tempdb.getPassword());
            session.connect();

            Channel channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(tempdb.getCommand());
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);

            InputStream input = channel.getInputStream();
            channel.connect();

            System.out.println("Channel Connected to machine " + tempdb.getIp() + " server with command: " + tempdb.getCommand());

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