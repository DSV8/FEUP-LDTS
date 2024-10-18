package com.ldtsproject.tetrisascii.state;

import com.ldtsproject.tetrisascii.Application;
import com.ldtsproject.tetrisascii.controller.game.BoardController;
import com.ldtsproject.tetrisascii.controller.game.GameController;
import com.ldtsproject.tetrisascii.controller.leaderboard.LeaderboardController;
import com.ldtsproject.tetrisascii.controller.menu.MenuController;
import com.ldtsproject.tetrisascii.gui.GUI;
import com.ldtsproject.tetrisascii.model.game.Panel;
import com.ldtsproject.tetrisascii.model.game.Board;
import com.ldtsproject.tetrisascii.model.game.Game;
import com.ldtsproject.tetrisascii.model.leaderboard.Leaderboard;
import com.ldtsproject.tetrisascii.model.menu.Menu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class StatesTest {
    GameController gameController;
    LeaderboardController leaderboardController;
    MenuController menuController;
    Menu menu;
    Game game;
    Board board;
    Panel panel;
    Application application;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        application = new Application();
        menu = new Menu();
        board = new Board(23, 20);
        panel = new Panel(10, 20);
        game = new Game(board, panel);
        menuController = new MenuController(menu);
        gameController = new BoardController(game);
        leaderboardController = new LeaderboardController(Leaderboard.getInstance());
    }

    @AfterEach
    void after(){
        application.setState(new MenuState(new Menu()));
        menu = null;
        menuController = null;
    }


    @Test
    void actionDown() throws IOException {
        menuController.step(application, GUI.ACTION.DOWN, 0);
        Assertions.assertTrue(menuController.getModel().isSelectedLeaderboard());
    }

    @Test
    void actionUp() throws IOException {
        menuController.step(application, GUI.ACTION.UP, 0);
        Assertions.assertTrue(menuController.getModel().isSelectedExit());
    }

    @Test
    void actionExit() throws IOException {
        menuController.step(application, GUI.ACTION.DOWN, 0);
        menuController.step(application, GUI.ACTION.DOWN, 0);
        menuController.step(application, GUI.ACTION.ENTER, 0);
        Assertions.assertNull(application.getState());
    }

    @Test
    void actionSelect() throws IOException {
        menuController.step(application, GUI.ACTION.DOWN, 0);
        menuController.step(application, GUI.ACTION.ENTER, 0);
        Assertions.assertEquals(com.ldtsproject.tetrisascii.state.LeaderboardState.class, application.getState().getClass());
    }

    @Test
    void menuToGameToMenu() throws IOException {
        menuController.step(application, GUI.ACTION.ENTER, 0);
        Assertions.assertEquals(com.ldtsproject.tetrisascii.state.GameState.class, application.getState().getClass());
        gameController.step(application, GUI.ACTION.QUIT, 0);
        Assertions.assertEquals(com.ldtsproject.tetrisascii.state.MenuState.class, application.getState().getClass());
    }

    @Test
    void menuToLeaderboardToMenu() throws IOException {
        menuController.step(application, GUI.ACTION.DOWN, 0);
        menuController.step(application, GUI.ACTION.ENTER, 0);
        Assertions.assertEquals(com.ldtsproject.tetrisascii.state.LeaderboardState.class, application.getState().getClass());
        leaderboardController.step(application, GUI.ACTION.QUIT, 0);
        Assertions.assertEquals(com.ldtsproject.tetrisascii.state.MenuState.class, application.getState().getClass());
    }
}