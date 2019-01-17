package ijse.com.student.business.custom.impl;

import ijse.com.student.business.Converter;
import ijse.com.student.business.custom.ManageGuardianBO;
import ijse.com.student.dao.DAOFactory;
import ijse.com.student.dao.custom.GuardianDAO;
import ijse.com.student.dto.GuardianDTO;

import java.sql.SQLException;
import java.util.List;

public class ManageGuardianBOImpl implements ManageGuardianBO {

    private GuardianDAO guardianDAO;

    public ManageGuardianBOImpl() throws SQLException {
        guardianDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.GUARDIAN);
    }

    public List<GuardianDTO> getGuardian() throws SQLException {
        return guardianDAO.findAll().map(Converter::<GuardianDTO>getDTOList).get();
    }

    public boolean createGuardian(GuardianDTO dto) throws SQLException {
        return guardianDAO.Save(Converter.getEntity(dto));
    }

    public boolean updateGuardian(GuardianDTO dto) throws SQLException {
        return guardianDAO.Update(Converter.getEntity(dto));
    }

    public boolean deleteGuardian(String student_id) throws SQLException {
        return guardianDAO.Delete(student_id);
    }

    public GuardianDTO findGuardian(String student_id) throws SQLException {
        return guardianDAO.find(student_id).map(Converter::<GuardianDTO>getDTO).orElse(null);
    }


}
