package com.ldtsproject.tetrisascii.viewer;

import com.ldtsproject.tetrisascii.gui.GUI;
import com.ldtsproject.tetrisascii.model.leaderboard.Leaderboard;
import com.ldtsproject.tetrisascii.viewer.leaderboard.LeaderboardViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class LeaderboardViewerTest {
    private GUI gui;
    private LeaderboardViewer viewer;
    private Leaderboard leaderboard;

    @BeforeEach
    void setUp(){
        leaderboard = new Leaderboard();
        gui = Mockito.mock(GUI.class);
        viewer = new LeaderboardViewer(leaderboard);
    }

    @Test
    void refreshAndClear() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }
}

