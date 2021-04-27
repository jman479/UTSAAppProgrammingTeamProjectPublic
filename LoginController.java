package sample;

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
     * @param event - takes in the button press
     */
    public void exitButtonAction(ActionEvent event)
    {
        Stage stage = (Stage) exitB.getScene().getWindow();
        stage.close();
    }

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
