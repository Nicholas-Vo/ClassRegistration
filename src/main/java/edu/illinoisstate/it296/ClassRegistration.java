package edu.illinoisstate.it296;

import edu.illinoisstate.it296.commands.AddCourse;
import edu.illinoisstate.it296.commands.DisplayMenu;
import edu.illinoisstate.it296.commands.ListCourses;
import edu.illinoisstate.it296.commands.RemoveCourse;
import edu.illinoisstate.it296.utils.Logger;
import edu.illinoisstate.it296.utils.Security;
import org.yaml.snakeyaml.Yaml;

import java.util.*;


public class ClassRegistration {
    private final List<ProgramCommand> commands = new ArrayList<>();
    private final Map<String, Student> studentMap = new HashMap<>();
    private final Logger logger = new Logger();
    private CourseHandler handler;
    boolean shouldRun = true;

    public void execute() {
        handler = new CourseHandler();

        commands.add(new AddCourse(this));
        commands.add(new RemoveCourse(this));
        commands.add(new ListCourses(this));
        commands.add(new DisplayMenu(this));

        System.out.println("Enter your username: ");

        Scanner scanner = new Scanner(System.in);
        String username = scanner.next();

        if (!Security.isValidUsername(username)) {
            System.out.println("Please enter a valid username.");
            return;
        }

        System.out.println("Enter your GPA: ");
        double gpa = Security.validateGPA(scanner.next());

        if (gpa < 0 || gpa > 4.0) {
            System.out.println("Please enter a valid GPA.");
            return;
        }

        if (!Security.isValidUsername(username)) {
            System.out.println("Please enter a valid username.");
            return;
        }

        Student user = getStudent(username);

        user.setGPA(gpa);
        displayProgramMenu(user);

        String[] params = gatherParams(scanner);

        while (shouldRun) {
            for (ProgramCommand cmd : commands) {
                if (params[0].equalsIgnoreCase(cmd.getName())) {
                    cmd.execute(user, Arrays.copyOfRange(params, 1, params.length));
                }
            }

            params = gatherParams(scanner);
        }

    }

    /**
     * Returns a String array of any parameters User entered
     *
     * @param scanner a Scanner object
     * @return params a String array of parameters
     */
    private String[] gatherParams(Scanner scanner) {
        String[] params;
        String nextLine = scanner.nextLine();
        params = nextLine.split(" ", 25);
        return params;
    }

    /**
     * Get the instance of the course handler object
     *
     * @return handler - the course handler object
     */
    public CourseHandler getCourseHandler() {
        return handler;
    }

    /**
     * Get the instance of the program logger
     *
     * @return logger - the logger object
     */
    public Logger getProgramLogger() {
        return logger;
    }

    public List<Student> getOnlineStudents() {
        if (studentMap.isEmpty()) {
            return List.of();
        }
        return new ArrayList<>(studentMap.values());
    }

    public void displayProgramMenu(User user) {
        System.out.println("------ " + "Class Registration for " + user.getUsername() + " ------");
        commands.forEach(cmd -> System.out.println("> " + cmd.description()));
    }

    /**
     * get a Student object from the HashMap given a username; if none exists, create one
     *
     * @param username the User's username, the Key value for the HashMap
     * @return a Student object
     */
    public Student getStudent(String username) {
        studentMap.putIfAbsent(username, new Student(username));
        return studentMap.get(username);
    }

}
