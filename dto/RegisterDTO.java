package ijse.com.student.dto;

import ijse.com.student.entity.RegisterPK;

public class RegisterDTO extends SuperDTO {
    private RegisterPK registerPK;

    public RegisterDTO() {
    }

    public RegisterDTO(RegisterPK registerPK) {
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
        return "RegisterDTO{" +
                "registerPK=" + registerPK +
                '}';
    }
}
