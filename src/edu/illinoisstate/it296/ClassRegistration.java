package edu.illinoisstate.it296;

import edu.illinoisstate.it296.commands.AddCourse;
import edu.illinoisstate.it296.commands.DisplayMenu;
import edu.illinoisstate.it296.commands.ListCourses;
import edu.illinoisstate.it296.commands.RemoveCourse;
import edu.illinoisstate.it296.utils.CourseHandler;
import edu.illinoisstate.it296.utils.Security;

import java.util.*;


public class ClassRegistration {
    private final List<ProgramCommand> commands = new ArrayList<>();
    private final Map<String, Student> studentMap = new HashMap<>();
    boolean shouldRun = true;

    public void execute() {
        commands.add(new AddCourse(this));
        commands.add(new ListCourses(this));
        commands.add(new DisplayMenu(this));
        commands.add(new RemoveCourse(this));

        new CourseHandler(); // initialize courses

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

    private String[] gatherParams(Scanner scanner) {
        String[] params;
        String nextLine = scanner.nextLine();
        params = nextLine.split(" ", 25);
        return params;
    }

    public void displayProgramMenu(User user) {
        System.out.println("------ " + "Class Registration for " + user.getUsername() + " ------");
        commands.forEach(cmd -> System.out.println("> " + cmd.description()));
    }

    public Student getStudent(String username) {
        studentMap.putIfAbsent(username, new Student(username));
        return studentMap.get(username);
    }

}
