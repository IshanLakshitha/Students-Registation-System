package ijse.com.student.dao.custom.impl;

import ijse.com.student.dao.CrudUtil;
import ijse.com.student.dao.custom.CourseDAO;
import ijse.com.student.entity.Course;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseDAOImpl implements CourseDAO {

    public Optional<Course> find(String course_id) throws SQLException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM course WHERE course_id = ?", course_id);
        Course c = null;

        if (rst.next()) {
            c = new Course(rst.getString("course_id"),
                    rst.getString("course_name"),
                    rst.getString("course_description"),
                    rst.getString("course_duration"));
        }
        return Optional.ofNullable(c);
    }

    public Optional<List<Course>> findAll() throws SQLException {
        ArrayList<Course> alCourse = new ArrayList<>();
        ResultSet rst = CrudUtil.<ResultSet>execute("SELECT * FROM course");
        while (rst.next()) {
            String course_id = rst.getString(1);
            String course_name = rst.getString(2);
            String course_description = rst.getString(3);
            String duration = rst.getString(4);
            Course course = new Course(course_id, course_name, course_description, duration);
            alCourse.add(course);
        }
        return Optional.ofNullable(alCourse);
    }

    public boolean Save(Course course) throws SQLException {
        return CrudUtil.<Integer>execute("INSERT INTO course VALUES (? , ? , ? , ?)",
                course.getCourse_id(), course.getCourse_name(), course.getCourse_description(),
                course.getCourse_duration()) > 0;
    }

    public boolean Update(Course course) throws SQLException {
        return CrudUtil.<Integer>execute("UPDATE course SET course_name = ?,course_description = ?,course_duration = ? WHERE course_id = ?",
                course.getCourse_id(), course.getCourse_name(), course.getCourse_description(),
                course.getCourse_duration()) > 0;
    }

    public boolean Delete(String course_id) throws SQLException {
        return CrudUtil.<Integer>execute("DELETE FROM course WHERE course_id = ?",
                course_id) > 0;
    }

}
