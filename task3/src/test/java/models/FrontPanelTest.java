package models;

import itmo.models.Alloy;
import itmo.models.FrontPanel;
import itmo.utils.StrengthState;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FrontPanelTest {

    @Test
    void testFirstDestroyStage() {

        Alloy metal = new Alloy();
        FrontPanel panel = new FrontPanel("панель", StrengthState.INTACT, metal);

        panel.destroy();

        assertEquals(StrengthState.BREAKING, panel.getStrengthState());
        assertTrue(metal.getMelted());
    }


    @Test
    void testSecondDestroyStage() {

        Alloy metal = new Alloy();
        FrontPanel panel = new FrontPanel("панель", StrengthState.BREAKING, metal);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        panel.destroy();

        assertEquals(StrengthState.DESTROYED, panel.getStrengthState());
        assertEquals("Передняя панель полностью расплавлена.\n", outputStream.toString());
    }


    @Test
    void testAlreadyDestroyed() {

        Alloy metal = new Alloy();
        FrontPanel panel = new FrontPanel("панель", StrengthState.DESTROYED, metal);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        panel.destroy();

        assertEquals("Передняя панель уже уничтожена\n", outputStream.toString());
    }
}