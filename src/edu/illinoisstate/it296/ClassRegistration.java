package edu.illinoisstate.it296;

import edu.illinoisstate.it296.commands.AddCourse;

import java.util.*;


public class ClassRegistration {
    private final List<ProgramCommand> commands = new ArrayList<>();
    private final Map<String, Student> studentMap = new HashMap<>();

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        commands.add(new AddCourse(this));

        System.out.println("Enter your username: ");

        String input = scanner.next();

        if (!Security.validateUsername(input)) {
            System.out.println("Please enter a valid username.");
            return;
        }

        getStudent(input);
        displayProgramMenu();

        commands.forEach(cmd -> {
            if (scanner.next().equalsIgnoreCase(cmd.getName())) {
                cmd.execute();
            }
        });
    }

    public void displayProgramMenu() {
        commands.forEach(cmd -> System.out.println(cmd.description()));
    }

    public void getStudent(String username) {
        studentMap.putIfAbsent(username, new Student(username));
        studentMap.get(username);
    }

}
