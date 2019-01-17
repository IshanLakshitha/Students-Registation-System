package ijse.com.student.business.custom;

import ijse.com.student.business.SuperBO;
import ijse.com.student.dto.QualificationDTO;

import java.sql.SQLException;
import java.util.List;

public interface ManageQualificationBO extends SuperBO {

    List<QualificationDTO> getQualification() throws SQLException;

    boolean createQualification(QualificationDTO dto) throws SQLException;

    boolean updateQualification(QualificationDTO dto) throws SQLException;

    boolean deleteQualification(String student_id) throws SQLException;

    QualificationDTO findQualification(String student_id) throws SQLException;


}
