package edu.illinoisstate.it296.recommendations;

import edu.illinoisstate.it296.Course;
import edu.illinoisstate.it296.Student;

import java.util.*;

public class ValidateMethodArgumentsExample extends RecommendationExample {

    @Override
    public void execute() {

        Set<Course> courses = new HashSet<>();

        courses.add(new Course("Secure Software", "IT355", 3));
        courses.add(new Course("Data Structures & Algorithms", "IT279", 3));

        Student nick = new Student("nevoss", courses);

    }

    private void validateStudent() {

    }

}
