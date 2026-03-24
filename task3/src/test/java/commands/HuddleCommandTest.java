package commands;

import itmo.commands.HuddleCommand;
import itmo.commands.SitCommand;
import itmo.models.Corner;
import itmo.models.Person;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HuddleCommandTest {

    @Test
    void testHuddleWithPeople() {

        Person p1 = new Person("Емеля");
        Person p2 = new Person("Иван");

        HuddleCommand command = new HuddleCommand(List.of(p1, p2));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        command.execute();

        String expectedOutput = "Емеля Иван сгрудились плотнее. \n";

        assertEquals(expectedOutput, outputStream.toString());
    }


    @Test
    void testHuddleWithEmptyList() {

        HuddleCommand command = new HuddleCommand(List.of());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        command.execute();

        String expectedOutput = "сгрудились плотнее. \n";

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void testHuddleWithFew() {

        Person gnom = new Person("Емеля");
        Person trol1 = new Person("Андрей");
        Person trol2 = new Person("Саша");
        Person trol3 = new Person("Тим");
        Person trol4 = new Person("Артем");
        Person trol = new Person("Степа");
        Corner corner = new Corner("угол", 10, 10);
        SitCommand sit = new SitCommand(trol, corner);
        SitCommand sit1 = new SitCommand(trol1, corner);
        SitCommand sit2 = new SitCommand(trol2, corner);
        SitCommand sit3 = new SitCommand(trol3, corner);
        SitCommand sit4 = new SitCommand(trol4, corner);

        sit.execute();
        sit1.execute();
        sit2.execute();
        sit3.execute();
        sit4.execute();

        HuddleCommand command = new HuddleCommand(List.of(trol1, trol2, trol3, trol4, trol, gnom));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        command.execute();

        String expectedOutput = "Очень много людей! Началась давка\n" +
                "Ауч... \n" +
                "Здоровье Андрей - 90\n" +
                "Ауч... \n" +
                "Здоровье Саша - 90\n" +
                "Ауч... \n" +
                "Здоровье Тим - 90\n" +
                "Ауч... \n" +
                "Здоровье Артем - 90\n" +
                "Ауч... \n" +
                "Здоровье Степа - 90\n" +
                "Ауч... \n" +
                "Здоровье Емеля - 90\n";

        assertEquals(expectedOutput, outputStream.toString());
        assertEquals(90, trol1.getHealth());
    }
}