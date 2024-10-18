package com.ldtsproject.tetrisascii.model.game.blocks.piece.types;

import com.ldtsproject.tetrisascii.model.game.blocks.Block;
import com.ldtsproject.tetrisascii.model.game.blocks.piece.Piece;

import java.util.ArrayList;
import java.util.Arrays;

public class OPiece extends Piece {
    public OPiece() {
        setRotatesFalse();
        setBlocks(shapeBlocks());
    }

    @Override
    public ArrayList<Block> shapeBlocks() {
        String color = "#ffff00";
        char letter = '#';
        ArrayList<Block> oBlocks = new ArrayList<>
                (Arrays.asList(new Block(letter, 0, -1, color), new Block(letter, 0, 0, color), new Block(letter, 1, 0, color), new Block(letter, 1, -1, color)));

        return oBlocks;
    }
}
