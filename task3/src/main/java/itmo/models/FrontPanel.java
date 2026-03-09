package itmo.models;

import itmo.interfaces.Destroyable;
import itmo.interfaces.Metal;
import itmo.utils.StrengthState;

public class FrontPanel extends Object implements Destroyable {

    private StrengthState strengthState;
    private Metal material;

    public FrontPanel(String name, StrengthState strengthState, Metal material) {
        super(name);
        this.strengthState = strengthState;
        this.material = material;
    }

    public StrengthState getStrengthState() {
        return strengthState;
    }

    public void setStrengthState(StrengthState strengthState) {
        this.strengthState = strengthState;
    }

    @Override
    public void destroy() {
        if (strengthState == StrengthState.INTACT) {
            strengthState = StrengthState.BREAKING;
            material.setMelted();
        } else if (strengthState == StrengthState.BREAKING) {
            strengthState = StrengthState.DESTROYED;
            System.out.println("Передняя панель полностью расплавлена.");
        } else {
            System.out.println("Передняя панель уже уничтожена");
        }
    }
}
