package ijse.com.student.dto;

public class GuardianDTO extends SuperDTO {

    private String student_id;
    private String name;
    private String telephone;
    private String working_place;
    private String address;

    public GuardianDTO() {
    }

    public GuardianDTO(String student_id, String name, String telephone, String working_place, String address) {
        this.setStudent_id(student_id);
        this.setName(name);
        this.setTelephone(telephone);
        this.setWorking_place(working_place);
        this.setAddress(address);
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getWorking_place() {
        return working_place;
    }

    public void setWorking_place(String working_place) {
        this.working_place = working_place;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "GuardianDTO{" +
                "student_id='" + student_id + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", working_place='" + working_place + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
