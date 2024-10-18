package com.ldtsproject.tetrisascii.model.game.blocks.piece.types;

import com.ldtsproject.tetrisascii.model.game.blocks.Block;
import com.ldtsproject.tetrisascii.model.game.blocks.piece.Piece;

import java.util.ArrayList;
import java.util.Arrays;

public class JPiece extends Piece {
    public JPiece() {
        setBlocks(shapeBlocks());
    }

    @Override
    public ArrayList<Block> shapeBlocks() {
        String color = "#0000ff";
        char letter = '#';
        ArrayList<Block> jBlocks = new ArrayList<>
                (Arrays.asList(new Block(letter, 0, -1, color), new Block(letter, 0, 0, color), new Block(letter, 1, 0, color), new Block(letter, 2, 0, color)));

        return jBlocks;
    }
}
