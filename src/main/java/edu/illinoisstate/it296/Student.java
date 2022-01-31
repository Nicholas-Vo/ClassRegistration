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
     * Creates a new Student with the given username
     */
    public Student(String username) {
        super(username);
    }

    /**
     * Add a new course to the Student's course list
     */
    public void addCourse(Course course) { courses.add(course); }

    /**
     * Remove a course from the Student's course list
     */
    public void removeCourse(Course course) { courses.remove(course); }

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
     * @return a copied HashSet of the student's courses.
     */
    public Set<Course> getCourses() { return Set.copyOf(courses); }

    /**
     * Determine if Student is enrolled in any courses.
     * @return a boolean.
     */
    public boolean inAnyCourse() { return courses.size() > 0; }

    public boolean enrolledIn(Course course) { return courses.contains(course); }

    /**
     * Prints out a String representation of the Student object
     * @return a String representation of the Student object
     */
    @Override
    public String toString() {
        return "Username: " + getName()
                + "\nEnrolled in " + getCourses().size() + " courses."
                + "\nGPA: " + gpa;
    }

}
