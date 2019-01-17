package ijse.com.student.ComboBox;

public class Guardian {
    private String student_id;
    private String name;
    private String telephone;
    private String working_palce;
    private String address;

    public Guardian(String student_id, String name, String telephone, String working_palce, String address) {
        this.setStudent_id(student_id);
        this.setName(name);
        this.setTelephone(telephone);
        this.setWorking_palce(working_palce);
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

    public String getWorking_palce() {
        return working_palce;
    }

    public void setWorking_palce(String working_palce) {
        this.working_palce = working_palce;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Guardian{" +
                "student_id='" + student_id + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", working_palce='" + working_palce + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
