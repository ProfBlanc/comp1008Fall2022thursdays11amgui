package ca.georgiancollege.comp1008.comp1008Fall2022thursdays11amgui;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.nio.file.Path;

public class WelcomeController {


    @FXML
    private AnchorPane background;

    @FXML
    private ImageView imageWorldCup;

    @FXML
    private ImageView imageBorderPane;

    @FXML
    private ImageView imageUltimate;

    @FXML
    private Label message, welcome;

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    EventHandler<MouseEvent> onImageClick = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            ImageView clickedImage = (ImageView) event.getSource();

            String fullPath = clickedImage.getImage().getUrl();

//            message.setText("You clicked on an image");

            //message.setText(fullPath);
            //System.out.println(fullPath);

            //only get the fileName
            String[] pieces = fullPath.split("/");
            String fileName = pieces[pieces.length - 1];
//            System.out.println(fileName);
            String justName = fileName.split("\\.")[0];
//            System.out.println(justName);

            try{
                Utlities.openPage(justName, justName.toUpperCase());
                message.setText("Succesfully opened view " + justName);
            }
            catch (Exception e){
                message.setText("Could not open view " + justName);
            }

        }
    };

    EventHandler<MouseEvent> onMouseMove = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            message.setText( (int)event.getSceneX() + "," + (int)event.getSceneY());
        }
    };

    @FXML
    void initialize(){
        message.setText("");

        imageWorldCup.setOnMouseClicked(onImageClick);
        imageBorderPane.setOnMouseClicked(onImageClick);
        imageUltimate.setOnMouseClicked(onImageClick);

        background.setOnMouseMoved(onMouseMove);

        welcome.setText("Welcome "+ getUsername());



    }

}
