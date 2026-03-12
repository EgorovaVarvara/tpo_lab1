package commands;

import itmo.commands.MetalFlowCommand;
import itmo.models.*;
import itmo.models.Object;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MetalFlowCommandTest {

    @Test
    void testHardMetal() {
        Corner corner = new Corner("угол", 10, 10);
        Alloy metal = new Alloy();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        MetalFlowCommand metalFlowCommand = new MetalFlowCommand(metal, corner);
        metalFlowCommand.execute();

        String expectedOutput = "Металл еще твердый\n";

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void testNotPlace() {
        Object person = new Object("Емеля");
        Alloy metal = new Alloy();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        MetalFlowCommand metalFlowCommand = new MetalFlowCommand(metal, person);
        metalFlowCommand.execute();

        String expectedOutput = "Нельзя течь не в место -_-\n";

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void testMetalFlow() {
        Corner corner = new Corner("угол", 10, 10);
        Alloy metal = new Alloy();

        metal.setMelted();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        MetalFlowCommand metalFlowCommand = new MetalFlowCommand(metal, corner);
        metalFlowCommand.execute();

        String expectedOutput = "Металл потек! Прямиком в угол\n";

        assertEquals(expectedOutput, outputStream.toString());
    }
}