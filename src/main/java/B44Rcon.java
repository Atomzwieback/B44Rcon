import java.util.Scanner;


public class B44Rcon {

    public static void main(String[] args){

        TempDB tempdb = new TempDB();
        CommandHandler cmd = new CommandHandler();

        System.out.println("______    ___    ___         ______                     ");
        System.out.println("| ___ \\  /   |  /   |        | ___ \\                    ");
        System.out.println("| |_/ / / /| | / /| | ______ | |_/ /  ___   ___   _ __  ");
        System.out.println("| ___ \\/ /_| |/ /_| ||______||    /  / __| / _ \\ | '_ \\ ");
        System.out.println("| |_/ /\\___  |\\___  |        | |\\ \\ | (__ | (_) || | | |");
        System.out.println("\\____/     |_/    |_/        \\_| \\_| \\___| \\___/ |_| |_|");
        System.out.println("            Version 0.1 Alpha \u00a9 Atomzwieback");

        System.out.println();
        System.out.println("1. Add new host");
        System.out.println("2. Install server");
        System.out.println("3. Start server");
        System.out.println("4. Stop server");
        System.out.println();
        System.out.println("Please choose what u want to do (1-4):");


        Scanner cscanner = new Scanner(System.in);
        CommandHandler cmdh = new CommandHandler();
        LocalTextfileHandler newHost = new LocalTextfileHandler();
        PropertiesHandler newHost2 = new PropertiesHandler();
        int choice = cscanner.nextInt();

        switch (choice){
            case 1:
                System.out.println("Please provide the following infos.");
                System.out.println();
                System.out.println("Hostname:");
                tempdb.setHost(cscanner.next());
                System.out.println("IP:");
                tempdb.setIp(cscanner.next());
                System.out.println("Port:");
                tempdb.setPort(cscanner.nextInt());
                System.out.println("User:");
                tempdb.setUser(cscanner.next());
                System.out.println("Passwort:");
                tempdb.setPassword(cscanner.next());
                cmd.setTempdb(tempdb);
                newHost2.newConfig(tempdb);
//                newHost.newServer(tempdb);
                break;
            case 2:
                System.out.println("Pleas provide the following infos (IP, Port, User, Password):");
                tempdb.setCommand("./install.sh");
                tempdb.setHost(cscanner.next());
                tempdb.setPort(cscanner.nextInt());
                tempdb.setUser(cscanner.next());
                tempdb.setPassword(cscanner.next());
                cmd.setTempdb(tempdb);
                cmdh.commandExecutor();
                break;
            case 3:
                System.out.println("Pleas provide the following infos (IP, Port, User, Password):");
                tempdb.setCommand("./start.sh");
                tempdb.setHost(cscanner.next());
                tempdb.setPort(cscanner.nextInt());
                tempdb.setUser(cscanner.next());
                tempdb.setPassword(cscanner.next());
                cmd.setTempdb(tempdb);
                cmdh.commandExecutor();
                break;
            case 4:
                System.out.println("Pleas provide the following infos (IP, Port, User, Password):");
                tempdb.setCommand("./stop.sh");
                tempdb.setHost(cscanner.next());
                tempdb.setPort(cscanner.nextInt());
                tempdb.setUser(cscanner.next());
                tempdb.setPassword(cscanner.next());
                cmd.setTempdb(tempdb);
                cmdh.commandExecutor();

                break;
            default:
                System.out.println("Out of option range pls choose between 1-3");
        }

    }
}
