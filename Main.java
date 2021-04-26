/* Main.java
 * Our term project is centered around making an app to help catalog the plants you would like to grow
 * and offer tips on how to take care of such plants.
 * 
 * Members of this group include:
 * Michael Ginsberg - sfi208
 * Aisha Bah - ozg281
 * David Maestas - xzu322
 * Hunter Long - mia014
 * Jasman Sidhu - tqx609
 * UTSA CS 3443.002 - Application Term Project
 * Spring 2021
*/
package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("Plants for Life");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
