package itmo.models;

import itmo.interfaces.Place;

public class Corner extends Object implements Place {

    private int coordinateX;
    private int coordinateY;

    public Corner(String name, int coordinateX, int coordinateY) {
        super(name);
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public int getCoordinateX() {
        System.out.println("Координата X - " + coordinateX);
        return coordinateX;
    }
    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        System.out.println("Координата Y - " + coordinateY);
        return coordinateY;
    }
    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public void getPlace() {
        System.out.println(getName());
    }
    public void getCoordinates() {
        getCoordinateX();
        getCoordinateY();
    }
}
