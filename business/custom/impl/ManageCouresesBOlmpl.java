package ijse.com.student.business.custom.impl;

import ijse.com.student.business.custom.ManageBatchBO;
import ijse.com.student.business.custom.ManageCourseBO;
import ijse.com.student.dao.DAOFactory;
import ijse.com.student.dao.custom.CouresesDAO;
import ijse.com.student.dto.CouresesDTO;

import java.sql.*;
import java.util.List;

public class ManageCouresesBOlmpl implements ManageCourseBO {

    private CouresesDAO couresesDAO;

    public ManageCouresesBOlmpl() {
        couresesDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.COURSE);
    }




    public List<CouresesDTO> getCoureses() throws SQLException {
        return couresesDAO.findAll().map(ijse.com.student.business.Converter::<CouresesDTO>getDTOList).get();
    }


    public boolean createCoureses(CouresesDTO dto) throws SQLException {
        return couresesDAO.Save(ijse.com.student.business.Converter.getEntity(dto));
    }


    public boolean updateCoureses(int selectedRow, CouresesDTO dto) throws SQLException {
        return couresesDAO.Update(ijse.com.student.business.Converter.getEntity(dto));
    }


    public boolean deleteCoureses(String courseID) throws SQLException {
        return couresesDAO.Delete(courseID);
    }


    public CouresesDTO findCoureses(String id) throws SQLException {
       return couresesDAO.find(id).map(ijse.com.student.business.Converter::<CouresesDTO>getDTO).orElse(null);
    }
}


