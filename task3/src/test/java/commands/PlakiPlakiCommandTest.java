package commands;

import itmo.commands.PlakiPlakCommand;
import itmo.models.Person;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlakiPlakiCommandTest {

    @Test
    void testPeopleWaitingForEnd() {

        Person p1 = new Person("Емеля");
        Person p2 = new Person("Иван");

        PlakiPlakCommand command = new PlakiPlakCommand(List.of(p1, p2));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        command.execute();

        String expectedOutput =
                "Емеля ждет неминуемого конца...\n" + "Иван ждет неминуемого конца...\n";

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void testEmptyList() {

        PlakiPlakCommand command = new PlakiPlakCommand(List.of());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        command.execute();

        String expectedOutput = "";

        assertEquals(expectedOutput, outputStream.toString());
    }
}