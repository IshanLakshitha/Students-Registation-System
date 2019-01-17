package ijse.com.student.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterForm {
    @FXML
    private Button btnNewStudent;

    @FXML
    private void clickNewStudent(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/ijse/com/student/View/RegisterNewStudent.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage)btnNewStudent.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("New Student Register Page");
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
    }
    @FXML
    private void clickExistingStudent(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/ijse/com/student/View/SelectCourse.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage)btnNewStudent.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Existing Page");
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
    }
    @FXML
    private void clickBack(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/ijse/com/student/View/MainForm.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage)btnNewStudent.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Main Page");
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
    }
}
