package com.ldtsproject.tetrisascii.model.game;

import com.ldtsproject.tetrisascii.model.game.blocks.piece.Piece;

import java.util.Arrays;
import java.util.List;

public class Panel {
    private final int startX;
    private final int height;

    private final char divisor;
    private String currentScore;
    private Piece nextPiece;
    private final List<String> text;

    public Panel(int startX, int height) {
        this.startX = startX;
        this.height = height;
        currentScore = "0";
        divisor = '|';
        text = Arrays.asList("Score", "Next Piece");
    }

    public Piece getNextPiece() {
        return nextPiece;
    }

    public void setNextPiece(Piece nextPiece) {
        this.nextPiece = nextPiece;
    }

    public String getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(String currentScore) {
        this.currentScore = currentScore;
    }

    public List<String> getText() {
        return text;
    }

    public char getDivisor() {
        return divisor;
    }

    public int getHeight() {
        return height;
    }

    public int getStartX() {
        return startX;
    }
}
