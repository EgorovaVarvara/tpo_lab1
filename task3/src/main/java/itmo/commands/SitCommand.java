package itmo.commands;

import itmo.interfaces.Destroyable;
import itmo.interfaces.Place;
import itmo.models.Object;
import itmo.models.Person;

import java.util.Objects;

public class SitCommand implements BaseCommand {

    private Person person;
    private Place object;

    public SitCommand(Person person, Place object) {
        this.person = Objects.requireNonNull(person, "Люди все еще живы, он не может быть null");
        this.object = Objects.requireNonNull(object, "Где-то же он сидит... не null");
    }

    @Override
    public void execute() {
        System.out.print(person.getName() + " засел в ");
        object.getPlace();
        object.getCoordinates();
    }

}

