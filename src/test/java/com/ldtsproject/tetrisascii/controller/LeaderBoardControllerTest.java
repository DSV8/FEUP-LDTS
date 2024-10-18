package com.ldtsproject.tetrisascii.controller;

import com.ldtsproject.tetrisascii.Application;
import com.ldtsproject.tetrisascii.controller.leaderboard.LeaderboardController;
import com.ldtsproject.tetrisascii.gui.GUI;
import com.ldtsproject.tetrisascii.model.leaderboard.Leaderboard;
import com.ldtsproject.tetrisascii.state.MenuState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LeaderBoardControllerTest {
    Application application;
    LeaderboardController leaderboardController;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        application = new Application();
        leaderboardController = new LeaderboardController(Leaderboard.getInstance());
    }

    @Test
    public void testStepQuitAction() throws IOException {
        leaderboardController.step(application, GUI.ACTION.QUIT, 0);
        Assertions.assertEquals(com.ldtsproject.tetrisascii.state.MenuState.class, application.getState().getClass());
    }
}
