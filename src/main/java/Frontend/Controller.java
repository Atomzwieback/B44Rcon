package Frontend;

import Midend.Handler.AlertHandler;
import Midend.Handler.LocalTextfileHandler;
import Backend.TempDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    public TextField ipUI;

    @FXML
    public TextField portUI;

    @FXML
    public TextField userUI;

    @FXML
    public PasswordField passwordUI;

    @FXML
    public Button setUI;

    @FXML
    public Button installUI;

    @FXML
    public Button startUI;

    @FXML
    public Button stopUI;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        LocalTextfileHandler localTextfileHandler = new LocalTextfileHandler();
        TempDB tempDB = new TempDB();

        tempDB.setIp("0.0.0.0");
        tempDB.setPort(22);
        tempDB.setUser("exampleUser");
        tempDB.setPassword("test123");
        localTextfileHandler.saveConfig(tempDB);

        try {


            ipUI.setText(localTextfileHandler.loadConfig().getProperty("ip"));
            portUI.setText(localTextfileHandler.loadConfig().getProperty("port"));
            userUI.setText(localTextfileHandler.loadConfig().getProperty("user"));
            passwordUI.setText(localTextfileHandler.loadConfig().getProperty("password"));
        } catch (Exception e) {
            System.out.println("Cannot set last config");
        }


    }

    @FXML
    protected void handleSetButtonAction(ActionEvent event) {
        Window owner = setUI.getScene().getWindow();
        if (ipUI.getText().isEmpty()) {
            AlertHandler.showAlert(Alert.AlertType.ERROR, owner, "IP Form Error!",
                    "Please enter your server ip");
            return;
        }
        if (portUI.getText().isEmpty()) {
            AlertHandler.showAlert(Alert.AlertType.ERROR, owner, "Port Empty Form Error!",
                    "Please enter your port");
            return;
        }
        if (!isNumber(portUI.getText())) {
            AlertHandler.showAlert(Alert.AlertType.ERROR, owner, "Port Number Form Error",
                    "Port must be a number");
            return;
        }
        if (userUI.getText().isEmpty()) {
            AlertHandler.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your server user");
            return;
        }
        if (passwordUI.getText().isEmpty()) {
            AlertHandler.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter a your server user password");
            return;
        }

        TempDB tempDB = new TempDB();
        LocalTextfileHandler localTextfileHandler = new LocalTextfileHandler();

        tempDB.setIp(ipUI.getText());
        tempDB.setPort(Integer.parseInt(portUI.getText()));
        tempDB.setUser(userUI.getText());
        tempDB.setPassword(passwordUI.getText());

        localTextfileHandler.saveConfig(tempDB);
    }




    protected void handleInstallButton(){

    }


    private boolean isNumber(final String text) {
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }
}
