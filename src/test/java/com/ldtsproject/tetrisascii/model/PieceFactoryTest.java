package com.ldtsproject.tetrisascii.model;

import com.ldtsproject.tetrisascii.model.game.blocks.piece.Piece;
import com.ldtsproject.tetrisascii.model.game.blocks.piece.PieceFactory;
import com.ldtsproject.tetrisascii.model.game.blocks.piece.PieceShape;
import com.ldtsproject.tetrisascii.model.game.blocks.piece.types.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PieceFactoryTest {

    private PieceFactory pieceFactory;

    @BeforeEach
    void setUp() {
        pieceFactory = new PieceFactory();
    }

    @Test
    void buildPieceShapeI() {
        Piece piece = pieceFactory.buildPiece(PieceShape.ISHAPE);
        assertTrue(piece instanceof IPiece);
    }

    @Test
    void buildPieceShapeJ() {
        Piece piece = pieceFactory.buildPiece(PieceShape.JSHAPE);
        assertTrue(piece instanceof JPiece);
    }

    @Test
    void buildPieceShapeL() {
        Piece piece = pieceFactory.buildPiece(PieceShape.LSHAPE);
        assertTrue(piece instanceof LPiece);
    }

    @Test
    void buildPieceShapeO() {
        Piece piece = pieceFactory.buildPiece(PieceShape.OSHAPE);
        assertTrue(piece instanceof OPiece);
    }

    @Test
    void
    buildPieceShapeS() {
        Piece piece = pieceFactory.buildPiece(PieceShape.SSHAPE);
        assertTrue(piece instanceof SPiece);
    }

    @Test
    void buildPieceShapeT() {
        Piece piece = pieceFactory.buildPiece(PieceShape.TSHAPE);
        assertTrue(piece instanceof TPiece);
    }

    @Test
    void buildPieceShapeZ() {
        Piece piece = pieceFactory.buildPiece(PieceShape.ZSHAPE);
        assertTrue(piece instanceof ZPiece);
    }
}