package models;

import itmo.models.Person;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {

    @Test
    void testInitialHealth() {

        Person person = new Person("Емеля");

        assertEquals(100, person.getHealth());
    }

    @Test
    void testTakeDamage() {

        Person person = new Person("Емеля");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        person.takeDamage();

        String expected =
                "Ауч... \n" + "Здоровье Емеля - 90\n";

        assertEquals(expected, outputStream.toString());
        assertEquals(90, person.getHealth());
    }

    @Test
    void testAlreadyDead() {

        Person person = new Person("Емеля");

        for (int i = 0; i < 9; i++) {
            person.takeDamage();
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        person.takeDamage();

        String expected = "Емеля уже мертв(\n";

        assertEquals(expected, outputStream.toString());
    }
}