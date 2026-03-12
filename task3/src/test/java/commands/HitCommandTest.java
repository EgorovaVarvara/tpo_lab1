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
        Bombing bombing = new Bombing("Бомбардировка");

        HitCommand hitCommand = new HitCommand(bombing, person);

        hitCommand.execute();

        assertEquals(90, person.getHealth());
    }


    @Test
    void testHitFrom70Health() {

        Person person = new Person("Емеля");
        Bombing bombing = new Bombing("Бомбардировка");

        for (int i = 0; i < 3; i++) {
            person.takeDamage();
        }

        assertEquals(70, person.getHealth());

        HitCommand hitCommand = new HitCommand(bombing, person);
        hitCommand.execute();

        assertEquals(60, person.getHealth());
    }

    @Test
    void testConsoleOutput() {

        Person person = new Person("Емеля");
        Bombing bombing = new Bombing("Бомбардировка");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        HitCommand hitCommand = new HitCommand(bombing, person);
        hitCommand.execute();

        String expectedOutput =
                "Берегись! \n" + "Ауч... \n" + "Здоровье Емеля - 90\n";

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
        Bombing bombing = new Bombing("Бомбардировка");

        for (int i = 0; i < 10; i++) {
            person.takeDamage();
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        HitCommand hitCommand = new HitCommand(bombing, person);
        hitCommand.execute();

        String expectedOutput =
                "Берегись! \n" + "Емеля уже мертв(\n";

        assertEquals(expectedOutput, outputStream.toString());
    }
}