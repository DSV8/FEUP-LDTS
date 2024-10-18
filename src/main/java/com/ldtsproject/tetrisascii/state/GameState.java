package com.ldtsproject.tetrisascii.state;

import com.ldtsproject.tetrisascii.controller.Controller;
import com.ldtsproject.tetrisascii.controller.game.BoardController;
import com.ldtsproject.tetrisascii.model.game.Game;
import com.ldtsproject.tetrisascii.model.sound.Sound;
import com.ldtsproject.tetrisascii.viewer.Viewer;
import com.ldtsproject.tetrisascii.viewer.game.GameViewer;

public class GameState extends State<Game> {
    public GameState(Game game) {
        super(game);
        Sound.getInstance().playGameTheme();
    }

    @Override
    protected Viewer<Game> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Game> getController() {
        return new BoardController(getModel());
    }
}
