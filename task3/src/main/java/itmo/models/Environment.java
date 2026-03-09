package itmo.models;

import itmo.interfaces.Destroyable;

public class Environment extends Object implements Destroyable {

    private Corner corner;
    private int heatLevel;
    private int noiseLevel;

    public Environment(String name, Corner corner) {
        super(name);
        this.corner = corner;
    }

    public int getHeatLevel() {
        System.out.println("Уровень жара - " + heatLevel);
        return heatLevel;
    }
    public void setHeatLevel(int heatLevel) {
        this.heatLevel = heatLevel;
    }

    public int getNoiseLevel() {
        System.out.println("Уровень шума - " + noiseLevel);
        return noiseLevel;
    }
    public void setNoiseLevel(int noiseLevel) {
        this.noiseLevel = noiseLevel;
    }

    @Override
    public void destroy() {
        heatLevel += 10;
        noiseLevel += 10;
        getHeatLevel();
        getNoiseLevel();
    }
}
