package models;

import itmo.models.Object;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObjectTest {

    @Test
    void testGetName() {

        Object obj = new Object("Емеля");

        assertEquals("Емеля", obj.getName());
    }
}