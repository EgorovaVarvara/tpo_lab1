package itmo;


import itmo.commands.BaseCommand;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final List<BaseCommand> commands;

    public Controller() {
        this.commands = new ArrayList<>();
    }

    public void addCommand(BaseCommand command) {
        commands.add(command);
    }

    public void execute() {
        for (BaseCommand command : commands) {
            System.out.print("* ");
            command.execute();
        }
    }
}