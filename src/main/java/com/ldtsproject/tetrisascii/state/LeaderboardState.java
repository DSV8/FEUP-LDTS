package com.ldtsproject.tetrisascii.state;

import com.ldtsproject.tetrisascii.controller.Controller;
import com.ldtsproject.tetrisascii.controller.leaderboard.LeaderboardController;
import com.ldtsproject.tetrisascii.model.leaderboard.Leaderboard;
import com.ldtsproject.tetrisascii.model.sound.Sound;
import com.ldtsproject.tetrisascii.viewer.Viewer;
import com.ldtsproject.tetrisascii.viewer.leaderboard.LeaderboardViewer;

public class LeaderboardState extends State<Leaderboard> {
    public LeaderboardState(Leaderboard model) {
        super(model);
        Sound.getInstance().playResults();
    }

    @Override
    protected Viewer<Leaderboard> getViewer() {
        return new LeaderboardViewer(getModel());
    }

    @Override
    protected Controller<Leaderboard> getController() {
        return new LeaderboardController(getModel());
    }
}
