package ijse.com.student.dao;

import ijse.com.student.entity.SuperEntity;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CrudDAO<T extends SuperEntity, ID> extends SuperDAO {
    Optional<T> find(ID key) throws SQLException;

    Optional<List<T>> findAll() throws SQLException;

    boolean Save(T entity) throws SQLException;

    boolean Update(T entity) throws SQLException;

    boolean Delete(ID key) throws SQLException;
}

