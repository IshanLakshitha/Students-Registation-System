package ijse.com.student.business.custom.impl;

import ijse.com.student.business.Converter;
import ijse.com.student.business.custom.ManageBatchBO;
import ijse.com.student.dao.DAOFactory;
import ijse.com.student.dao.custom.BatchDAO;
import ijse.com.student.dto.BatchDTO;

import java.sql.SQLException;
import java.util.List;

public class ManageBatchBOImpl implements ManageBatchBO {

    private BatchDAO batchDAO;

    public ManageBatchBOImpl() {
       batchDAO =  DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BATCH);
    }

    public List<BatchDTO> getBatch() throws SQLException {
        return batchDAO.findAll().map(Converter::<BatchDTO>getDTOList).get();
    }
    public boolean createBatch(BatchDTO dto) throws SQLException {
        return batchDAO.Save(Converter.getEntity(dto));
    }

    public boolean updateBatch(int selectedIndex, BatchDTO dto) throws SQLException {
        return batchDAO.Update(Converter.getEntity(dto));

    }

    public boolean deleteBatch(String batch_id) throws SQLException {
        return batchDAO.Delete(batch_id);
    }

    public BatchDTO findBatch(String batch_id) throws SQLException {
        return batchDAO.find(batch_id).map(Converter::<BatchDTO>getDTO).orElse(null);
    }
}
