package edu.illinoisstate.it296;

/**
 * Represents a course at Illinois State University.
 */
public class Course {
    private String name;
    private String courseID;
    private int creditHours;


    /**
     * Creates a new Course with the given name, courseID, and credit hours.
     */
    public Course(String name, String courseID, int creditHours) {
        this.name = name;
        this.courseID = courseID;
        this.creditHours = creditHours;
    }

    /**
     * Gets the Student's name.
     * @return this Student's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the Student's courseID.
     * @return this Student's course ID.
     */
    public String getCourseID() {
        return courseID;
    }

    /**
     * Gets the Student's credit hours.
     * @return this Student's credit hours.
     */
    public int getCreditHours() {
        return creditHours;
    }
}
