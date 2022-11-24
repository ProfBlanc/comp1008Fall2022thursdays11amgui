package ca.georgiancollege.comp1008.comp1008Fall2022thursdays11amgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    //accessibility_level data_type name;
    //@FXML annotation

    @FXML
    private TextField textUsername;

    @FXML
    private PasswordField textPassword;

    @FXML
    void onLoginClick(ActionEvent event) {

        System.out.println("Login Clicked");

    }

    @FXML
    void onRegisterClick(ActionEvent event) {

        System.out.println("Register Clicked");
    }

    @FXML
    void initialize(){
        System.out.println("Loaded");
        textUsername.setText("Ben");
        textPassword.setText("Blanc");
        System.out.println(textPassword.getText());
    }

}
