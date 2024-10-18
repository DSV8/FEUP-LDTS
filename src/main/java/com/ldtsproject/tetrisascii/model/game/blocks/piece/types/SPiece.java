package com.ldtsproject.tetrisascii.model.game.blocks.piece.types;

import com.ldtsproject.tetrisascii.model.game.blocks.Block;
import com.ldtsproject.tetrisascii.model.game.blocks.piece.Piece;

import java.util.ArrayList;
import java.util.Arrays;

public class SPiece extends Piece {
    public SPiece() {
        setBlocks(shapeBlocks());
    }

    @Override
    public ArrayList<Block> shapeBlocks() {
        String color = "#00ff00";
        char letter = '#';
        ArrayList<Block> sBlocks = new ArrayList<>
                (Arrays.asList(new Block(letter, -1, 0, color), new Block(letter, 0, 0, color), new Block(letter, 0, -1, color), new Block(letter, 1, -1, color)));

        return sBlocks;
    }
}
