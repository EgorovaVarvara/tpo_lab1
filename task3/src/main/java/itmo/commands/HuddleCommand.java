package itmo.commands;

import itmo.models.Person;

import java.util.List;

public class HuddleCommand implements BaseCommand {

    private List<Person> people;

    public HuddleCommand(List<Person> people) {
        this.people = people;
    }

    @Override
    public void execute() {

        for (Person p : people) {

            if (p.getCoordinateX() == 0 && p.getCoordinateY() == 0) {
                continue;
            }

            int count = 0;

            for (Person other : people) {
                if (p.getCoordinateX() == other.getCoordinateX() &&
                        p.getCoordinateY() == other.getCoordinateY()) {
                    count++;
                }
            }

            if (count >= 5) {
                System.out.println("Очень много людей! Началась давка");
                for (Person person : people) {
                    person.takeDamage();
                }
                return;
            }
        }

        for (Person p : people) {
            System.out.print(p.getName() + " ");
        }
        System.out.println("сгрудились плотнее. ");
    }
}
