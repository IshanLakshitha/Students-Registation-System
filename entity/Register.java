package ijse.com.student.entity;

public class Register extends SuperEntity {

    private RegisterPK registerPK;

    public Register() {
    }

    public Register(RegisterPK registerPK) {
        this.setRegisterPK(registerPK);
    }


    public RegisterPK getRegisterPK() {
        return registerPK;
    }

    public void setRegisterPK(RegisterPK registerPK) {
        this.registerPK = registerPK;
    }

    @Override
    public String toString() {
        return "Register{" +
                "registerPK=" + registerPK +
                '}';
    }
}
