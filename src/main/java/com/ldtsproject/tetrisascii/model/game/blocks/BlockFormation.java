package com.ldtsproject.tetrisascii.model.game.blocks;

import java.util.ArrayList;

public class BlockFormation {
    private ArrayList<Block> blocks;
    public ArrayList<Block> getBlocks() {
        return blocks;
    }
    public void setBlocks(ArrayList<Block> blocks) {
        this.blocks = blocks;
    }

    public ArrayList<Block> getDown() {
        ArrayList<Block> newBlocks = new ArrayList<>();
        for (Block block : blocks) {
            newBlocks.add(block.getDown());
        }
        return newBlocks;
    }

    public ArrayList<Block> getRight() {
        ArrayList<Block> newBlocks = new ArrayList<>();
        for (Block block : blocks) {
            newBlocks.add(block.getRight());
        }
        return newBlocks;
    }

    public ArrayList<Block> getLeft() {
        ArrayList<Block> newBlocks = new ArrayList<>();
        for (Block block : blocks) {
            newBlocks.add(block.getLeft());
        }
        return newBlocks;
    }
}
