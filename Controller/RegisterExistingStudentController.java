package ijse.com.student.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterExistingStudentController {
    @FXML
    private TextField txtSearchID;
    @FXML
    private ComboBox comboCourse;
    @FXML
    private ComboBox comboBatches;
    @FXML
    private TableView tblCourse;

    @FXML
    private void clickSearchID(KeyEvent keyEvent) {
    }

    @FXML
    private void clickAdd(ActionEvent actionEvent) {
    }

    @FXML
    private void clickDelete(ActionEvent actionEvent) {
    }

    @FXML
    private void clickSave(ActionEvent actionEvent) {
    }

    @FXML
    private void clickBack(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/ijse/com/student/View/RegisterForm.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage)txtSearchID.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Main Page");
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
    }
}
