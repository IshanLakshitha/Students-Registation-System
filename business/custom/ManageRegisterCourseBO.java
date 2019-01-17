package ijse.com.student.business.custom;

import ijse.com.student.business.SuperBO;
import ijse.com.student.dto.RegisterDTO;

import java.sql.SQLException;
import java.util.List;

public interface ManageRegisterCourseBO extends SuperBO {

    List<RegisterDTO>  getRegisterCoourse() throws SQLException;

    boolean createRegisterCourse(RegisterDTO dto) throws SQLException;

    boolean  updateRegisterCourse(RegisterDTO dto) throws SQLException;
}
