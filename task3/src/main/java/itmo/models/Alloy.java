package itmo.models;

import itmo.interfaces.Metal;

public class Alloy implements Metal {
    private boolean melted;

    @Override
    public void setMelted() {
        melted = true;
        System.out.println("Металл начал плавиться!");
    }
    @Override
    public boolean getMelted() {
        return melted;
    }

    @Override
    public boolean flow() {
        if (getMelted()) {
            System.out.print("Металл потек!");
            return true;
        } else {
            System.out.println("Металл еще твердый");
            return false;
        }
    }
}