package itmo.commands;

import itmo.interfaces.Destroyable;
import itmo.models.Bombing;
import java.util.Objects;

public class DestroyCommand implements BaseCommand {

    private Bombing bombing;
    private Destroyable object;

    public DestroyCommand(Bombing bombing, Destroyable object) {
        this.bombing = Objects.requireNonNull(bombing, "Бомбардировки не миновать, она не может быть null");
        this.object = Objects.requireNonNull(object, "Без жертв не обойтись, не null");
    }

    @Override
    public void execute() {
        System.out.println(bombing.getName() + " разрушительна. ");
        object.destroy();
        bombing.setBombimgLevel(bombing.getBombimgLevel() + 20);
    }

}
