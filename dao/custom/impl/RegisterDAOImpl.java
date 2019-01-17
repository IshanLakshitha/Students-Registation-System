package ijse.com.student.dao.custom.impl;

import ijse.com.student.dao.CrudUtil;
import ijse.com.student.dao.custom.RegisterDAO;
import ijse.com.student.entity.RegisterPK;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RegisterDAOImpl extends RegisterPK {

    public Optional<RegisterPK> find(String student_id) throws SQLException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM register WHERE student_id = ?", student_id);
        RegisterPK r = null;

        if (rst.next()) {
            r = new RegisterPK(rst.getString("student_id"),
                    rst.getString("batch_id"));
        }
        return Optional.ofNullable(r);
    }

    public Optional<List<RegisterPK>> findAll() throws SQLException {
        ArrayList<RegisterPK> alRegister = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT * FROM register");
        while (rst.next()) {
            String student_id = rst.getString(1);
            String batch_id = rst.getString(2);
            RegisterPK registerPK = new RegisterPK(student_id, batch_id);
            alRegister.add(registerPK);
        }
        return Optional.ofNullable(alRegister);
    }

    public boolean Save(RegisterPK registerPK) throws SQLException {
        return CrudUtil.<Integer>execute("INSERT INTO register VALUES (?,?)",
                registerPK.getStudent_id(), registerPK.getBatch_id()) > 0;
    }

    public boolean Update(RegisterPK registerPK) throws SQLException {
        return CrudUtil.<Integer>execute("UPDATE register SET batch_id = ? WHERE student_id = ?",
                registerPK.getStudent_id(), registerPK.getBatch_id()) > 0;
    }

    public boolean Delete(String student_id) throws SQLException {
        return CrudUtil.<Integer>execute("DELETE FROM register WHERE student_id = ?",
                student_id) > 0;
    }
}
