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
        FrontPanel panel = new FrontPanel("панель", 100, metal);

        panel.destroy();

        assertEquals(90, panel.getStrengthState());
        assertTrue(metal.getMelted());
    }


    @Test
    void testSecondDestroyStage() {

        Alloy metal = new Alloy();
        FrontPanel panel = new FrontPanel("панель", 60, metal);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        panel.destroy();

        assertEquals(50, panel.getStrengthState());
        assertEquals("Передняя панель постепенно плавится.\n", outputStream.toString());
    }


    @Test
    void testAlreadyDestroyed() {

        Alloy metal = new Alloy();
        FrontPanel panel = new FrontPanel("панель", 0, metal);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        panel.destroy();

        assertEquals("Передняя панель уже уничтожена\n", outputStream.toString());
    }
}