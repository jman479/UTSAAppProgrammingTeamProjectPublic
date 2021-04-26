package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController
{
    @FXML
    private Button exitB;
    @FXML
    private Button loginB;
    @FXML
    private Label messageLabel;
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
            messageLabel.setText("Please enter username and passphrase");
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

        for (i = 0; i <= users.length; i++)
        {
            if (usernameTF.getText().equals(users[i]))
            {
                isUser = true;
                if (passphrasePF.getText().equals(users[i + 1]))
                {
                    messageLabel.setText("Login Successful");
                }
                else
                {
                    messageLabel.setText("Incorrect Passphrase");
                }
            }
        }

        if (!isUser)
        {
            messageLabel.setText("User not found, create a new account");
        }


    }

}
