package ijse.com.student.dao;

import ijse.com.student.dao.custom.impl.*;

public class DAOFactory {

    private static DAOFactory daoFactory;

    public enum DAOTypes{
        BATCH,COURSE,GUARDIAN, QUALIFICATION, REGISTER, STUDENT;
    }

    private DAOFactory() {

    }
    public static DAOFactory getInstance() {
        if(daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public <T extends SuperDAO> T getDAO(DAOTypes daoTypes) {
        switch (daoTypes) {
            case BATCH:
                return (T) new BatchDAOImpl();
            case COURSE:
                return (T) new CourseDAOImpl();
            case GUARDIAN:
                return (T) new GuardianDAOImpl();
            case QUALIFICATION:
                return (T) new QualificationDAOImpl();
            case REGISTER:
                return (T) new RegisterDAOImpl();
            case STUDENT:
                return (T) new StudentDAOImpl();
            default:
                return null;
        }
    }
}
