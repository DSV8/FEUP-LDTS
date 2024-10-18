package com.ldtsproject.tetrisascii.model.game.blocks;

import com.ldtsproject.tetrisascii.model.Position;

public class Block implements Comparable<Block> {
    private final char letter;
    private final String color;
    private final Position position;

    public Block(char letter, int x, int y, String color) {
        this.letter = letter;
        position = new Position(x, y);
        this.color = color;
    }

    public int getX() {
        return position.getX();
    }
    public void setX(int x) {
        position.setX(x);
    }
    public int getY() {
        return position.getY();
    }
    public void setY(int y) {
        position.setY(y);
    }

    public String getColor() {
        return color;
    }
    public char getLetter() {
        return letter;
    }

    public Block getRight() {
        return new Block(letter, position.getX() + 1, position.getY(), color);
    }
    public Block getLeft() {
        return new Block(letter, position.getX() - 1, position.getY(), color);
    }
    public Block getUp() {
        return new Block(letter, position.getX(), position.getY() - 1, color);
    }
    public Block getDown() {
        return new Block(letter, position.getX(), position.getY() + 1, color);
    }
    public Block getRightRotation(Position shift) {
        int newX = (shift.getY() - position.getY()) + shift.getX();
        int newY = (position.getX() - shift.getX()) + shift.getY();

        return new Block(letter, newX, newY, color);
    }
    public Block getLeftRotation(Position shift) {
        int newX = (position.getY() - shift.getY()) + shift.getX();
        int newY = (shift.getX() - position.getX()) + shift.getY();

        return new Block(letter, newX, newY, color);
    }

    @Override public int compareTo(Block block) {
        if (getX() == block.getX()) {
            return Integer.compare(getY(), block.getY());
        }
        return Integer.compare(getX(), block.getX());
    }
}
