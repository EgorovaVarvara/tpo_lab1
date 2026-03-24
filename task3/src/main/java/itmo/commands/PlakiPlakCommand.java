package itmo.commands;

import itmo.models.Bombing;
import itmo.models.Person;

import java.util.List;

public class PlakiPlakCommand implements BaseCommand{
    private List<Person> people;
    private Bombing bombing;

    public PlakiPlakCommand(List<Person> people, Bombing bombing) {
        this.people = people;
        this.bombing = bombing;
    }

    @Override
    public void execute() {
        if (bombing.getBombimgLevel() % 5 == 0 || bombing.getBombimgLevel() % 2 == 0) {
            for (Person p : people) {
                p.death();
                System.out.println(p.getName() + " не увидел светлого будущего...");
            }
        } else {
            for (Person p : people) {
                System.out.println(p.getName() + " ждет неминуемого конца...");
            }
        }
    }
}
