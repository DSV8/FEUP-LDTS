package com.ldtsproject.tetrisascii.gui;

import com.ldtsproject.tetrisascii.model.Position;
import com.ldtsproject.tetrisascii.model.game.Panel;
import com.ldtsproject.tetrisascii.model.game.blocks.Block;

import java.io.IOException;
import java.util.Collection;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawPanel(Panel panel);
    void drawBlockCollection(Collection<Block> blocks);
    void drawText(Position position, String text, String color);

    void clear();
    void refresh() throws IOException;
    void close() throws IOException;

    enum ACTION {NONE, UP, RIGHT, DOWN, LEFT, QUIT, ENTER, Z}
}
