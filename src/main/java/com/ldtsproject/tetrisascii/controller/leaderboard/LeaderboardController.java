package com.ldtsproject.tetrisascii.controller.leaderboard;

import com.ldtsproject.tetrisascii.Application;
import com.ldtsproject.tetrisascii.controller.Controller;
import com.ldtsproject.tetrisascii.gui.GUI;
import com.ldtsproject.tetrisascii.model.leaderboard.Leaderboard;
import com.ldtsproject.tetrisascii.model.menu.Menu;
import com.ldtsproject.tetrisascii.model.sound.Sound;
import com.ldtsproject.tetrisascii.state.MenuState;

import java.io.IOException;

public class LeaderboardController extends Controller<Leaderboard> {
    public LeaderboardController(Leaderboard leaderboard) {
        super(leaderboard);
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT) {
            Sound.getInstance().stopMusic();
            application.setState(new MenuState(new Menu()));
        }
    }
}
