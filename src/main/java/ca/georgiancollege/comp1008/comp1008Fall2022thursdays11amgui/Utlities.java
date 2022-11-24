package ca.georgiancollege.comp1008.comp1008Fall2022thursdays11amgui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Utlities {
/*
Create a new fxml file named
register-view.fxml

When user successfully logins in,
use the Utilities method of openPage
to open the regristration page
 */

    static void openPage(String fileName, String title) throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fileName + "-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();


    }
    static Alert createAlert(Alert.AlertType alertType,
                             String title,
                             String message
                            ){

        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        return alert;
    }
}
