package ijse.com.student.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class GuardianController {

    public static ArrayList<Guardian> GuardianDB = new ArrayList<>();
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtTele;
    @FXML
    private TextField txtWork;
    @FXML
    private TextField txtAddress;
    @FXML
    private TextField txtStudentID;
    @FXML
    private Button btnBack;
    public static int count = 1000;

    public static void createGuardians(Guardian guardian) {
        GuardianDB.add(guardian);
    }

    public void initialize() {
        for (Guardian guardian : GuardianDB) {
            txtStudentID.setText(guardian.getStudent_id());
            txtName.setText(guardian.getName());
            txtTele.setText(guardian.getTelephone());
            txtWork.setText(guardian.getWorking_palce());
            txtAddress.setText(guardian.getAddress());
        }

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentregistation ", "root", "");
            PreparedStatement pstm = connection.prepareStatement("SELECT COUNT(student_id) AS X FROM student");
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()){
                int anInt = resultSet.getInt(1);
                count = count +anInt;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        txtStudentID.setText(count+ " ");
        txtStudentID.setEditable(false);

    }

    @FXML
    private void clickBack(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/ijse/com/student/View/RegisterNewStudent.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage) btnBack.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

    @FXML
    private void clickNext(ActionEvent actionEvent) throws IOException {

        if (txtName.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Name is Empty", ButtonType.OK).showAndWait();
            txtName.requestFocus();
            return;
        } else if (txtTele.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Telephone is Empty", ButtonType.OK).showAndWait();
            txtTele.requestFocus();
            return;
        } else if (txtWork.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Working is Empty", ButtonType.OK).showAndWait();
            txtWork.requestFocus();
            return;
        } else if (txtAddress.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Address is Empty", ButtonType.OK).showAndWait();
            txtAddress.requestFocus();
            return;
        }

        Guardian guardian = new Guardian(txtStudentID.getText(), txtName.getText(), txtTele.getText(), txtWork.getText(), txtAddress.getText());
        createGuardians(guardian);

        Parent parent = FXMLLoader.load(this.getClass().getResource("/ijse/com/student/View/QualificationForm.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage) btnBack.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }
}
