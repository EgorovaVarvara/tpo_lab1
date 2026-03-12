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
        FrontPanel panel = new FrontPanel("Передняя панель", StrengthState.INTACT, metal);
        CompBank bank = new CompBank("Компьютерный банк", panel, StrengthState.INTACT);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        bank.destroy();

        assertEquals(StrengthState.BREAKING, bank.getStrengthState());
        assertEquals(StrengthState.BREAKING, panel.getStrengthState());
        assertTrue(metal.getMelted());
    }


    @Test
    void testSecondDestroyStep() {

        Alloy metal = new Alloy();
        FrontPanel panel = new FrontPanel("Передняя панель", StrengthState.BREAKING, metal);
        CompBank bank = new CompBank("Компьютерный банк", panel, StrengthState.BREAKING);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        bank.destroy();

        String expected =
                "Передняя панель полностью расплавлена.\n" + "Компьютерный банк разрушен!\n";

        assertEquals(StrengthState.DESTROYED, bank.getStrengthState());
        assertEquals(expected, outputStream.toString());
    }


    @Test
    void testAlreadyDestroyed() {

        Alloy metal = new Alloy();
        FrontPanel panel = new FrontPanel("Передняя панель", StrengthState.DESTROYED, metal);
        CompBank bank = new CompBank("Компьютерный банк", panel, StrengthState.DESTROYED);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        bank.destroy();

        String expected =
                "Передняя панель уже уничтожена\n" + "Компьютерный банк уже полностью уничтожен\n";

        assertEquals(expected, outputStream.toString());
    }
}