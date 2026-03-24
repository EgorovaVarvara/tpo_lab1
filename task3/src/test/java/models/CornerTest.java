package models;

import itmo.models.Corner;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CornerTest {

    @Test
    void testCoordinatesGettersAndSetters() {

        Corner corner = new Corner("угол", 10, 20);

        assertEquals(10, corner.getX());
        assertEquals(20, corner.getY());

        corner.setCoordinateX(30);
        corner.setY(40);

        assertEquals(30, corner.getX());
        assertEquals(40, corner.getY());
    }


    @Test
    void testConsoleOutput() {

        Corner corner = new Corner("угол", 10, 20);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        corner.getPlace();
        corner.getCoordinates();

        String expected =
                "угол\n" + "Координата X - 10\n" + "Координата Y - 20\n";

        assertEquals(expected, outputStream.toString());
    }
}