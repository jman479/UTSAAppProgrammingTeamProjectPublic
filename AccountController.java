package sample;

/**
 * AccountController is the backbone of the Registration page and will be used to allow
 * a new user to input all the necessary information to create a new account. If the user
 * fills out all the fields, then their information will be stored in the corresponding
 * csv's and the user will be directed to the new field screen. But, if the user did
 * not fill out all the fields, they will be prompted to do so and then press the button again.
 * This page also includes an exit button if the user wants to close the program at any time
 *
 * Author: Michael Ginsberg (sfi208)
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AccountController
{
    @FXML
    private Button cAccountB;
    @FXML
    private Button exitB;
    @FXML
    private TextField fNameTF;
    @FXML
    private TextField lNameTF;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField usernameTF;
    @FXML
    private PasswordField passphrasePF;
    @FXML
    private PasswordField cPassphrasePF;
    @FXML
    private Label messageLabel;

    /**
     * createAccountButtonAction - Takes in the users mouse click and will check if all
     * text fields are filled in. If they are then the program will call another
     * function to store all the users information, but if the fields are not filled in
     * then the program will prompt the user to fill in the missing fields
     * @param event - mouse click
     */
    public void createAccountButtonAction(ActionEvent event)
    {
        if (!fNameTF.getText().isBlank() && !lNameTF.getText().isBlank() && !emailTF.getText().isBlank() && !usernameTF.getText().isBlank() && !passphrasePF.getText().isBlank() && !cPassphrasePF.getText().isBlank())
        {
            inputUser();
        }
        else
        {
            messageLabel.setText("Please fill out all fields, then try again");
        }
    }

    /**
     * exitButtonAction will cause the window to close if the user
     * presses the exit button
     * @param event - mouse click
     */
    public void exitButtonAction(ActionEvent event)
    {
        Stage stage = (Stage) exitB.getScene().getWindow();
        stage.close();
    }

    /**
     * inputUser is called by createAccountButtonAction() and will be used to
     * store all of the users information into various csv's to be used in
     * different portions of the application later on. Also once all the information
     * is stored, the fucntion will send the new user to the new field screen so
     * they may continue their account creation.
     */
    public void inputUser()
    {
        createFieldPage();
        Stage stage = (Stage) cAccountB.getScene().getWindow();
        stage.close();
        // need to add code to input user info into csv
    }

    public void createFieldPage()
    {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("newField.fxml"));
            Stage newField = new Stage();
            newField.setTitle("Plants for Life");
            newField.setScene(new Scene(root, 600, 400));
            newField.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}
