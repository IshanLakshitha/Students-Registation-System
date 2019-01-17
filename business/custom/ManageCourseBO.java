package ijse.com.student.business.custom;

import ijse.com.student.dao.SuperDAO;
import ijse.com.student.dto.CouresesDTO;

import java.sql.SQLException;
import java.util.List;

public interface ManageCourseBO extends SuperDAO {

    List<CouresesDTO> getCoureses() throws SQLException;

    boolean createCoureses(CouresesDTO dto) throws SQLException;

    boolean updateCoureses(int selectedRow, CouresesDTO dto) throws SQLException;

    boolean deleteCoureses(String courseID) throws SQLException;

    CouresesDTO findCoureses(String id) throws SQLException;

}
