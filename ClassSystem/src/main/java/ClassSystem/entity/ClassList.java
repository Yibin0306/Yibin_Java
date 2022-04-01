package ClassSystem.entity;

public class ClassList {
    private int classID;
    private String value;
    private String label;

    public ClassList() {
    }

    public ClassList(int classID, String value, String label) {
        this.classID = classID;
        this.value = value;
        this.label = label;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
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
        return "ClassName{" +
                "classID=" + classID +
                ", value='" + value + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
