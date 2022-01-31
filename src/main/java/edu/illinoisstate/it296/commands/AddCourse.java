package edu.illinoisstate.it296.commands;

import edu.illinoisstate.it296.*;
import edu.illinoisstate.it296.CourseHandler;

/**
 * Represents the add command which allows a student
 * to add a course to their course shopping list.
 */
public class AddCourse extends ProgramCommand {

    /**
     * Creates a new AddCourse object
     * @param program an instance of the ClassRegistration program
     */
    public AddCourse(ClassRegistration program) {
        super(program, "add");
    }

    @Override
    public void execute(User user, String[] params) {
        Student student = program.getStudent(user.getName());
        CourseHandler handler = program.getCourseHandler();

        if (params.length == 0) {
            System.out.println("Command usage: add <courseID>");
            return;
        }

        /*
        example of non-compliant code. params[0] string wasn't validated or sanitized.
         */
        program.logger().info(user.getName() + " attempted to add the course \"" + params[0]
                + "\" to their course shopping list.");

        if (handler.getCourseByID(params[0]) == null) {
            System.out.println("That is not a valid course ID.");
            return;
        }

        String validatedCourseID = params[0];

        Course theCourse = handler.getCourseByID(validatedCourseID);

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

        /*
        example of compliant code. theCourse.getID() has been validated
         */
        program.logger().info(user.getName() + " added " + theCourse.getID() + " to their shopping list.");
    }

    @Override
    public String description() {
        return "add <courseID> - register for a new course";
    }
}
