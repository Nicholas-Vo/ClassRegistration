package edu.illinoisstate.it296.commands;

import edu.illinoisstate.it296.*;
import edu.illinoisstate.it296.utils.CourseHandler;

public class AddCourse extends ProgramCommand {

    public AddCourse(ClassRegistration program) {
        super(program, "add");
    }

    @Override
    public void execute(User user, String[] params) {
        Student student = program.getStudent(user.getUsername());
        CourseHandler handler = new CourseHandler();

        if (params.length == 0) {
            System.out.println("Command usage: add <courseID>");
            return;
        }

        String courseID = params[0];

        if (handler.getCourseByID(courseID.toLowerCase()) == null) {
            System.out.println(courseID + " is not a valid course.");
            return;
        }

        Course theCourse = handler.getCourseByID(courseID);

        if (student.enrolledIn(theCourse)) {
            System.out.println("You're already enrolled in " + theCourse.getID().toUpperCase());
            return;
        }

        if (student.getGPA() < theCourse.getGpaReq()) {
            System.out.println("Sorry, you cannot add that course.");
            return;
        }

        student.addCourse(theCourse);
        System.out.println("Successfully added " + theCourse.getID() + " to your course list.");
    }

    @Override
    public String description() {
        return "add <courseID> - register for a new course";
    }
}
