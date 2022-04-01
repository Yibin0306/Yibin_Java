package ClassSystem.entity;

public class ClassList {
    private int class_id;
    private String value;
    private String label;

    public ClassList() {
    }

    public ClassList(int class_id, String value, String label) {
        this.class_id = class_id;
        this.value = value;
        this.label = label;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "ClassList{" +
                "class_id=" + class_id +
                ", value='" + value + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
