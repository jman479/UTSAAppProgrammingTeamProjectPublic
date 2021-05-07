package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class fieldOverviewController{

    @FXML
    private Label fieldOverviewLabel;

    @FXML
    private Label toDoListLabel;

    @FXML
    private Label currentCropsLabel;

    @FXML
    private ListView<?> toDoListListView;

    @FXML
    private ListView<String> currentCropsListView;

    @FXML
    private Button addButton;

    @FXML
    private Button removeButton;

    @FXML
    private Button viewCropInfoButton;

    @FXML
    private Button logoutButton;

    private final ObservableList<String> currentCrops = FXCollections.observableArrayList();
    private String[] temp;
    private String cropHolder = "";
    private String filenameU = "";

    @FXML
    void addButtonPressed(ActionEvent event) {

        try{
            Parent root = FXMLLoader.load(getClass().getResource("/View/addCrops.fxml"));
            Stage overview = new Stage();
            overview.setTitle("Plants for Life");
            overview.setScene(new Scene(root, 600, 400));
            overview.show();

            Stage stage = (Stage) addButton.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }

    @FXML
    void logoutButtonPressed(ActionEvent event) {

        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.close();

    }

    @FXML
    void removeButtonPressed(ActionEvent event) {

        if( cropHolder.isEmpty() ){
            try {
                Parent popupOneparent = FXMLLoader.load(getClass().getResource("/View/FOpopupFour.fxml"));
                Scene popupOneScene = new Scene(popupOneparent, 600, 600);

                Stage popupOnewindow = (Stage) viewCropInfoButton.getScene().getWindow();

                popupOnewindow.setScene(popupOneScene);
                popupOnewindow.show();
            }

            catch (IOException e) {
                e.printStackTrace();
            }
        }

        //for some reason this is erasing the entire .csv file need to figure out how to get it to remove just the
        //desired crop
        //overwrite to nothing and then append to empty file
        else{
            int i;
            int j = 0;
            String[] temp4 = new String[this.temp.length];
            for(i = 0; i < this.temp.length; i++ ){

                if(!temp[i].equals(cropHolder)){
                    temp4[j] = this.temp[i];
                    j++;
                }
                else if(temp[i].equals(cropHolder)){
                    continue;
                }

            }
            for(i = 0; i < temp4.length; i++ ){
                System.out.println( temp4[i] );
            }

            try{
                //File fold=new File( this.filenameU );
                //fold.delete();
                File fnew=new File( this.filenameU );

                FileWriter f2 = new FileWriter(fnew);

                for(i = 0; i < this.temp.length; i++ ){
                    String temp1 = temp4[i] + ",";
                    f2.write( temp1 );
                }

            }
            catch( IOException e ){
                e.printStackTrace();
            }
        }

    }

    @FXML
    void viewCropInfoButton(ActionEvent event) {

        if( cropHolder.isEmpty() ){
            try {
                Parent popupOneparent = FXMLLoader.load(getClass().getResource("/View/FOpopupThree.fxml"));
                Scene popupOneScene = new Scene(popupOneparent, 600, 600);

                Stage popupOnewindow = (Stage) viewCropInfoButton.getScene().getWindow();

                popupOnewindow.setScene(popupOneScene);
                popupOnewindow.show();
            }

            catch (IOException e) {
                e.printStackTrace();
            }
        }

        else{
            try{
                Parent root = FXMLLoader.load(getClass().getResource("/View/" + cropHolder + "Info.fxml"));
                Stage overview = new Stage();
                overview.setTitle("Plants for Life");
                overview.setScene(new Scene(root, 600, 600));

                overview.show();

            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }

    }

    public void initialize(){

        String filenameU = "";
        String line = "";
        String user = "";

        try{
            BufferedReader br = new BufferedReader(new FileReader( "src/Model/user_accounts.csv" ));

            while ((line = br.readLine()) != null)
            {
                String[] accounts = line.split(",");

                user = accounts[0];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.filenameU = "src/Model/" + user + ".csv";
        System.out.println( filenameU );

        try{

            File file = new File( this.filenameU );
            Scanner scanner = new Scanner( file );
            while( scanner.hasNext() ){
                this.temp = scanner.nextLine().split(",");
            }
            scanner.close();
        }
        catch( FileNotFoundException e){
            e.printStackTrace();
        }

        int i;
        for(i = 3; i < this.temp.length; i++ ){
            currentCrops.add(this.temp[i]);
        }

        currentCropsListView.setItems(currentCrops);

        currentCropsListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cropHolder = currentCropsListView.getSelectionModel().getSelectedItem();
                System.out.println(cropHolder);
            }
        });

    }

}

