package ijse.com.student.dao.custom.impl;

import ijse.com.student.dao.CrudUtil;
import ijse.com.student.dao.custom.StudentDAO;
import ijse.com.student.entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentDAOImpl implements StudentDAO {

    public Optional<Student> find(String student_id) throws SQLException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM student WHERE student_id = ?", student_id);
        Student s = null;
        if (rst.next()) {
            s = new Student(rst.getString("student_id"),
                    rst.getString("name"),
                    rst.getString("address"),
                    rst.getString("telephone_home"),
                    rst.getString("telephone_mobile"),
                    rst.getString("email"),
                    rst.getString("dob"),
                    rst.getString("HEQ"),
                    rst.getString("gender"),
                    rst.getString("scl"),
                    rst.getString("university"),
                    rst.getString("faculty"));
        }
        return Optional.ofNullable(s);
    }

    public Optional<List<Student>> findAll() throws SQLException {
        ArrayList<Student> alStudent = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT * FROM student");
        while (rst.next()) {
            String student_id = rst.getString(1);
            String name = rst.getString(2);
            String address = rst.getString(3);
            String telephone_home = rst.getString(4);
            String telephone_mobile = rst.getString(5);
            String email = rst.getString(6);
            String dob = rst.getString(7);
            String HEQ = rst.getString(8);
            String gender = rst.getString(9);
            String scl = rst.getString(10);
            String university = rst.getString(11);
            String faculty = rst.getString(12);
            Student student = new Student(student_id, name, address, telephone_home, telephone_mobile, email,
                    dob, HEQ, gender, scl, university, faculty);
            alStudent.add(student);
        }
        return Optional.ofNullable(alStudent);
    }

    public boolean Save(Student student) throws SQLException {
        return CrudUtil.<Integer>execute("INSERT INTO student VALUES (?,?,?,?,?,?,?,?,?,?,?,?)",
                student.getStudent_id(), student.getName(), student.getAddress(), student.getTelephone_home(),
                student.getTelephone_mobile(), student.getEmail(), student.getDob(), student.getHEQ(),
                student.getGender(), student.getScl(), student.getUniversity(), student.getFaculty()) > 0;
    }

    public boolean Update(Student student) throws SQLException {
        return CrudUtil.<Integer>execute("UPDATE student SET name = ? , address = ? , telephone_home = ? , telephone_mobile = ? , email = ? , dob = ? , HEQ = ? , gender = ? , scl = ? , university = ? , faculty = ? WHERE student_id = ?",
                student.getStudent_id(), student.getName(), student.getAddress(), student.getTelephone_home(),
                student.getTelephone_mobile(), student.getEmail(), student.getDob(), student.getHEQ(),
                student.getGender(), student.getScl(), student.getUniversity(), student.getFaculty()) > 0;
    }

    public boolean Delete(String student_id) throws SQLException {
        return CrudUtil.<Integer>execute("DELETE FROM student WHERE student_id = ?",
                student_id) > 0;
    }
}
