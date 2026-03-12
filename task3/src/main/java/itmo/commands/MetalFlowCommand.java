package itmo.commands;

import itmo.interfaces.Metal;
import itmo.interfaces.Place;
import itmo.models.Object;
import itmo.models.Person;

import java.util.Objects;

public class MetalFlowCommand implements BaseCommand {

    private Metal metal;
    private Object object;

    public MetalFlowCommand(Metal metal, Object object) {
        this.metal = Objects.requireNonNull(metal, "Не null, иначе течь нечему -_-");
        this.object = Objects.requireNonNull(object, "Нужна локация, мир не пустой");
    }

    @Override
    public void execute() {
        if (object instanceof Place) {
            if (metal.flow()) {
                System.out.print(" Прямиком в " + object.getName() + "\n");
            }
        } else {
            System.out.println("Нельзя течь не в место -_-");
        }
    }
}
