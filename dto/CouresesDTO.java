package ijse.com.student.dto;

public class CouresesDTO extends SuperDTO{
    private String course_id;
    private String course_name;
    private String description;
    private String duration;

    public CouresesDTO() {

    }
    public CouresesDTO(String course_id, String course_name, String description, String duration) {
        this.setCourse_id(course_id);
        this.setCourse_name(course_name);
        this.setDescription(description);
        this.setDuration(duration);
    }

    public CouresesDTO(String course_id, String course_name){
        this.setCourse_id(course_id);
        this.setCourse_name(course_name);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "CouresesDTO{" +
                "course_id='" + course_id + '\'' +
                ", course_name='" + course_name + '\'' +
                ", description='" + description + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
