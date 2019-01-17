package ijse.com.student.dao.custom.impl;

import ijse.com.student.dao.CrudUtil;
import ijse.com.student.dao.custom.BatchDAO;
import ijse.com.student.entity.Batch;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ijse.com.student.dao.CrudUtil.execute;

public class BatchDAOImpl implements BatchDAO {

    public Optional<Batch> find(String batch_id) throws SQLException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM batch WHERE batch_id = ?", batch_id);
        Batch c = null;
        if (rst.next()) {
            c = new Batch(rst.getString("batch_id"),
                    rst.getString("course_id"),
                    rst.getString("starting_date"),
                    rst.getString("batch_des"),
                    rst.getString("capacity"));
        }
        return Optional.ofNullable(c);
    }

    public Optional<List<Batch>> findAll() throws SQLException {
        ArrayList<Batch> alBatch = new ArrayList<>();
        ResultSet rst = CrudUtil.<ResultSet>execute("SELECT * FROM batch");
        while (rst.next()) {
            String batch_id = rst.getString(1);
            String course_id = rst.getString(2);
            String starting_date = rst.getString(3);
            String batch_des = rst.getString(4);
            String capacity = rst.getString(5);
            Batch batch = new Batch(batch_id, course_id, starting_date, batch_des, capacity);
            alBatch.add(batch);
        }
        return Optional.ofNullable(alBatch);
    }

    public boolean Save(Batch batch) throws SQLException {
        return CrudUtil.<Integer>execute("INSERT INTO batch VALUES (?,?,?,?,?)",
                batch.getBatch_id(), batch.getCourse_id(), batch.getStarting_data(),
                batch.getBatch_des(), batch.getCapacity()) > 0;
    }

    public boolean Update(Batch batch) throws SQLException {
        return CrudUtil.<Integer>execute("UPDATE batch SET batch_id = ? ,course_id = ? , starting_date = ? , batch_des = ? , capacity = ? WHERE batch_id = ?",
                batch.getBatch_id(), batch.getCourse_id(), batch.getStarting_data(),
                batch.getBatch_des(), batch.getCapacity()) > 0;
    }

    public boolean Delete(String batch_id) throws SQLException {
        return CrudUtil.<Integer>execute("DELETE FROM batch WHERE batch_id = ?",
                batch_id) > 0;
    }
}
