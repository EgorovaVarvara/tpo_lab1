package itmo.commands;

import itmo.interfaces.Destroyable;
import itmo.models.Bombing;
import itmo.models.Person;

import java.util.Objects;

public class HitCommand implements BaseCommand {

    private Bombing bombing;
    private Person object;

    public HitCommand(Bombing bombing, Person object) {
        this.bombing = Objects.requireNonNull(bombing, "Бомбардировки не миновать, она не может быть null");
        this.object = object;
    }

    @Override
    public void execute() {
        if (object.getHealth() != 0) {
            System.out.println("Берегись! ");
            object.takeDamage();
        } else {
            throw new Error("мертв");
        }
    }

}
