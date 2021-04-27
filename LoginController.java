package sample;

/**
 * LoginController is the backbone of the login page and will be used to either
 * validate login credentials and advance the user to their field or the page
 * will be used to direct new users to the create an account page. The page also
 * features a button to allow the user to exit the application at any time.
 *
 * Author: Michael Ginsberg (sfi208)
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class LoginController
{
    @FXML
    private Button exitB;
    @FXML
    private Button loginB;
    @FXML
    private Label messageText;
    @FXML
    private TextField usernameTF;
    @FXML
    private PasswordField passphrasePF;

    /**
     * loginButtonAction - Takes in the users mouse click and will check if all
     * text fields are filled in. If they are then the program will call another
     * function to validate the login request, but if both fields are not filled in
     * then the program will prompt the user to fill in the missing fields
     * @param event - mouse click
     */
    public void loginButtonAction(ActionEvent event)
    {
        if (!usernameTF.getText().isBlank() && !passphrasePF.getText().isBlank())
        {
            validateLogin();
        }
        else
        {
            messageText.setText("Please enter username and passphrase");
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
     * validateLogin is called by loginButtonAction() to check the users
     * credentials against all known users in the user_accounts csv. The
     * function will do checks on both the username and passphrase and if they
     * are both correct, will send the user to their overview page. If the user enters
     * a wrong username or passphrase the function will prompt the user to try again
     */
    public void validateLogin()
    {
        int i;
        boolean isUser = false;
        String[] users = new String[10];
        users[0] = "sfi208";
        users[1] = "Password1";

        /*String line = "";
        String filename = "user_accounts.csv";


        try{
            BufferedReader br = new BufferedReader(new FileReader(filename));

            while ((line = br.readLine()) != null)
            {
                String[] accounts = line.split(",");
                System.out.println("ID Number: " + accounts[0] + "Username: " + accounts[1] + "Passphrase: " + accounts[2]);

                if (usernameTF.getText().equals(accounts[1]))
                {
                    isUser = true;
                    if (passphrasePF.getText().equals((accounts[2])))
                    {
                        messageText.setText("Login Successful");
                    }
                    else
                    {
                        messageText.setText("Incorrect Passphrase");
                    }
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        for (i = 0; i <= users.length; i++)
        {

            if (usernameTF.getText().equals(users[i]))
            {
                isUser = true;
                if (passphrasePF.getText().equals(users[i + 1]))
                {
                    messageText.setText("Login Successful");
                }
                else
                {
                    messageText.setText("Incorrect Username or Passphrase");
                }
            }
        }
        if (isUser == true)
        {
            messageText.setText("Incorrect Username or Passphrase");
        }
    }
}
