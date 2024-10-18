package com.ldtsproject.tetrisascii.controller.game;

import com.ldtsproject.tetrisascii.controller.Controller;
import com.ldtsproject.tetrisascii.model.game.Board;
import com.ldtsproject.tetrisascii.model.game.Game;
import com.ldtsproject.tetrisascii.model.game.Panel;

public abstract class GameController extends Controller<Game> {
    public GameController(Game game) {
        super(game);
    }

    public Board getBoard() {
        return getModel().board();
    }

    public Panel getPanel() {
        return getModel().panel();
    }
}
