package itmo.models;

import itmo.interfaces.Destroyable;
import itmo.utils.StrengthState;

public class CompBank extends Object implements Destroyable {

    private StrengthState strengthState;
    private FrontPanel frontPanel;
    public CompBank(String name, FrontPanel frontPanel, StrengthState strengthState) {
        super(name);
        this.frontPanel = frontPanel;
        this.strengthState = strengthState;
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
            frontPanel.destroy();
        } else if (strengthState == StrengthState.BREAKING) {
            strengthState = StrengthState.DESTROYED;
            frontPanel.destroy();
            System.out.println("Компьютерный банк разрушен!");
        } else {
            frontPanel.destroy();
            System.out.println("Компьютерный банк уже полностью уничтожен");
        }
    }
}
