package ijse.com.student.dto;

public class QualificationDTO extends SuperDTO {

    private String student_id;
    private String qualification;
    private String institute;
    private String date;
    private String speciale;

    public QualificationDTO() {
    }

    public QualificationDTO(String student_id, String qualification, String institute, String date, String speciale) {
        this.setStudent_id(student_id);
        this.setQualification(qualification);
        this.setInstitute(institute);
        this.setDate(date);
        this.setSpeciale(speciale);
    }


    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSpeciale() {
        return speciale;
    }

    public void setSpeciale(String speciale) {
        this.speciale = speciale;
    }

    @Override
    public String toString() {
        return "QualificationDTO{" +
                "student_id='" + student_id + '\'' +
                ", qualification='" + qualification + '\'' +
                ", institute='" + institute + '\'' +
                ", date='" + date + '\'' +
                ", speciale='" + speciale + '\'' +
                '}';
    }
}
