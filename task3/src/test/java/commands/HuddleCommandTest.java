package commands;

import itmo.commands.HuddleCommand;
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
}