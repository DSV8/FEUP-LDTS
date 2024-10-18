package com.ldtsproject.tetrisascii.viewer.game;


import com.ldtsproject.tetrisascii.model.Position;
import com.ldtsproject.tetrisascii.model.game.Game;
import com.ldtsproject.tetrisascii.gui.GUI;
import com.ldtsproject.tetrisascii.viewer.Viewer;

public class GameViewer extends Viewer<Game> {
    private final BoardViewer boardViewer;
    private final PanelViewer panelViewer;
    public GameViewer(Game game) {
        super(game);
        boardViewer = new BoardViewer(game.board());
        panelViewer = new PanelViewer(game.panel());
    }

    @Override
    public void drawComponents(GUI gui) {
        if (getModel().board().isPieceStuck()){
            gui.drawText(new Position(7, 10), "Game Over", "#FFFFFF");
        }
        else {
            boardViewer.drawComponents(gui);
            panelViewer.drawComponents(gui);
        }
    }
}
