package edu.illinoisstate.it296.commands;

import edu.illinoisstate.it296.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListCourses extends ProgramCommand {

    public ListCourses(ClassRegistration program) {
        super(program, "list");
    }

    @Override
    public void execute(User user, String[] params) {
        Student student = program.getStudent(user.getUsername());

        if (student.getCourses().size() < 1) {
            System.out.println("You aren't enrolled in any courses.");
            return;
        }

        for (Course course : student.getCourses()) {
            System.out.println("Course: " + course.getID() + " - " + course.getName()
                    + "\nCredit hours: " + course.getCreditHours());
        }

    }

    @Override
    public String description() {
        return "list - display courses you're currently enrolled in";
    }
}
