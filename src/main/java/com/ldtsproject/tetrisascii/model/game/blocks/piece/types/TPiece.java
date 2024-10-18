package com.ldtsproject.tetrisascii.model.game.blocks.piece.types;

import com.ldtsproject.tetrisascii.model.game.blocks.Block;
import com.ldtsproject.tetrisascii.model.game.blocks.piece.Piece;

import java.util.ArrayList;
import java.util.Arrays;

public class TPiece extends Piece {
    public TPiece() {
        setBlocks(shapeBlocks());
    }

    @Override
    public ArrayList<Block> shapeBlocks() {
        String color = "#800080";
        char letter = '#';
        ArrayList<Block> tBlocks = new ArrayList<>
                (Arrays.asList(new Block(letter, -1, 0, color), new Block(letter, 0, 0, color), new Block(letter, 1, 0, color), new Block(letter, 0, -1, color)));

        return tBlocks;
    }
}
