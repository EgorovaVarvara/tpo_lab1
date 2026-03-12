package models;

import itmo.models.Corner;
import itmo.models.Environment;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnvironmentTest {

    @Test
    void testHeatAndNoiseSetters() {

        Corner corner = new Corner("угол", 10, 20);
        Environment env = new Environment("комната", corner);

        env.setHeatLevel(5);
        env.setNoiseLevel(7);

        assertEquals(5, env.getHeatLevel());
        assertEquals(7, env.getNoiseLevel());
    }

    @Test
    void testDestroyIncreasesLevels() {

        Corner corner = new Corner("угол", 10, 20);
        Environment env = new Environment("комната", corner);

        env.setHeatLevel(5);
        env.setNoiseLevel(7);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        env.destroy();

        String expected =
                "Уровень жара - 15\n" + "Уровень шума - 17\n";

        assertEquals(expected, outputStream.toString());
        assertEquals(15, env.getHeatLevel());
        assertEquals(17, env.getNoiseLevel());
    }
}