package edu.illinoisstate.it296.commands;

import edu.illinoisstate.it296.*;

public class DisplayMenu extends ProgramCommand {

    public DisplayMenu(ClassRegistration program) {
        super(program, "menu");
    }

    @Override
    public void execute(User user, String[] params) {
        program.displayProgramMenu(user);
    }

    @Override
    public String description() {
        return "menu - display this menu";
    }
}
