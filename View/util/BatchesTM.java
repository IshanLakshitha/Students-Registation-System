package ijse.com.student.View.util;

import java.util.Date;

public class BatchesTM {
    private String batch_id;
    private String course_id;
    private String date;
    private String description;
    private String capacity;

    public BatchesTM(String batch_id, String course_id, String date, String description, String capacity) {
        this.setBatch_id(batch_id);
        this.setCourse_id(course_id);
        this.setDate(date);
        this.setDescription(description);
        this.setCapacity(capacity);
    }

    public String getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(String batch_id) {
        this.batch_id = batch_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "BatchesTM{" +
                "batch_id='" + batch_id + '\'' +
                ", course_id='" + course_id + '\'' +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", capacity='" + capacity + '\'' +
                '}';
    }
}
