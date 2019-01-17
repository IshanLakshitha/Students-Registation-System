package ijse.com.student.ComboBox;

public class CourseComboBox {
    private String name;
    private String id;

    public CourseComboBox(String name, String id) {
        this.setName(name);
        this.setId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return getName()+ " - " +getId();
    }
}
