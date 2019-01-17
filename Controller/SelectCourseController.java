package ijse.com.student.Controller;

import ijse.com.student.View.util.SelectCourseTM;
import ijse.com.student.ComboBox.BatchComboBox;
import ijse.com.student.util.ManageRegisterCourse;
import ijse.com.student.util.ManageStudent;
import javafx.collections.FXCollections;
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

public class SelectCourseController {
    @FXML
    private TextField txtStudentID;
    @FXML
    private TextField txtSearchID;
    @FXML
    private ComboBox<BatchComboBox> comboBatches;
    @FXML
    private TableView<SelectCourseTM> tblCourse;

    public void initialize() {
        tblCourse.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("batch_id"));
        txtStudentID.setEditable(false);
        fillBatchCombo();
        comboBatches.setEditable(false);
    }


    @FXML
    private void clickDelete(ActionEvent actionEvent) {
    }

    @FXML
    private void clickSave(ActionEvent actionEvent) {
        if (txtStudentID.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please search Student ID").showAndWait();
            txtSearchID.requestFocus();
            return;
        } else if (comboBatches.getSelectionModel().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please select Course and Batch").showAndWait();
            return;
        }

        if (tblCourse.getSelectionModel().isEmpty()) {
            ObservableList<SelectCourseTM> items = tblCourse.getItems();
            for (SelectCourseTM item : items) {
                if (item.getBatch_id().equals(comboBatches.getSelectionModel())) {
                    new Alert(Alert.AlertType.ERROR, "Duplicate Course are not allowed", ButtonType.OK).showAndWait();
                    return;
                }
            }

            BatchComboBox selectedItem = comboBatches.getSelectionModel().getSelectedItem();
            SelectCourseTM selectCourseTM = new SelectCourseTM(selectedItem.getCourse_id());
            tblCourse.getItems().add(selectCourseTM);
            SelectCourse selectCourse = new SelectCourse(txtStudentID.getText(), selectedItem.getBatch());
            ManageRegisterCourse.createRegisterCourse(selectCourse);

            new Alert(Alert.AlertType.INFORMATION, "Batch has been saved successfully!!", ButtonType.OK).showAndWait();

        }
        else {
            SelectCourseTM selectedItem = tblCourse.getSelectionModel().getSelectedItem();
            selectedItem.setBatch_id(comboBatches.getSelectionModel().getSelectedItem().toString());
            tblCourse.refresh();

            int focusedIndex = tblCourse.getSelectionModel().getFocusedIndex();
            ManageRegisterCourse.updateRegisterCourse(focusedIndex, new SelectCourse(txtStudentID.getText(),comboBatches.getSelectionModel().getSelectedItem().toString()));
            new Alert(Alert.AlertType.INFORMATION,"Batch has been updated successfully!!");
        }
    }

    @FXML
    private void clickBack(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/ijse/com/student/View/RegisterForm.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage) txtSearchID.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Main Page");
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
    }

    @FXML
    private void clickSearchID(ActionEvent actionEvent) {

        Students students = ManageStudent.findStudents(txtSearchID.getText());

        if (students == null) {
            new Alert(Alert.AlertType.ERROR, "Invalid Student ID", ButtonType.OK).showAndWait();
            txtSearchID.clear();
            txtSearchID.requestFocus();
        } else {
            txtSearchID.clear();
            txtStudentID.setText(students.getStudent_id());


        }
    }

    public void fillBatchCombo() {
        ObservableList<BatchComboBox> comboitems = FXCollections.observableArrayList();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentregistation ", "root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT batch_id, course_id FROM batch");
            while (resultSet.next()) {
                BatchComboBox batchComboBox = new BatchComboBox(resultSet.getString(1), resultSet.getString(2));
                comboitems.add(batchComboBox);
            }

            comboBatches.setItems(comboitems);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
