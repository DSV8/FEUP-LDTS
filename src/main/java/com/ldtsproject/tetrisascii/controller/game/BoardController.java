package com.ldtsproject.tetrisascii.controller.game;

import com.ldtsproject.tetrisascii.Application;
import com.ldtsproject.tetrisascii.gui.GUI;
import com.ldtsproject.tetrisascii.model.game.Game;
import com.ldtsproject.tetrisascii.model.leaderboard.Leaderboard;
import com.ldtsproject.tetrisascii.model.menu.Menu;
import com.ldtsproject.tetrisascii.model.sound.Sound;
import com.ldtsproject.tetrisascii.state.MenuState;

import java.util.Scanner;

public class BoardController extends GameController {
    private final PieceController pieceController;

    public BoardController(Game game) {
        super(game);
        this.pieceController = new PieceController(game);
    }

    private void getUsername() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        assert username.length() <= 9;
        Leaderboard.getInstance().addScore(username, getBoard().getScore());
    }

    public void step(Application application, GUI.ACTION action, long time) {
        if (getBoard().isPieceStuck()) {
            Sound.getInstance().stopMusic();
            Sound.getInstance().playGameOver();
            getUsername();
            application.setState(new MenuState(new Menu()));
        }
        else if (action == GUI.ACTION.QUIT) {
            Sound.getInstance().stopMusic();
            application.setState(new MenuState(new Menu()));
        }
        else {
            pieceController.step(application, action, time);

            if (getBoard().pieceLands()) {
                getBoard().transferPieceToBoard();
                getBoard().spawnPiece();
            }

            getPanel().setNextPiece(getBoard().getNextPiece());

            if (getBoard().wereLinesCleared()) {
                Sound.getInstance().playLineClear();
                getPanel().setCurrentScore(String.valueOf(getBoard().getScore()));
                getBoard().setLinesWereClearedFalse();
            }

        }
    }
}