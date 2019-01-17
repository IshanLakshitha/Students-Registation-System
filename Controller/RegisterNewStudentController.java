package ijse.com.student.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class RegisterNewStudentController {
    public static ArrayList<Students> StudentDB = new ArrayList<>();
    public int count = 1000;
    @FXML
    private RadioButton rdMaster;
    @FXML
    private ToggleGroup edu;
    @FXML
    private RadioButton rdDegree;
    @FXML
    private RadioButton rdDiploma;
    @FXML
    private RadioButton rdAL;
    @FXML
    private RadioButton rdOL;
    @FXML
    private RadioButton rdOther;
    @FXML
    private ToggleGroup gender;
    @FXML
    private CheckBox cbMaster;
    @FXML
    private CheckBox cbDegree;
    @FXML
    private CheckBox cbDiploma;
    @FXML
    private CheckBox cbAL;
    @FXML
    private CheckBox cbOL;
    @FXML
    private CheckBox cbOther;
    @FXML
    private RadioButton rdoMale;
    @FXML
    private RadioButton rdoFemale;
    @FXML
    private TextField txtDob;
    @FXML
    private TextField txtStudentID;
    @FXML
    private TextField txtStudentName;
    @FXML
    private TextField txtStudentAddress;
    @FXML
    private TextField txtTele;
    @FXML
    private TextField txtMobile;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtSchool;
    @FXML
    private TextField txtUniversity;
    @FXML
    private TextField txtFaculty;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnDelete;
    @FXML
    private TableView tblRegisterStudentCourse;


    public static void createStudents(Students students) {
        StudentDB.add(students);
    }

    public void initialize() {
        rdoMale.setUserData("Male");
        rdoFemale.setUserData("Female");

        rdMaster.setUserData("Master");
        rdDegree.setUserData("Degree");
        rdDiploma.setUserData("Diploma");
        rdAL.setUserData("A/L");
        rdOL.setUserData("O/L");

        for (Students students : StudentDB) {
            txtStudentID.setText(students.getStudent_id());
            txtStudentName.setText(students.getName());
            txtStudentAddress.setText(students.getAddress());
            txtTele.setText(students.getTelephone_home());
            txtMobile.setText(students.getTelephone_mobile());
            txtEmail.setText(students.getEmail());
            txtDob.setText(students.getEmail());
            //ComboGender.setSelectionModel(students.getGender().toString());
            txtSchool.setText(students.getScl());
            txtUniversity.setText(students.getUniversity());
            txtFaculty.setText(students.getFaculty());
            //ComboEdu.setSelectionModel(students.getHEQ().toString());
        }

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentregistation ", "root", "");
            PreparedStatement pstm = connection.prepareStatement("SELECT COUNT(student_id) AS X FROM student");
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {

                int anInt = resultSet.getInt(1);
                count = count +anInt;
                //  count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        txtStudentID.setText(count + " ");
        txtStudentID.setEditable(false);


    }

    @FXML
    private void clickBack(ActionEvent actionEvent) throws IOException {
        StudentDB.clear();

        Parent parent = FXMLLoader.load(this.getClass().getResource("/ijse/com/student/View/RegisterForm.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage) txtTele.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Main Page");
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
    }

    public void clickNext(ActionEvent actionEvent) throws IOException {
        if (txtStudentName.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Student Name is Empty", ButtonType.OK).showAndWait();
            txtStudentName.requestFocus();
            return;
        } else if (txtStudentAddress.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Student Address is Empty", ButtonType.OK).showAndWait();
            txtStudentAddress.requestFocus();
            return;
        } else if (txtTele.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Student Home telephone is Empty", ButtonType.OK).showAndWait();
            txtTele.requestFocus();
            return;
        } else if (txtMobile.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Student Mobile No is Empty", ButtonType.OK).showAndWait();
            txtMobile.requestFocus();
            return;
        } else if (txtEmail.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Student Email is Empty", ButtonType.OK).showAndWait();
            txtEmail.requestFocus();
            return;
        } else if (txtDob.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Student DOB is Empty", ButtonType.OK).showAndWait();
            txtDob.requestFocus();
            return;
        } else if (!gender.getSelectedToggle().isSelected()) {
            new Alert(Alert.AlertType.ERROR, "Please select gender", ButtonType.OK).showAndWait();
            return;
        } else if (txtSchool.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Student School is Empty", ButtonType.OK).showAndWait();
            txtSchool.requestFocus();
            return;
        } else if (txtUniversity.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Student University is Empty", ButtonType.OK).showAndWait();
            txtUniversity.requestFocus();
            return;
        } else if (txtFaculty.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Student Faculty is Empty", ButtonType.OK).showAndWait();
            txtFaculty.requestFocus();
            return;
        } else if (!edu.getSelectedToggle().isSelected()) {
            new Alert(Alert.AlertType.INFORMATION, "Please select Qualification", ButtonType.OK).showAndWait();
            return;
        }


        Students students = new Students(txtStudentID.getText(), txtStudentName.getText(), txtStudentAddress.getText(), txtTele.getText(),
                txtMobile.getText(), txtEmail.getText(), txtDob.getText(), edu.getSelectedToggle().getUserData().toString(),
                gender.getSelectedToggle().getUserData().toString(), txtSchool.getText(), txtUniversity.getText(), txtFaculty.getText());


        createStudents(students);

        new Alert(Alert.AlertType.INFORMATION, "Succeddfully", ButtonType.OK).showAndWait();


        Parent parent = FXMLLoader.load(this.getClass().getResource("/ijse/com/student/View/Guardian_details.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage) txtTele.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Main Page");
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
    }
}



