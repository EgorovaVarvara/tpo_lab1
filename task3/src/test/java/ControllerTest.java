import itmo.Controller;
import itmo.commands.BaseCommand;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ControllerTest {

    static class TestCommand implements BaseCommand {
        @Override
        public void execute() {
            System.out.println("команда выполнена");
        }
    }

    @Test
    void testExecuteCommands() {

        Controller controller = new Controller();
        controller.addCommand(new TestCommand());
        controller.addCommand(new TestCommand());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        controller.execute();

        String expectedOutput =
                "* команда выполнена\n" +
                        "* команда выполнена\n";

        assertEquals(expectedOutput, outputStream.toString());
    }


    @Test
    void testExecuteWithoutCommands() {

        Controller controller = new Controller();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        controller.execute();

        assertEquals("", outputStream.toString());
    }
}