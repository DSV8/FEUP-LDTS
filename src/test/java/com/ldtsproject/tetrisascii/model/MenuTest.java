package com.ldtsproject.tetrisascii.model;

import com.ldtsproject.tetrisascii.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {
    private Menu menu;
    @BeforeEach
    public void setUp() {
        menu = new Menu();
    }
    @Test
    public void testNextEntry() {
        menu.nextEntry();
        assertEquals(1, menu.getCurrentEntry());
        menu.nextEntry();
        assertEquals(2, menu.getCurrentEntry());
        menu.nextEntry();
        assertEquals(0, menu.getCurrentEntry());
    }

    @Test
    public void testPreviousEntry() {
        menu.previousEntry();
        assertEquals(2, menu.getCurrentEntry());
        menu.previousEntry();
        assertEquals(1, menu.getCurrentEntry());
        menu.previousEntry();
        assertEquals(0, menu.getCurrentEntry());
    }

    @Test
    public void testGetEntry() {
        assertEquals("Start", menu.getEntry(0));
        assertEquals("Leaderboard", menu.getEntry(1));
        assertEquals("Exit", menu.getEntry(2));
    }

    @Test
    public void testIsSelected() {
        assertTrue(menu.isSelected(0));
        assertFalse(menu.isSelected(1));
        assertFalse(menu.isSelected(2));
        menu.nextEntry();
        assertFalse(menu.isSelected(0));
        assertTrue(menu.isSelected(1));
        assertFalse(menu.isSelected(2));
    }

    @Test
    public void testIsSelectedExit() {
        assertFalse(menu.isSelectedExit());
        menu.nextEntry();
        assertFalse(menu.isSelectedExit());
        menu.nextEntry();
        assertTrue(menu.isSelectedExit());
    }

    @Test
    public void testIsSelectedLeaderboard() {
        assertFalse(menu.isSelectedLeaderboard());
        menu.nextEntry();
        assertTrue(menu.isSelectedLeaderboard());
        menu.nextEntry();
        assertFalse(menu.isSelectedLeaderboard());
    }

    @Test
    public void testIsSelectedStart() {
        assertTrue(menu.isSelectedStart());
        menu.nextEntry();
        assertFalse(menu.isSelectedStart());
        menu.nextEntry();
        assertFalse(menu.isSelectedStart());
    }

    @Test
    public void testGetNumberEntries() {
        assertEquals(3, menu.getNumberEntries());
    }

}
