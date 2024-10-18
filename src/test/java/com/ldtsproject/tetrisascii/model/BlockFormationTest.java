package com.ldtsproject.tetrisascii.model;

import com.ldtsproject.tetrisascii.model.game.blocks.Block;
import com.ldtsproject.tetrisascii.model.game.blocks.BlockFormation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BlockFormationTest {
    @Test
    void getUp() {
        Block block1 = mock(Block.class);
        Block block2 = mock(Block.class);
        Block block3 = mock(Block.class);
        Block block4 = mock(Block.class);

        Block upBlock1 = mock(Block.class);
        Block upBlock2 = mock(Block.class);
        Block upBlock3 = mock(Block.class);
        Block upBlock4 = mock(Block.class);

        when(block1.getUp()).thenReturn(upBlock1);
        when(block2.getUp()).thenReturn(upBlock2);
        when(block3.getUp()).thenReturn(upBlock3);
        when(block4.getUp()).thenReturn(upBlock4);

        ArrayList<Block> blocks = new ArrayList<>(Arrays.asList(block1, block2, block3, block4));

        BlockFormation blockFormation = new BlockFormation();
        blockFormation.setBlocks(blocks);

        ArrayList<Block> result = blockFormation.getUp();

        assertEquals(4, result.size());
        assertEquals(upBlock1, result.get(0));
        assertEquals(upBlock2, result.get(1));
        assertEquals(upBlock3, result.get(2));
        assertEquals(upBlock4, result.get(3));
    }

    @Test
    void getDown() {
        Block block1 = mock(Block.class);
        Block block2 = mock(Block.class);
        Block block3 = mock(Block.class);
        Block block4 = mock(Block.class);

        Block downBlock1 = mock(Block.class);
        Block downBlock2 = mock(Block.class);
        Block downBlock3 = mock(Block.class);
        Block downBlock4 = mock(Block.class);

        when(block1.getDown()).thenReturn(downBlock1);
        when(block2.getDown()).thenReturn(downBlock2);
        when(block3.getDown()).thenReturn(downBlock3);
        when(block4.getDown()).thenReturn(downBlock4);

        ArrayList<Block> blocks = new ArrayList<>(Arrays.asList(block1, block2, block3, block4));

        BlockFormation blockFormation = new BlockFormation();
        blockFormation.setBlocks(blocks);

        ArrayList<Block> result = blockFormation.getDown();

        assertEquals(4, result.size());
        assertTrue(result.containsAll(Arrays.asList(downBlock1, downBlock2, downBlock3, downBlock4)));
    }

    @Test
    void getRight() {
        Block block1 = mock(Block.class);
        Block block2 = mock(Block.class);
        Block block3 = mock(Block.class);
        Block block4 = mock(Block.class);

        Block rightBlock1 = mock(Block.class);
        Block rightBlock2 = mock(Block.class);
        Block rightBlock3 = mock(Block.class);
        Block rightBlock4 = mock(Block.class);

        when(block1.getRight()).thenReturn(rightBlock1);
        when(block2.getRight()).thenReturn(rightBlock2);
        when(block3.getRight()).thenReturn(rightBlock3);
        when(block4.getRight()).thenReturn(rightBlock4);

        ArrayList<Block> blocks = new ArrayList<>(Arrays.asList(block1, block2, block3, block4));

        BlockFormation formation = new BlockFormation();
        formation.setBlocks(blocks);

        ArrayList<Block> result = formation.getRight();

        assertEquals(4, result.size());
        assertEquals(rightBlock1, result.get(0));
        assertEquals(rightBlock2, result.get(1));
        assertEquals(rightBlock3, result.get(2));
        assertEquals(rightBlock4, result.get(3));
    }

    @Test
    void getLeft() {
        Block block1 = mock(Block.class);
        Block block2 = mock(Block.class);
        Block block3 = mock(Block.class);
        Block block4 = mock(Block.class);

        Block left1 = mock(Block.class);
        Block left2 = mock(Block.class);
        Block left3 = mock(Block.class);
        Block left4 = mock(Block.class);

        when(block1.getLeft()).thenReturn(left1);
        when(block2.getLeft()).thenReturn(left2);
        when(block3.getLeft()).thenReturn(left3);
        when(block4.getLeft()).thenReturn(left4);

        ArrayList<Block> blocks = new ArrayList<>(Arrays.asList(block1, block2, block3, block4));

        BlockFormation blockFormation = new BlockFormation();
        blockFormation.setBlocks(blocks);

        ArrayList<Block> result = blockFormation.getLeft();

        assertEquals(4, result.size());
        assertTrue(result.containsAll(Arrays.asList(left1, left2, left3, left4)));
    }
}