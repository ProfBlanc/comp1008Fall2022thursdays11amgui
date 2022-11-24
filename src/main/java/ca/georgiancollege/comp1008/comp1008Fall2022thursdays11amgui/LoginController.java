package ca.georgiancollege.comp1008.comp1008Fall2022thursdays11amgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    //accessibility_level data_type name;
    //@FXML annotation

    @FXML
    private Label errorMsg;

    @FXML
    private TextField textUsername;

    @FXML
    private PasswordField textPassword;

    @FXML
    void onLoginClick(ActionEvent event) {

        System.out.println("Login Clicked");

        errorMsg.setText("");

        String expectedUsername = "admin",
                expectedPassword = "pass";

        String receivedUsername = textUsername.getText(),
                receivedPassword = textPassword.getText();

        if(receivedPassword.equals(expectedPassword)
        &&
        receivedUsername.equals(expectedUsername)){

            System.out.println("Congrats!");


//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Congrats");
//            alert.setContentText("You may enter");
//            alert.show();
            Utlities.createAlert(Alert.AlertType.INFORMATION,
                    "Congrats",
                    "You may enter").show();

            try {
                Utlities.openPage("register",
                        "Registration Page");
            }
            catch (Exception e){
                errorMsg.setText("Could not load " +
                        "registration page");
            }

        }
        else{
            System.out.println("Incorrect Username and/or Password");
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error");
//            alert.setContentText("Incorrect Username and/or Password");
//            alert.show();
//            Utlities.createAlert(Alert.AlertType.ERROR,
//                    "Error","Incorrect Username and/or Password"
//                    ).show();
            errorMsg.setText("Incorrect Username and/or Password");
        }

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


        errorMsg.setText("");
    }

}
