package ijse.com.student.entity;

public class Course extends SuperEntity {
    private String course_id;
    private String course_name;
    private String course_description;
    private String course_duration;

    public Course() {
    }

    public Course(String course_id, String course_name, String course_description, String course_duration) {
        this.setCourse_id(course_id);
        this.setCourse_name(course_name);
        this.setCourse_description(course_description);
        this.setCourse_duration(course_duration);
    }


    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }

    public String getCourse_duration() {
        return course_duration;
    }

    public void setCourse_duration(String course_duration) {
        this.course_duration = course_duration;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id='" + course_id + '\'' +
                ", course_name='" + course_name + '\'' +
                ", course_description='" + course_description + '\'' +
                ", course_duration='" + course_duration + '\'' +
                '}';
    }
}
