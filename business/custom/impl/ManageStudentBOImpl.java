package ijse.com.student.business.custom.impl;

import ijse.com.student.business.Converter;
import ijse.com.student.business.custom.ManageStudentBO;
import ijse.com.student.dao.DAOFactory;
import ijse.com.student.dao.custom.StudentDAO;
import ijse.com.student.dto.QualificationDTO;
import ijse.com.student.dto.StudentDTO;

import java.sql.SQLException;
import java.util.List;

public class ManageStudentBOImpl implements ManageStudentBO {

    private StudentDAO studentDAO;

    public ManageStudentBOImpl() {
        studentDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);
    }

    public List<StudentDTO> getStudent() throws SQLException {
        return studentDAO.findAll().map(Converter::<StudentDTO>getDTOList).get();
    }

    public boolean createStudent(StudentDTO dto) throws SQLException {
        return studentDAO.Save(Converter.getEntity(dto));
    }

    public boolean updateStudent(StudentDTO dto) throws SQLException {
        return studentDAO.Update(Converter.getEntity(dto));
    }

    public boolean deleteStudent(String student_id) throws SQLException {
        return studentDAO.Delete(student_id);
    }

    public StudentDTO findStudent(String student_id) throws SQLException {
        return studentDAO.find(student_id).map(Converter::<StudentDTO>getDTO).orElse(null);
    }


}
