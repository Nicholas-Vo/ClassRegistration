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

        if (!student.inAnyCourse()) {
            System.out.println("You aren't enrolled in any courses.");
            return;
        }

        int courses = student.getCourses().size();
        String enrolledIn = courses == 1 ? "one course:" : courses + " courses:";

        System.out.println("You are enrolled in " + enrolledIn);
        student.getCourses().forEach(course -> System.out.println("\n" + course.toString()));
    }

    @Override
    public String description() {
        return "list - display courses you're currently enrolled in";
    }
}
