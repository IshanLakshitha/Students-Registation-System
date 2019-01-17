package ijse.com.student.entity;

public class RegisterPK {

    private String student_id;
    private String batch_id;

    public RegisterPK(String student_id, String batch_id) {
        this.setStudent_id(student_id);
        this.setBatch_id(batch_id);
    }

    public RegisterPK() {
    }


    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(String batch_id) {
        this.batch_id = batch_id;
    }

    @Override
    public String toString() {
        return "RegisterPK{" +
                "student_id='" + student_id + '\'' +
                ", batch_id='" + batch_id + '\'' +
                '}';
    }
}
