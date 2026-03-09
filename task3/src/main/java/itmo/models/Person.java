package itmo.models;
public class Person extends Object {

    private int health;

    public Person(String name) {
        super(name);
        this.health = 100;
    }

    public int getHealth() {
        System.out.println("Здоровье " + getName() + " - " + health);
        return health;
    }

    public void takeDamage() {
        health -= 10;
        System.out.println("Ауч... ");
        getHealth();
    }
}