package com.ldtsproject.tetrisascii.controller.menu;

import com.ldtsproject.tetrisascii.Application;
import com.ldtsproject.tetrisascii.controller.Controller;
import com.ldtsproject.tetrisascii.gui.GUI;
import com.ldtsproject.tetrisascii.model.game.Board;
import com.ldtsproject.tetrisascii.model.game.Game;
import com.ldtsproject.tetrisascii.model.game.Panel;
import com.ldtsproject.tetrisascii.model.leaderboard.Leaderboard;
import com.ldtsproject.tetrisascii.model.menu.Menu;
import com.ldtsproject.tetrisascii.model.sound.Sound;
import com.ldtsproject.tetrisascii.state.GameState;
import com.ldtsproject.tetrisascii.state.LeaderboardState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP -> getModel().previousEntry();
            case DOWN -> getModel().nextEntry();
            case ENTER -> {
                Sound.getInstance().stopMusic();
                if (getModel().isSelectedStart()) {
                    application.setState(new GameState(new Game(new Board(10, 20), new Panel(11, 20))));
                }
                else if (getModel().isSelectedLeaderboard()) {
                    application.setState(new LeaderboardState(Leaderboard.getInstance()));
                }
                else if (getModel().isSelectedExit()) {
                    Leaderboard.getInstance().saveLeaderboard();
                    application.setState(null);
                }
            }
        }
    }
}
