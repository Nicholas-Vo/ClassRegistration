package edu.illinoisstate.it296.commands;

import edu.illinoisstate.it296.ClassRegistration;
import edu.illinoisstate.it296.Course;
import edu.illinoisstate.it296.ProgramCommand;
import edu.illinoisstate.it296.Student;

import java.util.HashSet;
import java.util.Set;

public class ListCourses extends ProgramCommand {

    public ListCourses(ClassRegistration program) {
        super(program, "list");
    }

    @Override
    public void execute() {
        Student theStudent = program.
    }

    @Override
    public String description() {
        return "list courses you're currently enrolled in";
    }
}
