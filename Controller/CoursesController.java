package ijse.com.student.Controller;

import ijse.com.student.View.util.CoursesTM;
import ijse.com.student.util.ManageCoureses;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class CoursesController {
    @FXML
    private TextField txtCourseID;
    @FXML
    private TextField txtCourseName;
    @FXML
    private TextField txtCourseDes;
    @FXML
    private TextField txtCourseDuration;
    @FXML
    private TableView<CoursesTM> tblManageCourse;

    public void initialize() {
        tblManageCourse.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("course_id"));
        tblManageCourse.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("course_name"));
        tblManageCourse.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblManageCourse.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("duration"));

        txtCourseID.setEditable(false);
        txtCourseName.setEditable(true);
        txtCourseDes.setEditable(true);
        txtCourseDuration.setEditable(true);

        ArrayList<Coureses> coursesDB = ManageCoureses.getCourses();
        ObservableList<Coureses> coureses = FXCollections.observableArrayList(coursesDB);
        ObservableList<CoursesTM> tblCoureses = FXCollections.observableArrayList();
        for (Coureses courese : coureses) {
            tblCoureses.add(new CoursesTM(courese.getCourse_id(), courese.getCourse_name(), courese.getDescription(), courese.getDuration()));
        }
        tblManageCourse.setItems(tblCoureses);

        tblManageCourse.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CoursesTM>() {
            @Override
            public void changed(ObservableValue<? extends CoursesTM> observable, CoursesTM oldValue, CoursesTM newValue) {
                if (newValue == null) {
                    return;
                }
                txtCourseID.setText(newValue.getCourse_id());
                txtCourseName.setText(newValue.getCourse_name());
                txtCourseDes.setText(newValue.getDescription());
                txtCourseDuration.setText(newValue.getDuration());
            }
        });
    }

    @FXML
    private void clickSave(ActionEvent actionEvent) {
        if (txtCourseID.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Course ID is Empty", ButtonType.OK).showAndWait();
            txtCourseID.requestFocus();
            return;
        } else if (txtCourseName.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Course Name is Empty", ButtonType.OK).showAndWait();
            txtCourseName.requestFocus();
            return;
        } else if (txtCourseDes.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Course Description is Empty", ButtonType.OK).showAndWait();
            txtCourseDes.requestFocus();
            return;
        } else if (txtCourseDuration.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Course Duration is Empty", ButtonType.OK).showAndWait();
            txtCourseDuration.requestFocus();
            return;
        }

        if (tblManageCourse.getSelectionModel().isEmpty()) {
            ObservableList<CoursesTM> courses = tblManageCourse.getItems();
            for (CoursesTM cours : courses) {
                if (cours.getCourse_id().equals(txtCourseID.getText())) {
                    new Alert(Alert.AlertType.ERROR, "Duplicate Course ID are not allowed", ButtonType.OK).showAndWait();
                    txtCourseID.requestFocus();
                    return;
                }
            }

            CoursesTM coursesTM = new CoursesTM(txtCourseID.getText(), txtCourseName.getText(), txtCourseDes.getText(), txtCourseDuration.getText());
            tblManageCourse.getItems().add(coursesTM);
            Coureses coureses = new Coureses(txtCourseID.getText(), txtCourseName.getText(), txtCourseDes.getText(), txtCourseDuration.getText());
            ManageCoureses.createCourse(coureses);

            new Alert(Alert.AlertType.CONFIRMATION, "Course has been saved successfully!!", ButtonType.OK).showAndWait();
            txtCourseID.clear();
            txtCourseName.clear();
            txtCourseDes.clear();
            txtCourseDuration.clear();
            tblManageCourse.scrollTo(coursesTM);

        } else {

            CoursesTM selectedItem = tblManageCourse.getSelectionModel().getSelectedItem();

          //  selectedItem.setCourse_id(txtCourseID.getText());
            selectedItem.setCourse_name(txtCourseName.getText());
            selectedItem.setDescription(txtCourseDes.getText());
            selectedItem.setDuration(txtCourseDuration.getText());
            tblManageCourse.refresh();

            int selectedRow = tblManageCourse.getSelectionModel().getSelectedIndex();
            ManageCoureses.updateCourse(selectedRow, new Coureses(txtCourseID.getText(),
                    txtCourseName.getText(),
                    txtCourseDes.getText(),
                    txtCourseDuration.getText()));
            new Alert(Alert.AlertType.CONFIRMATION, "Course has been updated successfully!");

        }
    }

    @FXML
    private void clickDelete(ActionEvent actionEvent) {

        Alert configMsg = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to delete this course ?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = configMsg.showAndWait();

        if(buttonType.get() == ButtonType.YES){
            String selectCourse = tblManageCourse.getSelectionModel().getSelectedItem().getCourse_id();
            ManageCoureses.deleteCourse(selectCourse);
            tblManageCourse.getItems().remove(tblManageCourse.getSelectionModel().getSelectedItem());

            txtCourseID.clear();
            txtCourseName.clear();
            txtCourseDes.clear();
            txtCourseDuration.clear();
            txtCourseID.requestFocus();
        }

    }

    @FXML
    private void clickBack(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/ijse/com/student/View/MainForm.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage) txtCourseDes.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Main Page");
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
    }

    public void clickAdd(ActionEvent actionEvent) {
        txtCourseID.clear();
        txtCourseName.clear();
        txtCourseDes.clear();
        txtCourseDuration.clear();;
        txtCourseID.setEditable(true);
        txtCourseName.setEditable(true);
        txtCourseDes.setEditable(true);
        txtCourseDuration.setEditable(true);
    }
}
