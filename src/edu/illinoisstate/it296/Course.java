package edu.illinoisstate.it296;

/**
 * Represents a course at Illinois State University.
 */
public class Course {
    private final String name;
    private final String courseID;
    private final double gpaRequirement;
    private final double creditHours;


    /**
     * Creates a new Course with the given name, courseID, and credit hours.
     */
    public Course(String name, String courseID, double creditHours, double gpaRequirement) {
        this.name = name;
        this.courseID = courseID;
        this.creditHours = creditHours;
        this.gpaRequirement = gpaRequirement;
    }

    /**
     * Gets the Course's name.
     * @return this Student's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the Course's courseID.
     * @return this Course's course ID.
     */
    public String getCourseID() {
        return courseID;
    }

    /**
     * Gets the Course's GPA requirement to enroll.
     * @return this Course's GPA requirement.
     */
    public double getGpaRequirement() {
        return gpaRequirement;
    }

    /**
     * Gets the Course's credit hours.
     * @return this Course's credit hours.
     */
    public double getCreditHours() {
        return creditHours;
    }

}
