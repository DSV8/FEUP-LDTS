package com.ldtsproject.tetrisascii;

import com.ldtsproject.tetrisascii.gui.LanternaGUI;
import com.ldtsproject.tetrisascii.model.leaderboard.Leaderboard;
import com.ldtsproject.tetrisascii.model.menu.Menu;
import com.ldtsproject.tetrisascii.state.MenuState;
import com.ldtsproject.tetrisascii.state.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Application {
    private final LanternaGUI gui;
    private State state;

    public Application() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(23, 20);
        this.state = new MenuState(new Menu());
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException, InterruptedException {
        new Application().start();
    }

    public void setState(State state) {
        this.state = state;
    }

    private void start() throws IOException, InterruptedException {
        Leaderboard.getInstance().restoreLeaderboard();

        int FPS = 60;

        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            if (sleepTime > 0) Thread.sleep(sleepTime);
        }
        gui.close();
    }

    public State getState() {
        return state;
    }
}
