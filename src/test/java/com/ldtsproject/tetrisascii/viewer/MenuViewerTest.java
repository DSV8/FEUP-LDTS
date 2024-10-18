package com.ldtsproject.tetrisascii.viewer;

import com.ldtsproject.tetrisascii.gui.GUI;
import com.ldtsproject.tetrisascii.model.menu.Menu;
import com.ldtsproject.tetrisascii.viewer.menu.MenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class MenuViewerTest {
    private GUI gui;
    private MenuViewer viewer;
    private Menu menu;

    @BeforeEach
    void setUp(){
        menu = new Menu();
        gui = Mockito.mock(GUI.class);
        viewer = new MenuViewer(menu);
    }

    @Test
    void refreshAndClear() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }
}
