package ijse.com.student.View.util;

public class SelectCourseTM {
   private String batch_id;

    public SelectCourseTM(String batch_id) {
        this.setBatch_id(batch_id);
    }

    public String getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(String batch_id) {
        this.batch_id = batch_id;
    }

    @Override
    public String toString() {
        return "SelectCourseTM{" +
                "batch_id='" + batch_id + '\'' +
                '}';
    }
}
