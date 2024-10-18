package com.ldtsproject.tetrisascii.model.game.blocks.piece;

import com.ldtsproject.tetrisascii.model.Position;
import com.ldtsproject.tetrisascii.model.game.blocks.BlockFormation;
import com.ldtsproject.tetrisascii.model.game.blocks.Block;

import java.util.ArrayList;

public abstract class Piece extends BlockFormation {
    private boolean rotates = true;

    public boolean rotates() {
        return rotates;
    }
    protected void setRotatesFalse() {
        this.rotates = false;
    }

    public abstract ArrayList<Block> shapeBlocks();

    public void addSpawnPosition(Position spawnPosition) {
        for (Block block : getBlocks()) {
            block.setX(block.getX() + spawnPosition.getX());
            block.setY(block.getY() + spawnPosition.getY());
        }
    }

    public ArrayList<Block> getRightRotation() {
        Block center = getBlocks().get(1);
        Position shift = new Position(center.getX(), center.getY());
        ArrayList<Block> newBlocks = new ArrayList<>();
        for (Block block : getBlocks()) {
            newBlocks.add(block.getRightRotation(shift));
        }
        return newBlocks;
    }

    public ArrayList<Block> getLeftRotation() {
        Block center = getBlocks().get(1);
        Position shift = new Position(center.getX(), center.getY());
        ArrayList<Block> newBlocks = new ArrayList<>();
        for (Block block : getBlocks()) {
            newBlocks.add(block.getLeftRotation(shift));
        }
        return newBlocks;
    }
}
