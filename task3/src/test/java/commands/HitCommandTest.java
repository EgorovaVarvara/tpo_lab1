package commands;

import itmo.commands.HitCommand;
import itmo.models.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HitCommandTest {

    @Test
    void testFullHpHit() {

        Person person = new Person("Емеля");
        Bombing bombing = new Bombing("Бомбардировка", 3);

        HitCommand hitCommand = new HitCommand(bombing, person);

        hitCommand.execute();

        assertEquals(90, person.getHealth());
    }


    @Test
    void testHitFrom70Health() {

        Person person = new Person("Емеля");
        Bombing bombing = new Bombing("Бомбардировка", 3);

        person.setHealth(70);

        assertEquals(70, person.getHealth());

        HitCommand hitCommand = new HitCommand(bombing, person);
        hitCommand.execute();

        assertEquals(60, person.getHealth());
    }

    @Test
    void testDead() {

        Person person = new Person("Емеля");
        Bombing bombing = new Bombing("Бомбардировка", 3);

        person.setHealth(0);

        assertEquals(0, person.getHealth());

        HitCommand hitCommand = new HitCommand(bombing, person);

        assertEquals(0, person.getHealth());
        assertThrows(Error.class, hitCommand::execute);
    }

    @Test
    void testConsoleOutput() {

        Person person = new Person("Емеля");
        Bombing bombing = new Bombing("Бомбардировка", 3);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        HitCommand hitCommand = new HitCommand(bombing, person);
        hitCommand.execute();

        String expectedOutput =
                "Здоровье Емеля - 100\n" + "Берегись! \n" + "Ауч... \n" + "Здоровье Емеля - 90\n";

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void testNullBombing() {

        Person person = new Person("Емеля");

        Exception exception = assertThrows(
                NullPointerException.class,
                () -> new HitCommand(null, person)
        );

        assertEquals("Бомбардировки не миновать, она не может быть null", exception.getMessage());
    }

    @Test
    void testDeadPerson() {

        Person person = new Person("Емеля");
        Bombing bombing = new Bombing("Бомбардировка", 3);

        person.setHealth(10);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        HitCommand hitCommand = new HitCommand(bombing, person);
        hitCommand.execute();

        String expectedOutput =
                "Здоровье Емеля - 10\n" + "Берегись! \n" + "Емеля уже мертв(\n";

        assertEquals(expectedOutput, outputStream.toString());
    }
}