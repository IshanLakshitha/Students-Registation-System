package ijse.com.student.business;

import ijse.com.student.dto.*;
import ijse.com.student.entity.*;
import ijse.com.student.entity.Guardian;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static <T extends SuperDTO> T getDTO(SuperEntity entity) {
        if(entity instanceof Course) {
            Course c = (Course) entity;
            return (T) new CouresesDTO(c.getCourse_id(), c.getCourse_name(), c.getCourse_description(),
             c.getCourse_duration());
        } else if(entity instanceof Batch) {
            Batch b = (Batch) entity;
            return (T) new BatchDTO(b.getBatch_id(), b.getCourse_id(), b.getStarting_data(), b.getBatch_des(), b.getCapacity());
        } else if(entity instanceof Guardian) {
            Guardian g = (Guardian) entity;
            return (T) new GuardianDTO(g.getStudent_id(), g.getName(), g.getTelephone(), g.getWorking_place(), g.getAddress());
        } else if(entity instanceof Register) {
            Register r = (Register) entity;
            return (T) new RegisterDTO(r.getRegisterPK());
        } else if(entity instanceof  Student) {
            Student s = (Student) entity;
            return (T) new StudentDTO(s.getStudent_id(), s.getName(), s.getAddress(), s.getTelephone_home(),
                    s.getTelephone_mobile(), s.getEmail(), s.getDob(), s.getHEQ(), s.getGender(), s.getScl(),
                    s.getUniversity(), s.getFaculty());
        }
        else{
            throw new RuntimeException("This entity can't be converted to a DTO");
        }
    }

    public static <T extends SuperEntity> T getEntity(SuperDTO dto) {
        if(dto instanceof CouresesDTO) {
            CouresesDTO c = (CouresesDTO) dto;
            return (T) new Course(c.getCourse_id(), c.getCourse_name(), c.getDescription(), c.getDuration());
        } else if(dto instanceof BatchDTO) {
            BatchDTO b = (BatchDTO) dto;
            return (T) new Batch(b.getBatch_id(), b.getCourse_id(), b.getStarting_data(), b.getBatch_des(), b.getCapacity());
        } else if(dto instanceof GuardianDTO) {
            GuardianDTO g = (GuardianDTO) dto;
            return (T) new Guardian(g.getStudent_id(), g.getName(), g.getTelephone(), g.getWorking_place(), g.getAddress());
        }else if(dto instanceof RegisterDTO) {
            RegisterDTO r = (RegisterDTO) dto;
            return (T) new Register(r.getRegisterPK());
        }else if(dto instanceof StudentDTO) {
            StudentDTO s = (StudentDTO) dto;
            return (T) new Student(s.getStudent_id(), s.getName(), s.getAddress(), s.getTelephone_home(), s.getTelephone_mobile(), s.getEmail(), s.getDob(), s.getHEQ(),
                    s.getGender(), s.getScl(), s.getUniversity(), s.getFaculty());
        } else{
            throw new RuntimeException("This DTO can't be converted to an entity");
        }
    }

    public static <T extends SuperDTO> List<T> getDTOList(List<? extends SuperEntity> entities){
        SuperEntity o = (SuperEntity) entities.get(0);
        if(o instanceof Course) {
            List<CouresesDTO> dtos = new ArrayList<>();
            for (Object e : entities) {
                Course c = (Course) e;
                dtos.add((CouresesDTO) getDTO(c));
            }
            return (List<T>) dtos;
        } else if(o instanceof Batch) {
            List<BatchDTO> dtos = new ArrayList<>();
            for(Object e : entities) {
                Batch b = (Batch) e;
                dtos.add((BatchDTO) getDTO(b));
            }
            return (List<T>) dtos;
        }  else if(o instanceof Guardian) {
            List<GuardianDTO> dtos = new ArrayList<>();
            for(Object e : entities) {
                Guardian g = (Guardian) e;
                dtos.add((GuardianDTO) getDTO(g));
            }
            return (List<T>) dtos;
        }  else if(o instanceof Register) {
            List<RegisterDTO> dtos = new ArrayList<>();
            for(Object e : entities) {
                Register r = (Register) e;
                dtos.add((RegisterDTO) getDTO(r));
            }
            return (List<T>) dtos;
        }  else if(o instanceof Student) {
            List<StudentDTO> dtos = new ArrayList<>();
            for(Object e : entities) {
                Student s = (Student) e;
                dtos.add((StudentDTO) getDTO(s));
            }
            return (List<T>) dtos;
        }
        else {
            throw new RuntimeException("This entity list can't be converted to a DTO list");
        }
    }

    public static <T extends SuperDTO> T getDTO(CustomEntity entity, Class<T> dtoClass) {
        if(dtoClass == CouresesDTO.class) {
            return (T) new CouresesDTO(entity.getCourse_id(), entity.getCourse_name(),
                    entity.getCourse_description(), entity.getCourse_duration());
        }
        else{
            throw new RuntimeException("Not Supported DTO");
        }
    }

    public static <T extends SuperDTO> List<T> getDTOList(List<CustomEntity> list, Class<T> dtoClass) {
        if(dtoClass == CouresesDTO.class) {
            List<CouresesDTO> dtos = new ArrayList<>();
            list.forEach(c -> dtos.add(getDTO(c, CouresesDTO.class)));
            return (List<T>) dtos;
        }
        else{
            throw new RuntimeException("Not Supported DTO");
        }
    }


}
