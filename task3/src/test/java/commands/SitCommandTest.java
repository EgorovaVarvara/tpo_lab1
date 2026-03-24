package commands;

import itmo.commands.SitCommand;
import itmo.models.Corner;
import itmo.models.Person;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SitCommandTest {

    @Test
    void testSitCommand() {

        Person person = new Person("Емеля");
        Corner corner = new Corner("угол", 10, 20);

        SitCommand command = new SitCommand(person, corner);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        command.execute();



        String expectedOutput =
                "Здоровье Емеля - 100\n" + "Емеля засел в угол\n" + "Координата X - 10\n" + "Координата Y - 20\n";


        assertEquals(expectedOutput, outputStream.toString());
    }


    @Test
    void testNullPerson() {

        Corner corner = new Corner("угол", 10, 20);

        Exception exception = assertThrows(
                NullPointerException.class,
                () -> new SitCommand(null, corner)
        );

        assertEquals("Люди все еще живы, он не может быть null", exception.getMessage());
    }


    @Test
    void testNullPlace() {

        Person person = new Person("Емеля");

        Exception exception = assertThrows(
                NullPointerException.class,
                () -> new SitCommand(person, null)
        );

        assertEquals("Где-то же он сидит... не null", exception.getMessage());
    }

    @Test
    void testDeadPerson() {

        Person person = new Person("Емеля");
        person.setHealth(0);

        Corner corner = new Corner("угол", 10, 20);

        SitCommand command = new SitCommand(person, corner);

        assertThrows(Error.class, command::execute);
    }
}