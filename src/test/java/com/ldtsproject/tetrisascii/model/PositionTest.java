package com.ldtsproject.tetrisascii.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {
    @Test
    public void testConstructor() {
        Position pos = new Position(5, 10);
        assertEquals(5, pos.getX());
        assertEquals(10, pos.getY());
    }

    @Test
    public void testGettersAndSetters() {
        Position pos = new Position(0, 0);
        pos.setX(5);
        assertEquals(5, pos.getX());
        pos.setY(10);
        assertEquals(10, pos.getY());
    }
}
