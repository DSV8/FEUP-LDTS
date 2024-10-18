package com.ldtsproject.tetrisascii.model;

import com.ldtsproject.tetrisascii.model.game.Panel;
import com.ldtsproject.tetrisascii.model.game.blocks.piece.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class PanelTest {
    private Panel panel;

    @BeforeEach
    public void setUp() {
        panel = new Panel(10, 20);
    }
    @Test
    public void testNextPiece() {
        Piece piece = mock(Piece.class);

        panel.setNextPiece(piece);
        assertEquals(piece, panel.getNextPiece());
    }

    @Test
    public void testCurrentScore() {
        panel.setCurrentScore("123");
        assertEquals("123", panel.getCurrentScore());
    }

    @Test
    public void testText() {
        List<String> expected = Arrays.asList("Score", "Next Piece");

        assertEquals(expected, panel.getText());
    }

    @Test
    public void testDivisor() {
        Panel panel = new Panel(10, 20);

        assertEquals('|', panel.getDivisor());
    }

    @Test
    public void testHeight() {
        assertEquals(20, panel.getHeight());
    }

    @Test
    public void testStartX() {
        assertEquals(10, panel.getStartX());
    }
}
