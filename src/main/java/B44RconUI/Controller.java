package B44RconUI;

import BusinessLogic.AlertHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;


public class Controller {

    @FXML
    private TextField ipUI;

    @FXML
    private TextField portUI;

    @FXML
    private TextField userUI;

    @FXML
    private PasswordField passwordUI;

    @FXML
    private Button setUI;

    @FXML
    private Button installUI;

    @FXML
    private Button startUI;

    @FXML
    private Button stopUI;

    @FXML
    protected void handleSetButtonAction(ActionEvent event) {
        Window owner = setUI.getScene().getWindow();
        if (ipUI.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "IP Form Error!",
                    "Please enter your server ip");
            return;
        }
        if (portUI.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Port Empty Form Error!",
                    "Please enter your port");
            return;
        }
        if (!isNumber(portUI.getText())) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Port Number Form Error",
                    "Port must be a number");
            return;
        }
        if (userUI.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your server user");
            return;
        }
        if (passwordUI.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter a your server user password");
            return;
        }
    }

//    tempdb
//
//    protected void saveData(){
//
//        tempDB
//
//    }

    private boolean isNumber(final String text) {
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }
}
