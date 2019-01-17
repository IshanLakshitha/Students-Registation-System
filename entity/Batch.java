package ijse.com.student.entity;

public class Batch extends SuperEntity {
    private String batch_id;
    private String course_id;
    private String starting_data;
    private String batch_des;
    private String capacity;

    public Batch() {
    }

    public Batch(String batch_id, String course_id, String starting_data, String batch_des, String capacity) {
        this.setBatch_id(batch_id);
        this.setCourse_id(course_id);
        this.setStarting_data(starting_data);
        this.setBatch_des(batch_des);
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

    public String getStarting_data() {
        return starting_data;
    }

    public void setStarting_data(String starting_data) {
        this.starting_data = starting_data;
    }

    public String getBatch_des() {
        return batch_des;
    }

    public void setBatch_des(String batch_des) {
        this.batch_des = batch_des;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "batch_id='" + batch_id + '\'' +
                ", course_id='" + course_id + '\'' +
                ", starting_data='" + starting_data + '\'' +
                ", batch_des='" + batch_des + '\'' +
                ", capacity='" + capacity + '\'' +
                '}';
    }
}
