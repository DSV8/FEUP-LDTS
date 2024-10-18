package com.ldtsproject.tetrisascii.model.game.blocks.piece.types;

import com.ldtsproject.tetrisascii.model.game.blocks.Block;
import com.ldtsproject.tetrisascii.model.game.blocks.piece.Piece;

import java.util.ArrayList;
import java.util.Arrays;

public class LPiece extends Piece {
    public LPiece() {
        setBlocks(shapeBlocks());
    }

    @Override
    public ArrayList<Block> shapeBlocks() {
        String color = "#ff7f00";
        char letter = '#';
        ArrayList<Block> lBlocks = new ArrayList<>
                (Arrays.asList(new Block(letter, -2, 0, color), new Block(letter, 0, 0, color), new Block(letter, -1, 0, color), new Block(letter, 0, -1, color)));

        return lBlocks;
    }
}
