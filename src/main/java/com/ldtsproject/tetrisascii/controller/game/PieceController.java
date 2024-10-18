package com.ldtsproject.tetrisascii.controller.game;

import com.ldtsproject.tetrisascii.Application;
import com.ldtsproject.tetrisascii.gui.GUI;
import com.ldtsproject.tetrisascii.model.game.Game;
import com.ldtsproject.tetrisascii.model.game.blocks.Block;

import java.util.ArrayList;

public class PieceController extends GameController {
    private long lastMovement;

    public PieceController(Game game) {
        super(game);

        this.lastMovement = 0;
    }

    public void movePieceLeft() {
        movePiece(getBoard().getPiece().getLeft());
    }
    public void movePieceRight() {
        movePiece(getBoard().getPiece().getRight());
    }
    public void movePieceDown() {
        movePiece(getBoard().getPiece().getDown());
    }
    public void rotatePieceRight() {
        if (getBoard().getPiece().rotates())
            movePiece(getBoard().getPiece().getRightRotation());
    }
    public void rotatePieceLeft() {
        if (getBoard().getPiece().rotates())
            movePiece(getBoard().getPiece().getLeftRotation());
    }

    private void dropPiece() {
        getBoard().dropBlocks(getBoard().getPiece());
    }

    private void movePiece(ArrayList<Block> blocks) {
        if (getBoard().canBlocksMove(blocks)) {
            getBoard().moveBlocks(blocks, getBoard().getPiece());
        }
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) {
        if (time - lastMovement > 750) {
            movePieceDown();
            this.lastMovement = time;
        }
        else if (action != GUI.ACTION.NONE){
            if (action == GUI.ACTION.RIGHT) movePieceRight();
            if (action == GUI.ACTION.DOWN) movePieceDown();
            if (action == GUI.ACTION.LEFT) movePieceLeft();

            if (action == GUI.ACTION.UP) rotatePieceRight();
            if (action == GUI.ACTION.Z) rotatePieceLeft();

            if (action == GUI.ACTION.ENTER) dropPiece();
        }
    }
}
