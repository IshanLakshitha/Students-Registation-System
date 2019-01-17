package ijse.com.student.business.custom;

import ijse.com.student.business.SuperBO;
import ijse.com.student.dto.GuardianDTO;

import java.sql.SQLException;
import java.util.List;

public interface ManageGuardianBO extends SuperBO {

    List<GuardianDTO> getGuardian() throws SQLException;

    boolean createGuardian(GuardianDTO dto) throws SQLException;

    boolean  updateGuardian(GuardianDTO dto) throws SQLException;

    boolean  deleteGuardian(String student_id) throws SQLException;

    GuardianDTO findGuardian(String id) throws SQLException;

}
