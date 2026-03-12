package models;

import itmo.models.Bombing;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BombingTest {

    @Test
    void testInitialState() {

        Bombing bombing = new Bombing("Бомбардировка");

        assertFalse(bombing.getStarted());
    }

    @Test
    void testSetStartedTrue() {

        Bombing bombing = new Bombing("Бомбардировка");

        bombing.setStarted(true);

        assertTrue(bombing.getStarted());
    }

    @Test
    void testSetStartedFalse() {

        Bombing bombing = new Bombing("Бомбардировка");

        bombing.setStarted(true);
        bombing.setStarted(false);

        assertFalse(bombing.getStarted());
    }
}