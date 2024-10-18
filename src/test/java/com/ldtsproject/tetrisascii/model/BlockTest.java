package com.ldtsproject.tetrisascii.model;

import com.ldtsproject.tetrisascii.model.Position;
import com.ldtsproject.tetrisascii.model.game.blocks.Block;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BlockTest {

    @Test
    void getRight() {
        Block block = new Block('#', 1, 1, "#FF0000");
        Block rightBlock = block.getRight();
        assertEquals(block.getX() + 1, rightBlock.getX());
    }

    @Test
    void getLeft() {
        Block block = new Block('#', 1, 1, "#FF0000");
        Block leftBlock = block.getLeft();
        assertEquals(block.getX() - 1, leftBlock.getX());
    }

    @Test
    void getUp() {
        Block block = new Block('#', 1, 1, "#FF0000");
        Block upBlock = block.getUp();
        assertEquals(block.getY() - 1, upBlock.getY());
    }

    @Test
    void getDown() {
        Block block = new Block('#', 1, 1, "#FF0000");
        Block downBlock = block.getDown();
        assertEquals(block.getY() + 1, downBlock.getY());
    }

    @Test
    void getRightRotation() {
        Block block = new Block('#', 1, 1, "#FF0000");
        Position shift = new Position(block.getX() + 1, block.getY());
        Block rotatedRightBlock = block.getRightRotation(shift);
        assertEquals(shift.getY() - block.getY() + shift.getX(), rotatedRightBlock.getX());
        assertEquals(block.getX() - shift.getX() + shift.getY(), rotatedRightBlock.getY());
    }

    @Test
    void getLeftRotation() {
        Block block = new Block('#', 1, 1, "#FF0000");
        Position shift = new Position(block.getX() + 1, block.getY());
        Block rotatedLeftBlock = block.getLeftRotation(shift);
        assertEquals(block.getY() - shift.getY() + shift.getX(), rotatedLeftBlock.getX());
        assertEquals(shift.getX() - block.getX() + shift.getY(), rotatedLeftBlock.getY());
    }
}