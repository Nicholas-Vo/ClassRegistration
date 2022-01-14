package edu.illinoisstate.it296.commands;

import edu.illinoisstate.it296.ClassRegistration;
import edu.illinoisstate.it296.Course;
import edu.illinoisstate.it296.ProgramCommand;
import edu.illinoisstate.it296.Student;

import java.util.HashSet;
import java.util.Set;

public class AddCourse extends ProgramCommand {

    public AddCourse(ClassRegistration program) {
        super(program, "add");
    }

    @Override
    public void execute() {
        Set<Course> courses = new HashSet<>();
        courses.add(new Course("Secure Software", "IT355", 3, 2.0));

        Student nick = new Student("nevoss", courses);

        Course theCourse = new Course("Data Structures & Algorithms", "IT279", 3, 2.0);

        if (!canAddCourse(nick, theCourse)) {
            System.out.println("Sorry, you cannot add that course.");
            return;
        }

        nick.addCourse(theCourse);
    }

    /**
     * Determine if the Student has a valid GPA for the course
     *
     * @return boolean value
     */
    private boolean canAddCourse(Student nick, Course course) {
        if (course == null) {
            return false;
        }

        return nick.getGPA() >= course.getGpaRequirement();
    }

    @Override
    public String description() {
        return "register for a new course";
    }
}
