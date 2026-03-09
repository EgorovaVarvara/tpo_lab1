package itmo.commands;

import itmo.models.Person;

import java.util.List;

public class HuddleCommand implements BaseCommand {

    private List<Person> people;

    public HuddleCommand(List<Person> people) {
        this.people = people;
    }

    @Override
    public void execute() {
        for (Person p : people) {
            System.out.print(p.getName() + " ");
        }
        System.out.println("сгрудились плотнее. ");
    }
}
