package edu.illinoisstate.it296;

import java.util.List;

public abstract class ProgramCommand {
    protected ClassRegistration program;
    private String name;

    public ProgramCommand(ClassRegistration program, String name) {
        this.program = program;
        this.name = name;
    }

    public String getName() { return name; }

    public abstract void execute(User user, String[] params);

    public abstract String description();
}
