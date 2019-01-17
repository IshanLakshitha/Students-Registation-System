package ijse.com.student.Controller;

import ijse.com.student.View.util.BatchesTM;
import ijse.com.student.business.custom.ManageBatchBO;
import ijse.com.student.dto.BatchDTO;
import ijse.com.student.ComboBox.Batches;
import ijse.com.student.ComboBox.CourseComboBox;
import ijse.com.student.util.ManageBatches;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import java.util.List;
import java.util.Optional;

public class BatchController {

    @FXML
    private Button btnSave;
    @FXML
    private Button btnDelete;

    @FXML
    private TableView<BatchesTM> tblBaches;


    @FXML
    private ComboBox<CourseComboBox> comboBoxCourse;
    @FXML
    private TextField txtBatchID;
    @FXML
    private TextField txtDate;
    @FXML
    private TextField txtDes;
    @FXML
    private TextField txtCapacity;

    public void initialize() throws SQLException {
        tblBaches.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("batch_id"));
        tblBaches.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("course_id"));
        tblBaches.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("starting_date"));
        tblBaches.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("batch_des"));
        tblBaches.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("capacity"));
        fillCombo();

//        txtDate.setEditable(false);
        txtBatchID.setEditable(false);
        //txtCourseId.setEditable(false);
        txtDes.setEditable(false);
        txtCapacity.setEditable(false);
        txtDate.setEditable(false);
        btnDelete.setDisable(true);
        btnSave.setDisable(true);

        List<BatchDTO> batchesDB = ManageBatchBO.getBatch();
        ObservableList<BatchDTO> batches = FXCollections.observableArrayList(batchesDB);
        ObservableList<BatchesTM> tblbatches = FXCollections.observableArrayList();
        for (BatchDTO batch : batches) {
            tblbatches.add(new BatchesTM(batch.getBatch_id(), batch.getCourse_id(), batch.getStarting_data(), batch.getBatch_des(), batch.getCapacity()));
        }
        tblBaches.setItems(tblbatches);


        tblBaches.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<BatchesTM>() {
            @Override
            public void changed(ObservableValue<? extends BatchesTM> observable, BatchesTM oldValue, BatchesTM newValue) {
                if (newValue == null) {
                    return;
                }
                txtBatchID.setText(newValue.getBatch_id());
                txtDate.setText(newValue.getDate());
                txtDes.setText(newValue.getDescription());
                txtCapacity.setText(newValue.getCapacity());
            }
        });
    }

    @FXML
    private void clickSave(ActionEvent actionEvent) {
        if (comboBoxCourse.getSelectionModel().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Course is Empty", ButtonType.OK).showAndWait();
            comboBoxCourse.requestFocus();
            return;
        } else if (txtBatchID.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Batch ID is Empty", ButtonType.OK).showAndWait();
            txtBatchID.requestFocus();
            return;
        } else if (txtDes.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Description is Empty", ButtonType.OK).showAndWait();
            txtDes.requestFocus();
            return;
        } else if (txtCapacity.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Batch Capacity is Empty", ButtonType.OK).showAndWait();
            txtCapacity.requestFocus();
            return;
        } else if (txtDate.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Date is Empty", ButtonType.OK).showAndWait();
            txtDate.requestFocus();
            return;
        }


        if (tblBaches.getSelectionModel().isEmpty()) {
            ObservableList<BatchesTM> batches = tblBaches.getItems();
            for (BatchesTM batch : batches) {
                if (batch.getBatch_id().equals(txtBatchID.getText())) {
                    new Alert(Alert.AlertType.ERROR, "Duplicate Batch ID are not allowed", ButtonType.OK).showAndWait();
                    txtBatchID.requestFocus();
                    return;
                }
            }

            CourseComboBox selectedItem = comboBoxCourse.getSelectionModel().getSelectedItem();
            BatchesTM batchesTM = new BatchesTM(txtBatchID.getText(), selectedItem.getName(), txtDate.getText(), txtDes.getText(), txtCapacity.getText());
            tblBaches.getItems().add(batchesTM);
            Batches batches1 = new Batches(txtBatchID.getText(), selectedItem.getId(),  //selectedItem.toString()
                    txtDate.getText(), txtDes.getText(), txtCapacity.getText());
            ManageBatchBO.createBatch(batches1);

            new Alert(Alert.AlertType.CONFIRMATION, "Batch has been saved successfully!!", ButtonType.OK).showAndWait();
            Reset();
        } else {
            BatchesTM selectedItem = tblBaches.getSelectionModel().getSelectedItem();
            selectedItem.setBatch_id(txtBatchID.getText());
            selectedItem.setCourse_id(comboBoxCourse.getSelectionModel().getSelectedItem().toString());
            selectedItem.setCapacity(txtCapacity.getText());
            selectedItem.setDate(txtDate.getText());
            selectedItem.setDescription(txtDes.getText());
            tblBaches.refresh();

            int selectedIndex = tblBaches.getSelectionModel().getSelectedIndex();
            ManageBatchBO.updateBatch(selectedIndex, new Batches(txtBatchID.getText(),
                    comboBoxCourse.getSelectionModel().getSelectedItem().toString(), //ComboBox
                    txtDate.getText(),
                    txtDes.getText(),
                    txtCapacity.getText()));
            new Alert(Alert.AlertType.CONFIRMATION, "Batch has been updated successfully!");
            Reset();

        }
    }

    @FXML
    private void clickDelete(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to delete this batch ?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();

        if (buttonType.get() == ButtonType.YES) {
            String selectBatch = tblBaches.getSelectionModel().getSelectedItem().getBatch_id();
            ManageBatches.deleteBatches(selectBatch);
            tblBaches.getItems().remove(tblBaches.getSelectionModel().getSelectedItem());
            Reset();
        }


    }

    @FXML
    private void clickBack(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/ijse/com/student/View/MainForm.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage) txtDate.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Main Page");
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
    }

    public void fillCombo() {
        ObservableList<CourseComboBox> comboItems = FXCollections.observableArrayList();
        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentregistation ", "root", "");
            Statement comboBoxQuery = connection.createStatement();
            ResultSet rst = comboBoxQuery.executeQuery("SELECT course_id , course_name FROM course");

            while (rst.next()) {
                CourseComboBox course = new CourseComboBox(rst.getString(1), rst.getString(2));
                comboItems.add(course);
            }
            comboBoxCourse.setItems(comboItems);
            //comboBoxCourse.getSelectionModel().select(1);
            CourseComboBox selectedItem = comboBoxCourse.getSelectionModel().getSelectedItem();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void clickAdd(ActionEvent actionEvent) {
        btnSave.setDisable(false);
        btnDelete.setDisable(false);
        Reset();
    }


    public void Reset() {
//        comboBoxCourse.setEditable(true);
        txtBatchID.setEditable(true);
        //txtCourseId.setEditable(true);
        txtDate.setEditable(true);
        txtDes.setEditable(true);
        txtCapacity.setEditable(true);
        txtBatchID.clear();
        //  txtCourseId.clear();
        txtDate.clear();
        txtDes.clear();
        txtCapacity.clear();
    }
}
