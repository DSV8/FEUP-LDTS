package com.ldtsproject.tetrisascii.viewer.leaderboard;

import com.ldtsproject.tetrisascii.gui.GUI;
import com.ldtsproject.tetrisascii.model.leaderboard.Leaderboard;
import com.ldtsproject.tetrisascii.model.Position;
import com.ldtsproject.tetrisascii.viewer.Viewer;

import java.util.HashMap;

public class LeaderboardViewer extends Viewer<Leaderboard>  {
    public LeaderboardViewer(Leaderboard leaderboard) {
        super(leaderboard);
    }

    @Override
    public void drawComponents(GUI gui) {
        gui.drawText(new Position(5, 3), "Leaderboard", "#FFFFFF");
        int i = 1;
        for (HashMap.Entry<String, Integer> entry : getModel().getPlayersScore().entrySet()) {
            gui.drawText(new Position(1, 4 + i), "#" + i, "#FFFFFF");
            gui.drawText(new Position(5, 4 + i), entry.getKey(), "#FFFFFF");
            gui.drawText(new Position(15, 4 + i), String.valueOf(entry.getValue()), "#FFFFFF");
            i++;
        }
    }
}
