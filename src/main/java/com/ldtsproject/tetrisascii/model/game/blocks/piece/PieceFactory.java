package com.ldtsproject.tetrisascii.model.game.blocks.piece;

import com.ldtsproject.tetrisascii.model.game.blocks.piece.types.*;

public class PieceFactory {
    private Piece piece;
    public Piece buildPiece(PieceShape shape){
        switch(shape) {
            case ISHAPE -> piece = new IPiece();
            case OSHAPE -> piece = new OPiece();
            case LSHAPE -> piece = new LPiece();
            case JSHAPE -> piece = new JPiece();
            case SSHAPE -> piece = new SPiece();
            case ZSHAPE -> piece = new ZPiece();
            case TSHAPE -> piece = new TPiece();
        }
        return piece;
    }
}
