package edu.illinoisstate.it296.commands;

import edu.illinoisstate.it296.ClassRegistration;
import edu.illinoisstate.it296.Course;
import edu.illinoisstate.it296.CourseHandler;
import edu.illinoisstate.it296.ProgramCommand;
import edu.illinoisstate.it296.Student;
import edu.illinoisstate.it296.User;

public class RemoveCourse extends ProgramCommand {

    public RemoveCourse(ClassRegistration program) {
        super(program, "remove");
    }

    @Override
    public void execute(User user, String[] params) {
        Student student = program.getStudent(user.getName());
        CourseHandler handler = program.getCourseHandler();

        if (params.length == 0) {
            System.out.println("Command usage: remove <courseID>");
            return;
        }

        String courseID = params[0];

        if (handler.getCourseByID(courseID) == null) {
            System.out.println(courseID + " is not a valid course.");
            return;
        }

        Course course = handler.getCourseByID(courseID);

        if (!student.enrolledIn(course)) {
            System.out.println("You're not enrolled in that course.");
            return;
        }

        student.removeCourse(course);
        System.out.println("Successfully removed " + course.getID() + " from your course list.");
    }

    @Override
    public String description() {
        return "remove <courseID> - remove a course from your list";
    }
}
