package edu.illinoisstate.it296;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a student enrolled in the school.
 * A student can be enrolled in many courses.
 */
public class Student extends User {
    private final Set<Course> courses = new HashSet<>();
    private double gpa = 0;

    /**
     * Creates a new Student with the given username, course list, and GPA.
     */
    public Student(String username) {
        super(username);
    }

    /**
     * Add a new course to the Student's course list
     */
    public void addCourse(Course course) {
        if (course == null) {
            return;
        }
        courses.add(course);
    }

    /**
     * Sets the Student's GPA.
     */
    public void setGPA(double gpa) { this.gpa = gpa; }

    /**
     * Gets the Student's GPA.
     * @return this Student's GPA.
     */
    public double getGPA() { return gpa; }

    /**
     * Gets the Student's courses
     * @return a HashSet of the student's courses.
     */
    public Set<Course> getCourses() { return courses; }

    /**
     * Determine if Student is enrolled in any courses.
     * @return a boolean.
     */
    public boolean inAnyCourse() { return courses.size() > 0; }

}
