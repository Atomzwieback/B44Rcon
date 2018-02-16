package Midend.Commands;
import Midend.Handler.LocalTextfileHandler;
import Midend.Handler.SSHCommandHandler;

public class InstallCommand {

    public void now(){

        LocalTextfileHandler localTextfileHandler = new LocalTextfileHandler();

         final String WGET_SERVER = ("wget https://storage.googleapis.com/battalion_public/BattalionLinuxServer_11126.zip");
         final String INSTALL_UNZIP = ("apt install unzip");
         final String UNZIP_SERVER = ("unzip BattalionLinuxServer_11126.zip");
         final String MOVE_SERVER = ("mv LinuxServer BattalionServer");
         final String REMOVE_SERVER_ZIP = ("rm BattalionLinuxServer_11126.zip");
         final String CHMOD_SERVER = ("chmod -r 700 BattalionServer");
         final String START_SERVER = ("echo \"./Battalion/Binaries/Linux/BattalionServer /Game/Maps/Final_Maps/Derailed?Game=/Script/ShooterGame.BombGameMode?listen -broadcastip=\"" + localTextfileHandler.loadConfig().getProperty("ip") + "\" PORT=7777 -QueryPort=7780 -log -defgameini=\"../../../DefaultGame.ini\"" );

        SSHCommandHandler sshCommandHandler = new SSHCommandHandler();

        sshCommandHandler.commandExecutor(WGET_SERVER);

    }





}
