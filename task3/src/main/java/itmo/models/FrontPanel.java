package itmo.models;

import itmo.interfaces.Destroyable;
import itmo.interfaces.Metal;
import itmo.utils.StrengthState;

public class FrontPanel extends Object implements Destroyable {

    private int strengthState;
    private Metal material;

    public FrontPanel(String name, int strengthState, Metal material) {
        super(name);
        this.strengthState = strengthState;
        this.material = material;
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
            material.setMelted();
        } else if (strengthState > 10 && strengthState < 80) {
            strengthState -= 10;
            System.out.println("Передняя панель постепенно плавится.");
        } else if (strengthState == 10) {
            System.out.println("Передняя панель уничтожена");
        } else if (strengthState <= 0) {
            System.out.println("Передняя панель уже уничтожена");
        }
    }
}
