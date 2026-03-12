package models;

import itmo.models.Alloy;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AlloyTest {

    @Test
    void testFlowWhenSolid() {

        Alloy alloy = new Alloy();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        boolean result = alloy.flow();

        assertFalse(result);
        assertEquals("Металл еще твердый\n", outputStream.toString());
    }

    @Test
    void testFlowWhenMelted() {

        Alloy alloy = new Alloy();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        alloy.setMelted();
        boolean result = alloy.flow();

        String expectedOutput =
                "Металл начал плавиться!\n" + "Металл потек!";

        assertTrue(result);
        assertTrue(alloy.getMelted());
        assertEquals(expectedOutput, outputStream.toString());
    }
}