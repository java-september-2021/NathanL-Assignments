public class ProjectTest {
    public static void main(String[] args) {
        Project project1 = new Project();
        Project project2 = new Project("chair");
        Project project3 = new Project("stool", "this is a stool");

        System.out.println(project1.getProjectName());
        System.out.println(project1.getProjectDescription());
        project1.setProjectName("table");
        project1.setProjectDescription("this is a table");
        System.out.println(project1.elevatorPitch());
        System.out.println(project2.elevatorPitch());
        System.out.println(project3.elevatorPitch());
    }

}
