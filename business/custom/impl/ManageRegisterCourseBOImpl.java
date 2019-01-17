package ijse.com.student.business.custom.impl;

import ijse.com.student.business.Converter;
import ijse.com.student.business.custom.ManageRegisterCourseBO;
import ijse.com.student.dao.DAOFactory;
import ijse.com.student.dao.custom.RegisterDAO;
import ijse.com.student.dto.RegisterDTO;

import java.sql.SQLException;
import java.util.List;

public class ManageRegisterCourseBOImpl implements ManageRegisterCourseBO {

    private RegisterDAO registerDAO;

    public ManageRegisterCourseBOImpl() {
        registerDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.REGISTER);
    }

    public List<RegisterDTO> getRegisterCoourse() throws SQLException {
        return registerDAO.findAll().map(Converter::<RegisterDTO>getDTOList).get();
    }

    public boolean createRegisterCourse(RegisterDTO dto) throws SQLException {
        return registerDAO.Save(Converter.getEntity(dto));
    }

    public  boolean updateRegisterCourse(RegisterDTO dto) throws SQLException {
        return registerDAO.Update(Converter.getEntity(dto));
    }

//    public RegisterDTO findRegisterCourse(String student_id) {
//       // return registerDAO.find(student_id).map(Converter::<RegisterDTO>getDTO).orElse(null);
//    }
}
