package edu.illinoisstate.it296;
import java.util.HashMap;
import java.util.Map;

public class CourseHandler {
    private final Map<String, Course> map = new HashMap<>();

    public CourseHandler() {
        map.put("it279", new Course("Data Structures & Algorithms", "IT279", 3.0, 2.0));
        map.put("it355", new Course("Secure Software Development", "IT355", 3.0, 2.0));
        map.put("psy223", new Course("Social Psychology", "PSY223", 3.0, 2.0));
    }

    public Course getCourseByID(String courseID) {
        return map.get(courseID);
    }

}