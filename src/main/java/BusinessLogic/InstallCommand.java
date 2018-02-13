package BusinessLogic;

public class InstallCommand {


    public static void execute(TempDB tempDB) {
        for (Commands commands : Commands.values()) {
            //TODO add some function
            if(commands == Commands.START_SERVER) {
                commands.getCommand(tempDB.getIp());
            }
        }
    }

    private enum Commands {

        WGET_SERVER("wget https://storage.googleapis.com/battalion_public/BattalionLinuxServer_11126.zip"),
        INSTALL_UNZIP("apt install unzip"),
        UNZIP_SERVER("unzip BattalionLinuxServer_11126.zip"),
        MOVE_SERVER("mv LinuxServer BattalionServer"),
        REMOVE_SERVER_ZIP("rm BattalionLinuxServer_11126.zip"),
        CHMOD_SERVER("chmod -r 700 BattalionServer"),
        START_SERVER("echo \"./Battalion/Binaries/Linux/BattalionServer /Game/Maps/Final_Maps/Derailed?Game=/Script/ShooterGame.BombGameMode?listen -broadcastip=\"%s \" -PORT=7777 -QueryPort=7780 -log -defgameini=\"../../../DefaultGame.ini\"" );


        private final String command;

        Commands(final String command) {
            this.command = command;
        }

        public String getCommand(String... formattings) {
            return String.format(command, formattings);
        }
    }
}
