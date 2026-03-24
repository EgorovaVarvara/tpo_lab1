package itmo.models;
public class Person extends Object {

    private int health;
    private int coordinateX;
    private int coordinateY;

    public Person(String name) {
        super(name);
        this.health = 100;
        this.coordinateX = 0;
        this.coordinateY = 0;
    }

    public int getHealth() {
        System.out.println("Здоровье " + getName() + " - " + health);
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void death(){
        health = 0;
    }

    public void takeDamage() {
        if (health > 10) {
            health -= 10;
            System.out.println("Ауч... ");
            getHealth();
        } else {
            System.out.println(getName() + " уже мертв(");
        }
    }

    public void setCoordinate(int x, int y) {
        this.coordinateX = x;
        this.coordinateY = y;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }
}