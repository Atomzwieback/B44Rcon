package Frontend;

import Midend.Handler.LocalTextfileHandler;
import Midend.Handler.SSHCommandHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("B44RconUI.fxml")));
        primaryStage.setTitle("B44 Rcon");
        primaryStage.getIcons().add(new Image("file:B44RconIcon.png"));
        primaryStage.setScene(new Scene(root, 205, 646));
        primaryStage.setResizable(false);
        primaryStage.show();


        SSHCommandHandler sshCommandHandler = new SSHCommandHandler();

//        sshCommandHandler.commandExecutor();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
