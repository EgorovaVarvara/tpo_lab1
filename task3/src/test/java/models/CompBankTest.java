package models;

import itmo.models.Alloy;
import itmo.models.CompBank;
import itmo.models.FrontPanel;
import itmo.utils.StrengthState;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CompBankTest {

    @Test
    void testFirstDestroyStep() {

        Alloy metal = new Alloy();
        FrontPanel panel = new FrontPanel("Передняя панель", 100, metal);
        CompBank bank = new CompBank("Компьютерный банк", panel, 100);

        bank.destroy();

        assertEquals(90, bank.getStrengthState());
        assertEquals(90, panel.getStrengthState());
        assertTrue(metal.getMelted());
    }


    @Test
    void testSecondDestroyStep() {

        Alloy metal = new Alloy();
        FrontPanel panel = new FrontPanel("Передняя панель", 60, metal);
        CompBank bank = new CompBank("Компьютерный банк", panel, 60);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        bank.destroy();

        String expected =
                "Передняя панель постепенно плавится.\n" +
                        "Компьютерный банк постепенно разрушается!\n";

        assertEquals(50, bank.getStrengthState());
        assertEquals(expected, outputStream.toString());
    }


    @Test
    void testAlreadyDestroyed() {

        Alloy metal = new Alloy();
        FrontPanel panel = new FrontPanel("Передняя панель", 0, metal);
        CompBank bank = new CompBank("Компьютерный банк", panel, 0);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        bank.destroy();

        String expected = "Компьютерный банк уже уничтожен\n";

        assertEquals(expected, outputStream.toString());
    }
}