package ijse.com.student.ComboBox;

public class BatchComboBox {

    private String course_id;
    private String batch;

    public BatchComboBox(String course_id, String batch) {
        this.setCourse_id(course_id);
        this.setBatch(batch);
    }

    @Override
    public String toString() {
        return getCourse_id()+ " - " +getBatch();
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }
}
