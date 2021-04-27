package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

    public void createFieldButtonAction(ActionEvent event)
    {
        if (!fieldNameTF.getText().isBlank() && !locationTF.getText().isBlank() && !dateTF.getText().isBlank())
        {
            inputField();
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

    public void inputField()
    {
        fieldOverviewPage();
        Stage stage = (Stage) createFieldB.getScene().getWindow();
        stage.close();
        // input field data into csv and move onto overview page
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
