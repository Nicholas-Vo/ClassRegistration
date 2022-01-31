package edu.illinoisstate.it296;

/**
 * Represents a user.
 */
public class User {
    private final String username;

    /**
     * Creates a new User with the given username.
     */
    public User(String username) {
        this.username = username;
    }

    /**
     * Gets the User's username.
     * @return this User's username.
     */
    public String getName() { return username; }

    /**
     * Determine if the User is an admin
     * @return this User's admin status
     */
    public boolean isAdmin() { return username.startsWith("admin-"); }

    /**
     * Send an error message to the User
     */
    public void sendErrorMessage(String error) {
        System.out.println("There was an error: " + error);
    }

}
