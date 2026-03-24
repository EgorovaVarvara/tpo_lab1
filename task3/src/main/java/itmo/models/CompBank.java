package itmo.models;

import itmo.interfaces.Destroyable;
import itmo.utils.StrengthState;

public class CompBank extends Object implements Destroyable {

    private int strengthState;
    private FrontPanel frontPanel;
    public CompBank(String name, FrontPanel frontPanel, int strengthState) {
        super(name);
        this.frontPanel = frontPanel;
        this.strengthState = strengthState;
    }

    public int getStrengthState() {
        return strengthState;
    }

    public void setStrengthState(int strengthState) {
        this.strengthState = strengthState;
    }

    @Override
    public void destroy() {
        if (strengthState >= 80) {
            strengthState -= 10;
            frontPanel.destroy();
        } else if (strengthState > 10 && strengthState < 80) {
            strengthState -= 10;
            frontPanel.destroy();
            System.out.println("Компьютерный банк постепенно разрушается!");
        } else if (strengthState == 10){
            strengthState -= 10;
            frontPanel.destroy();
            System.out.println("Компьютерный банк полностью уничтожен");
        } else if  (strengthState <= 0) {
            System.out.println("Компьютерный банк уже уничтожен");
        }
    }
}
