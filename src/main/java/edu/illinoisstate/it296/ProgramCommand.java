package edu.illinoisstate.it296;

public abstract class ProgramCommand {
    protected ClassRegistration program;
    private final String name;

    /**
     * Creates a new instance of a ProgramCommand
     * @param program: an instance of the ClassRegistration program
     * @param name: the name of the specific ProgramCommand
     */
    public ProgramCommand(ClassRegistration program, String name) {
        this.program = program;
        this.name = name;
    }

    /**
     * Get's the name of the ProgramCommand
     * @return the command name
     */
    public String getName() { return name; }

    /**
     * Abstract execution method
     * @param user: The user who ran the command
     * @param params: A String array of any existing parameters
     */
    public abstract void execute(edu.illinoisstate.it296.User user, String[] params);

    /**
     * a short description of the command, shown to the user during after
     * they've ran the menu/help command
     * @return a short description of the command
     */
    public abstract String description();
}
