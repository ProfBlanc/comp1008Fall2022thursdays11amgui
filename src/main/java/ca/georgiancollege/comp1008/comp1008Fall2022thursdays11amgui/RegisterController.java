package ca.georgiancollege.comp1008.comp1008Fall2022thursdays11amgui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class RegisterController {

    @FXML
    private Label errorMsg;

    @FXML
    private TextField registrationUsername;

    @FXML
    private PasswordField registrationPassword;

    @FXML
    private PasswordField confirmPassword;

    RegisterModel model = new RegisterModel();

    private void clearAllValues(){
        registrationPassword.setText("");
        registrationUsername.clear();
        confirmPassword.clear();
    }
    @FXML
    void onClear(ActionEvent event) {

        clearAllValues();
    }

    @FXML
    void onRegister(ActionEvent event) {

        errorMsg.setText("");
        try{
            model.process(registrationUsername.getText(),
                    registrationPassword.getText(),
                    confirmPassword.getText());
            Utlities.createAlert(Alert.AlertType.INFORMATION, "Success",
                    "Succesfully Registered").show();

            clearAllValues();
        }
        catch (Exception e){
            errorMsg.setText(e.getMessage());
        }

    }
    @FXML
    void initialize(){
        errorMsg.setText("");
    }

}
