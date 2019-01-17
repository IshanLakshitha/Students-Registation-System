package ijse.com.student.business.custom;

import ijse.com.student.dao.SuperDAO;
import ijse.com.student.dto.BatchDTO;

import java.sql.SQLException;
import java.util.List;

public interface ManageBatchBO extends SuperDAO {

     List<BatchDTO> getBatch() throws SQLException;
/*
    List<CouresesDTO> getCoureses() throws SQLException;*/


    boolean createBatch(BatchDTO dto) throws SQLException;

  //  boolean updateBatch(BatchDTO dto) throws SQLException;

    boolean deleteBatch(String batch_id) throws SQLException;

    BatchDTO findBatch(String batch_id) throws SQLException;

}
