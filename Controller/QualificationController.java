package ijse.com.student.Controller;

import ijse.com.student.View.util.QualificationTM;
import ijse.com.student.util.ManageGuardian;
import ijse.com.student.util.ManageQualification;
import ijse.com.student.util.ManageStudent;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class QualificationController {
    public static int count = 1000;
    public TableView<QualificationTM> tblQualification;
    @FXML
    private TextField txtStudentID;
    @FXML
    private TextField txtQualification;
    @FXML
    private TextField txtInstitute;
    @FXML
    private TextField txtDate;
    @FXML
    private TextField txtSpecial;
    @FXML
    private Button btnBack;

    public void initialize() {

//        ObservableList<QualificationTM> tblQualification = FXCollections.observableArrayList();
//        for (QualificationTM qualificationTM : tblQualification) {
//
//        }
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentregistation ", "root", "");
            PreparedStatement pstm = connection.prepareStatement("SELECT COUNT(student_id) as X  FROM student");
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                int anInt = resultSet.getInt(1);
                count = count + anInt;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        txtStudentID.setText(count + " ");
        txtStudentID.setEditable(false);

    }

    @FXML
    private void clickBack(ActionEvent actionEvent) throws IOException {


        Parent parent = FXMLLoader.load(this.getClass().getResource("/ijse/com/student/View/Guardian_details.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage) btnBack.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

    @FXML
    private void ClickAdd(ActionEvent actionEvent) {
        tblQualification.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("qualification"));
        tblQualification.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("institute"));
        tblQualification.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("date"));
        tblQualification.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("speciale"));
        tblQualification.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("student_id"));

        if (txtQualification.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Qualification is Empty", ButtonType.OK).showAndWait();
            txtQualification.requestFocus();
            return;
        } else if (txtInstitute.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Institute is Empty", ButtonType.OK).showAndWait();
            txtInstitute.requestFocus();
            return;
        } else if (txtDate.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Date is Empty", ButtonType.OK).showAndWait();
            txtDate.requestFocus();
            return;
        } else if (txtSpecial.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Specialization is Empty", ButtonType.OK).showAndWait();
            txtSpecial.requestFocus();
            return;
        }

        if (tblQualification.getSelectionModel().isEmpty()) {

            QualificationTM qualificationTM1 = new QualificationTM(txtQualification.getText(), txtInstitute.getText(), txtDate.getText(),
                    txtSpecial.getText(), txtStudentID.getText());

            tblQualification.getItems().add(qualificationTM1);
            txtQualification.clear();
            txtInstitute.clear();
            txtDate.clear();
            txtSpecial.clear();
        } else {
            return;
        }
    }

    @FXML
    private void clickSave(ActionEvent actionEvent) throws IOException {

        String student_id = GuardianController.GuardianDB.get(0).getStudent_id();
        String name = GuardianController.GuardianDB.get(0).getName();
        String telephone = GuardianController.GuardianDB.get(0).getTelephone();
        String working_palce = GuardianController.GuardianDB.get(0).getWorking_palce();
        String address = GuardianController.GuardianDB.get(0).getAddress();

        Guardian guardian = new Guardian(student_id, name, telephone, working_palce, address);
        ManageGuardian.createGuardia(guardian);

        String student_id1 = RegisterNewStudentController.StudentDB.get(0).getStudent_id();
        String name1 = RegisterNewStudentController.StudentDB.get(0).getName();
        String address1 = RegisterNewStudentController.StudentDB.get(0).getAddress();
        String telephone_home = RegisterNewStudentController.StudentDB.get(0).getTelephone_home();
        String telephone_mobile = RegisterNewStudentController.StudentDB.get(0).getTelephone_mobile();
        String email = RegisterNewStudentController.StudentDB.get(0).getEmail();
        String dob = RegisterNewStudentController.StudentDB.get(0).getDob();
        String heq = RegisterNewStudentController.StudentDB.get(0).getHEQ();
        String gender = RegisterNewStudentController.StudentDB.get(0).getGender();
        String scl = RegisterNewStudentController.StudentDB.get(0).getScl();
        String university = RegisterNewStudentController.StudentDB.get(0).getUniversity();
        String faculty = RegisterNewStudentController.StudentDB.get(0).getFaculty();

        Students students = new Students(student_id1, name1, address1, telephone_home, telephone_mobile, email, dob,
                heq, gender, scl, university, faculty);
        ManageStudent.createStudent(students);  //3//

        ObservableList<QualificationTM> items = tblQualification.getItems();
        ArrayList<Qualification> quali = new ArrayList<>();
        for (QualificationTM qualification1 : items) {
            quali.add(new Qualification(qualification1.getQualification(), qualification1.getInstitute(), qualification1.getDate(), qualification1.getSpeciale(), qualification1.getStudent_id()));
        }
        ManageQualification.createQualification(new Qualification(quali.get(0).getQualification(), quali.get(0).getInstitute(),
                quali.get(0).getDate(), quali.get(0).getSpeciale(), quali.get(0).getStudent_id()));


        new Alert(Alert.AlertType.INFORMATION, "Student has been saved successfully!!").showAndWait();
        tblQualification.getItems().removeAll(tblQualification.getItems());

        Parent parent = FXMLLoader.load(this.getClass().getResource("/ijse/com/student/View/RegisterForm.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage) btnBack.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();

    }
}
