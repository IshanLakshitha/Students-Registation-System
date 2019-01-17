package ijse.com.student.dao.custom.impl;

import ijse.com.student.dao.CrudUtil;
import ijse.com.student.dao.custom.GuardianDAO;
import ijse.com.student.entity.Guardian;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GuardianDAOImpl implements GuardianDAO {

    public Optional<Guardian> find(String student_id) throws SQLException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM guardian WHERE student_id = ?", student_id);
        Guardian g = null;

        if (rst.next()) {
            g = new Guardian(rst.getString("student_id"),
                    rst.getString("name"),
                    rst.getString("telephone"),
                    rst.getString("working_place"),
                    rst.getString("address"));
        }
        return Optional.ofNullable(g);
    }

    public Optional<List<Guardian>> findAll() throws SQLException {
        ArrayList<Guardian> alGuardian = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT * FROM guardian");
        while (rst.next()) {
            String student_id = rst.getString(1);
            String name = rst.getString(2);
            String telephone = rst.getString(3);
            String working_place = rst.getString(4);
            String address = rst.getString(5);
            Guardian guardian = new Guardian(student_id, name, telephone, working_place, address);
            alGuardian.add(guardian);
        }
        return Optional.ofNullable(alGuardian);
    }

    public boolean Save(Guardian guardian) throws SQLException {
        return CrudUtil.<Integer>execute("INSERT INTO guardian VALUES (?, ?, ?, ?, ?)",
                guardian.getStudent_id(), guardian.getName(), guardian.getTelephone(), guardian.getWorking_place(),
                guardian.getAddress()) > 0;
    }

    @Override
    public boolean Update(Guardian entity) throws SQLException {
        return false;
    }

    @Override
    public boolean Delete(String key) throws SQLException {
        return false;
    }
}
