package ijse.com.student.dao.custom.impl;

import ijse.com.student.dao.CrudUtil;
import ijse.com.student.dao.custom.QualificationDAO;
import ijse.com.student.entity.Qualification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QualificationDAOImpl implements QualificationDAO {

    public Optional<Qualification> find(String student_id) throws SQLException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM qualification WHERE student_id = ?", student_id);
        Qualification q = null;
        if(rst.next()) {
            q = new Qualification(rst.getString("student_id"),
                    rst.getString("qualification"),
                    rst.getString("institute"),
                    rst.getString("date"),
                    rst.getString("speciale"));
        }
        return Optional.ofNullable(q);
    }

    public Optional<List<Qualification>> findAll() throws SQLException {
        ArrayList<Qualification> alQualification = new ArrayList<>();
        ResultSet rst = CrudUtil.<ResultSet>execute("SELECT * FROM qualification");
        while(rst.next()) {
            String student_id = rst.getString(1);
            String qualification = rst.getString(2);
            String institute = rst.getString(3);
            String date = rst.getString(4);
            String speciale = rst.getString(5);
            Qualification qualification1 = new Qualification(student_id, qualification, institute, date, speciale);
            alQualification.add(qualification1);
        }
        return Optional.ofNullable(alQualification);
    }

    public boolean Save(Qualification qualification) throws SQLException {
        return CrudUtil.<Integer>execute("INSERT INTO qualification VALUES (? , ? , ? , ? , ?)",
                qualification.getStudent_id(), qualification.getQualification(), qualification.getInstitute(),
                qualification.getDate(), qualification.getSpeciale()) >0;
    }

    public boolean Update(Qualification qualification) throws SQLException {
        return CrudUtil.<Integer>execute("UPDATE qualification SET qualification = ? , institute = ? , date = ? , speciale = ? WHERE student_id = ?",
                qualification.getStudent_id(), qualification.getQualification(), qualification.getInstitute(), qualification.getDate(),
                qualification.getSpeciale()) > 0;
    }

    public boolean Delete(String student_id) throws SQLException {
        return CrudUtil.<Integer>execute("DELETE FROM qualification WHERE student_id = ?",
                student_id) > 0;
    }
}
