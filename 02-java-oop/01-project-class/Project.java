public class Project {
    String name;
    String description;
    public Project() {

    }
    public Project(String name) {
        this.name = name;
    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;

    }
    public String getProjectName() {
        return name;

    }

    public String getProjectDescription(){
        return description;
    }

    public void setProjectName(String name) {
        this.name = name;
    }

    public void setProjectDescription(String description) {
        this.description = description;
    }

    public String elevatorPitch(){
    return name + ":" + description;
    }

}
