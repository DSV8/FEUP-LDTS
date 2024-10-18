package com.ldtsproject.tetrisascii.controller;

import com.ldtsproject.tetrisascii.controller.menu.MenuController;
import com.ldtsproject.tetrisascii.gui.GUI;
import com.ldtsproject.tetrisascii.model.menu.Menu;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuControllerTest {
    @Test
    public void testStepUpAction() throws IOException {
        Menu menu = Mockito.mock(Menu.class);

        MenuController menuController = new MenuController(menu);

        menuController.step(null, GUI.ACTION.UP, 0);

        Mockito.verify(menu).previousEntry();
    }

    @Test
    public void testStepDownAction() throws IOException {
        Menu menu = Mockito.mock(Menu.class);

        MenuController menuController = new MenuController(menu);

        menuController.step(null, GUI.ACTION.DOWN, 0);

        Mockito.verify(menu).nextEntry();
    }
}
