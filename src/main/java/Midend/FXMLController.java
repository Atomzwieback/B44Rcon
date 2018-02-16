package Midend;

import Frontend.Controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLController implements Initializable {

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
        ipUI.setText("8.8.8.8");
    }



}

