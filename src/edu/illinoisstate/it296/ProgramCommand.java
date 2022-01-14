package edu.illinoisstate.it296;

public abstract class ProgramCommand {
    private String name;

    public ProgramCommand(ClassRegistration program, String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public abstract void execute();

    public abstract String description();
}
