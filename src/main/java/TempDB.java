public class TempDB {

    private String command, ip, user, password, host;
    private int port;

    // SETTER
    public void setCommand(String choosenCommand) {
        this.command = choosenCommand;
    }

    public void setIp(String choosenIp) {
        this.ip = choosenIp;
    }

    public void setUser(String choosenUser) {
        this.user = choosenUser;
    }

    public void setPassword(String choosenPassword) {
        this.password = choosenPassword;
    }

    public void setHost(String choosenHost) {
        this.host = choosenHost;
    }

    public void setPort(int choosenPort) {
        this.port = choosenPort;
    }

    // GETTER


    public String getCommand() {
        return this.command;
    }

    public String getIp() {
        return this.ip;
    }

    public String getUser() {
        return this.user;
    }

    public String getPassword() {
        return this.password;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

}
