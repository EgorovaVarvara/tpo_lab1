package itmo.commands;

import itmo.interfaces.Metal;
import itmo.interfaces.Place;
import itmo.models.Person;

import java.util.Objects;

public class MetalFlowCommand implements BaseCommand {

    private Metal metal;
    private Place place;

    public MetalFlowCommand(Metal metal, Place place) {
        this.metal = Objects.requireNonNull(metal, "Не null, иначе течь нечему -_-");
        this.place = Objects.requireNonNull(place, "Нужна локация, мир не пустой");
    }

    @Override
    public void execute() {
        if (metal.flow()) {
            System.out.print(" Прямиком в " );
            place.getPlace();
        }
    }
}
