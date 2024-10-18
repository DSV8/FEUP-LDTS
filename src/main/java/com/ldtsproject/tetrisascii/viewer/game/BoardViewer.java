package com.ldtsproject.tetrisascii.viewer.game;

import com.ldtsproject.tetrisascii.gui.GUI;
import com.ldtsproject.tetrisascii.model.game.Board;
import com.ldtsproject.tetrisascii.model.game.blocks.Block;
import com.ldtsproject.tetrisascii.model.game.blocks.piece.Piece;
import com.ldtsproject.tetrisascii.viewer.Viewer;

import java.util.Collection;
import java.util.HashMap;
import java.util.TreeSet;

public class BoardViewer extends Viewer<Board> {
    public BoardViewer(Board board) {
        super(board);
    }

    @Override
    public void drawComponents(GUI gui) {
        drawLandedBlocks(gui, getModel().getLandedBlocks(), new BlockCollectionViewer());
        drawPiece(gui, getModel().getPiece(), new BlockCollectionViewer());
    }

    private void drawLandedBlocks(GUI gui, HashMap<Integer, TreeSet<Block>> landedBlocks, BlockCollectionViewer viewer) {
        for (TreeSet<Block> sameHeightBlocks : landedBlocks.values())
            drawBlockCollection(gui, sameHeightBlocks, viewer);
    }

    private void drawPiece(GUI gui, Piece piece, BlockCollectionViewer viewer) {
        drawBlockCollection(gui, piece.getBlocks(), viewer);
    }

    private void drawBlockCollection(GUI gui, Collection<Block> collection, BlockCollectionViewer viewer) {
        viewer.draw(collection, gui);
    }
}
