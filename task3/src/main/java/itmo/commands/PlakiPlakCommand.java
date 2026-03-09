package itmo.commands;

import itmo.models.Person;

import java.util.List;

public class PlakiPlakCommand implements BaseCommand{
    private List<Person> people;

    public PlakiPlakCommand(List<Person> people) {
        this.people = people;
    }

    @Override
    public void execute() {
        for (Person p : people) {
            System.out.println(p.getName() + " ждет неминуемого конца...");
        }
    }
}
