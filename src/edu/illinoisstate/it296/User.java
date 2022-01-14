package edu.illinoisstate.it296;

/**
 * Represents a user.
 */
public class User {
    private String username;

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
    public String getUsername() { return username; }

}
