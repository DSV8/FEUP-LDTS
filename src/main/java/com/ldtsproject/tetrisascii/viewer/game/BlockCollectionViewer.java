package com.ldtsproject.tetrisascii.viewer.game;

import com.ldtsproject.tetrisascii.model.game.blocks.Block;
import com.ldtsproject.tetrisascii.gui.GUI;

import java.util.Collection;

public class BlockCollectionViewer {
    public void draw(Collection<Block> blocks, GUI gui) {
        gui.drawBlockCollection(blocks);
    }
}
