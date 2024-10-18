package com.ldtsproject.tetrisascii.viewer.menu;

import com.ldtsproject.tetrisascii.gui.GUI;
import com.ldtsproject.tetrisascii.model.Position;
import com.ldtsproject.tetrisascii.model.menu.Menu;
import com.ldtsproject.tetrisascii.viewer.Viewer;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    public void drawComponents(GUI gui) {
        gui.drawText(new Position(8, 7), "Menu", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(8, 9 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#850101" : "#FFFFFF");
    }
}
