package com.ldtsproject.tetrisascii.state;

import com.ldtsproject.tetrisascii.controller.Controller;
import com.ldtsproject.tetrisascii.controller.menu.MenuController;
import com.ldtsproject.tetrisascii.model.menu.Menu;
import com.ldtsproject.tetrisascii.model.sound.Sound;
import com.ldtsproject.tetrisascii.viewer.Viewer;
import com.ldtsproject.tetrisascii.viewer.menu.MenuViewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
        Sound.getInstance().playMainMenu();
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
