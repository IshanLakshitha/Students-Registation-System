package ijse.com.student.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class MainFormController {
    @FXML
    private Button btnRegister;

    @FXML
    private void clickRegister(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/ijse/com/student/View/RegisterForm.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage)btnRegister.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Register Page");
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
    }

    @FXML
    private void clickCourses(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/ijse/com/student/View/CoursesForm.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage)btnRegister.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Courses Page");
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
    }

    @FXML
    private void clickBatches(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/ijse/com/student/View/BatchForm.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage)btnRegister.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Batches Page");
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
    }

    @FXML
    private void clickMngStudent(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/ijse/com/student/View/ManageStudentForm.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage)btnRegister.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Manage Student Page");
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
    }
}
