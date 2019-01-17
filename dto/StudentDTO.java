package ijse.com.student.dto;

public class StudentDTO extends SuperDTO {

    private String student_id;
    private String name;
    private String address;
    private String telephone_home;
    private String telephone_mobile;
    private String email;
    private String dob;
    private String HEQ;
    private String gender;
    private String scl;
    private String university;
    private String faculty;

    public StudentDTO() {
    }

    public StudentDTO(String student_id, String name, String address, String telephone_home, String telephone_mobile, String email, String dob, String heq, String gender, String scl, String university, String faculty) {
        this.setStudent_id(student_id);
        this.setName(name);
        this.setAddress(address);
        this.setTelephone_home(telephone_home);
        this.setTelephone_mobile(telephone_mobile);
        this.setEmail(email);
        this.setDob(dob);
        setHEQ(heq);
        this.setGender(gender);
        this.setScl(scl);
        this.setUniversity(university);
        this.setFaculty(faculty);
    }


    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone_home() {
        return telephone_home;
    }

    public void setTelephone_home(String telephone_home) {
        this.telephone_home = telephone_home;
    }

    public String getTelephone_mobile() {
        return telephone_mobile;
    }

    public void setTelephone_mobile(String telephone_mobile) {
        this.telephone_mobile = telephone_mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getHEQ() {
        return HEQ;
    }

    public void setHEQ(String HEQ) {
        this.HEQ = HEQ;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getScl() {
        return scl;
    }

    public void setScl(String scl) {
        this.scl = scl;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "student_id='" + student_id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", telephone_home='" + telephone_home + '\'' +
                ", telephone_mobile='" + telephone_mobile + '\'' +
                ", email='" + email + '\'' +
                ", dob='" + dob + '\'' +
                ", HEQ='" + HEQ + '\'' +
                ", gender='" + gender + '\'' +
                ", scl='" + scl + '\'' +
                ", university='" + university + '\'' +
                ", faculty='" + faculty + '\'' +
                '}';
    }
}
