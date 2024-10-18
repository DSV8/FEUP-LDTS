package com.ldtsproject.tetrisascii.viewer.game;

import com.ldtsproject.tetrisascii.gui.GUI;
import com.ldtsproject.tetrisascii.model.game.Panel;
import com.ldtsproject.tetrisascii.viewer.Viewer;

public class PanelViewer extends Viewer<Panel> {
    public PanelViewer(Panel panel) {
        super(panel);
    }
    @Override
    public void drawComponents(GUI gui) {
        gui.drawPanel(getModel());
    }
}
