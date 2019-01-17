package ijse.com.student.business.custom.impl;

import ijse.com.student.business.Converter;
import ijse.com.student.business.custom.ManageQualificationBO;
import ijse.com.student.dao.DAOFactory;
import ijse.com.student.dao.custom.QualificationDAO;
import ijse.com.student.dto.QualificationDTO;

import java.sql.SQLException;
import java.util.List;

public class ManageQualificationBOImpl implements ManageQualificationBO {

    private QualificationDAO qualificationDAO;

    public ManageQualificationBOImpl() {
        qualificationDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUALIFICATION);
    }

    public List<QualificationDTO> getQualification() throws SQLException {
        return qualificationDAO.findAll().map(Converter::<QualificationDTO>getDTOList).get();
    }

    public boolean createQualification(QualificationDTO dto) throws SQLException {
        return qualificationDAO.Save(Converter.getEntity(dto));
    }

    public boolean updateQualification(QualificationDTO dto) throws SQLException {
        return qualificationDAO.Update(Converter.getEntity(dto));
    }

    public boolean deleteQualification(String student_id) throws SQLException {
        return qualificationDAO.Delete(student_id);
    }

    public QualificationDTO findQualification(String student_id) throws SQLException {
        return qualificationDAO.find(student_id).map(Converter::<QualificationDTO>getDTO).orElse(null);
    }

}
