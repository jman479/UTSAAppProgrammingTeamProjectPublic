package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;

public class newFieldController
{
    @FXML
    private Button createFieldB;
    @FXML
    private Button exitB;
    @FXML
    private TextField fieldNameTF;
    @FXML
    private TextField locationTF;
    @FXML
    private TextField dateTF;
    @FXML
    private Label messageLabel;

    public newFieldController (String filename)
    {
        String filenameU = filename;
    }

    /**
     * createFieldButtonAction - Takes in the users mouse click and will check if all
     * text fields are filled in. If they are then the program will call another
     * function to store all the users information, but if the fields are not filled in
     * then the program will prompt the user to fill in the missing fields
     * @param event - mouse click
     */
    public void createFieldButtonAction(ActionEvent event) throws IOException {
        if (!fieldNameTF.getText().isBlank() && !locationTF.getText().isBlank() && !dateTF.getText().isBlank())
        {
            inputField();
        }
        else
        {
            messageLabel.setText("Please fill out all fields, then try again");
        }
    }

    /**
     * exitButtonAction will cause the window to close if the user
     * presses the exit button.
     * @param event - mouse click
     */
    public void exitButtonAction(ActionEvent event)
    {
        Stage stage = (Stage) exitB.getScene().getWindow();
        stage.close();
    }

    public void inputField() throws IOException {
        String filenameU = "";

        FileWriter fieldWriter = new FileWriter(filenameU, true);
        fieldWriter.append("\n");
        fieldWriter.append(fieldNameTF.getText());
        fieldWriter.append(",");
        fieldWriter.append(locationTF.getText());
        fieldWriter.append(",");
        fieldWriter.append(dateTF.getText());
        fieldWriter.flush();
        fieldWriter.close();

        fieldOverviewPage();
        Stage stage = (Stage) createFieldB.getScene().getWindow();
        stage.close();
    }

    /**
     * fieldOverviewPage function will create a new stage and link the fxml
     * to the fieldOverview.fxml. It will also open the new stage in a new window.
     */
    public void fieldOverviewPage()
    {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("fieldOverview.fxml"));
            Stage overview = new Stage();
            overview.setTitle("Plants for Life");
            overview.setScene(new Scene(root, 600, 400));
            overview.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}
