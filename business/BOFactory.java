package ijse.com.student.business;

import ijse.com.student.business.custom.impl.ManageCouresesBOlmpl;

public class BOFactory {

    public enum BOTypes {
        MANAGE_COURSES
    }

    private static BOFactory boFactory;

    private BOFactory() {

    }

    public static BOFactory getInstance() {
        if(boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public <T extends SuperBO> T getBO(BOTypes boTypes) {
        switch (boTypes) {
            case MANAGE_COURSES:
                return (T) new ManageCouresesBOlmpl();
                default:
                    return null;
        }
    }
}
