package commands;

import itmo.commands.DestroyCommand;
import itmo.models.Alloy;
import itmo.models.Bombing;
import itmo.models.CompBank;
import itmo.models.FrontPanel;
import itmo.utils.StrengthState;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class DestroyCommandTest {

    @Test
    void testDestroyCommandExecution() {
        Bombing bombing = new Bombing("Бомбардировка");
        Alloy metal = new Alloy();
        FrontPanel panel = new FrontPanel("Передняя панель", StrengthState.INTACT, metal);
        CompBank comp = new CompBank("Компьютерный банк", panel, StrengthState.INTACT);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        DestroyCommand destroyCommand = new DestroyCommand(bombing, comp);
        destroyCommand.execute();

        String expectedOutput = "Бомбардировка разрушительна. \n" + "Металл начал плавиться!\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}