package com.ldtsproject.tetrisascii.model.game;

import com.ldtsproject.tetrisascii.model.Position;
import com.ldtsproject.tetrisascii.model.game.blocks.piece.Piece;
import com.ldtsproject.tetrisascii.model.game.blocks.piece.PieceFactory;
import com.ldtsproject.tetrisascii.model.game.blocks.piece.PieceShape;
import com.ldtsproject.tetrisascii.model.game.blocks.Block;
import com.ldtsproject.tetrisascii.model.game.blocks.BlockFormation;

import java.util.*;
import java.util.stream.Collectors;

public class Board {
    private final int width;
    private final int height;
    private boolean pieceIsStuck;
    private boolean linesWereCleared;
    private final PieceFactory pieceFactory;
    private final Position spawnPosition;
    private final LinkedList<Integer> shapeBag;
    private Piece piece;
    private Piece nextPiece;
    private final HashMap<Integer, TreeSet<Block>> landedBlocks;
    private int score;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        pieceIsStuck = false;
        linesWereCleared = false;
        pieceFactory = new PieceFactory();
        spawnPosition = new Position((width/2)-1,1);
        shapeBag = new LinkedList<>(Arrays.asList(0,1,2,3,4,5,6));
        landedBlocks = new HashMap<>();
        score = 0;

        spawnPiece();
    }

    public PieceFactory getPieceFactory(){
        return pieceFactory;
    }
    public Piece getPiece(){
        return piece;
    }
    public Piece getNextPiece(){
        return nextPiece;
    }   public HashMap<Integer, TreeSet<Block>> getLandedBlocks() {
        return landedBlocks;
    }
    public int getScore() {
        return score;
    }
    public boolean isPieceStuck() {
        return pieceIsStuck;
    }
    public boolean wereLinesCleared() {
        return linesWereCleared;
    }
    public void setLinesWereClearedFalse(){
        linesWereCleared = false;
    }

    public void spawnPiece() {
        createPiece();
        createNextPiece();

        if (!canBlocksMove(piece.getBlocks()))
            pieceIsStuck = true;
    }

    private void createNextPiece() {
        int nextShape;

        if (shapeBag.isEmpty()) {
            fillBag();
            nextShape = shapeBag.get(1);
        }
        else nextShape = shapeBag.get(0);

        nextPiece = pieceFactory.buildPiece(PieceShape.values()[nextShape]);
        nextPiece.addSpawnPosition(new Position(16, 14));
    }

    private void createPiece() {
        int newShape = shapeBag.get(0);
        piece = pieceFactory.buildPiece(PieceShape.values()[newShape]);
        piece.addSpawnPosition(spawnPosition);
        shapeBag.remove(0);
    }

    private void fillBag() {
        shapeBag.addAll(Arrays.asList(0,1,2,3,4,5,6));
        Collections.shuffle(shapeBag);
    }

    public void moveBlocks(ArrayList<Block> newBlocks, BlockFormation blocks){
        blocks.setBlocks(newBlocks);
    }

    public void dropBlocks(BlockFormation blocks) {
        while (canBlocksMove(blocks.getDown()))
            moveBlocks(blocks.getDown(), blocks);
    }

    public boolean canBlocksMove(ArrayList<Block> possibleBlocks) {
        for (Block block : possibleBlocks) {
            if (!blockInBounds(block) || blockColides(block))
                return false;
        }
        return true;
    }
    private boolean blockInBounds(Block block) {
        return (block.getX() >= 0 && block.getX() < width) && (block.getY() >= 0 && block.getY() < height);
    }
    private boolean blockColides(Block block) {
        TreeSet<Block> blocks = landedBlocks.get(block.getY());

        if (blocks != null)
            return blocks.contains(block);
        return false;
    }

    public boolean pieceLands() {
        ArrayList<Block> blocksBelow = piece.getDown();

        for (Block block : blocksBelow) {
            boolean blockHitsGround = block.getY() == height;
            if (blockHitsGround || blockColides(block))
                return true;
        }
        return false;
    }

    public void transferPieceToBoard() {
        transferBlocksToBoard(piece);
    }

    public void transferBlocksToBoard(BlockFormation blockFormation) {
        ArrayList<Integer> blocksToClear = new ArrayList<>();

        for (Block block : blockFormation.getBlocks()) {
            int blockY = block.getY();

            if (landedBlocks.containsKey(blockY)) {
                TreeSet<Block> blocks = landedBlocks.get(blockY);
                blocks.add(block);

                boolean isFull = blocks.size() == width;
                if (isFull) blocksToClear.add(blockY);
            }
            else {
                TreeSet<Block> blocks = new TreeSet<>();
                blocks.add(block);
                landedBlocks.put(blockY, blocks);
            }
        }
        if (!blocksToClear.isEmpty())
            clearBlocks(blocksToClear);
    }

    private void clearBlocks(ArrayList<Integer> blocksToClear) {
        increaseScore(blocksToClear.size());

        int minBlockY = Collections.min(blocksToClear);
        blocksToClear.forEach(landedBlocks.keySet()::remove);
        adjustLandedBlocks(minBlockY);

        linesWereCleared = true;
    }

    private void increaseScore(int numberOfLinesCleared) {
        switch (numberOfLinesCleared) {
            case 1 -> score += 40;
            case 2 -> score += 100;
            case 3 -> score += 300;
            case 4 -> score += 1200;
        }
    }

    private void adjustLandedBlocks(int blockY) {
        Map<Integer, TreeSet<Block>> filteredBlocks = filterByHeight(blockY);
        filteredBlocks.forEach(landedBlocks::remove);
        BlockFormation blockFormation = blocksToBlockFormation(filteredBlocks);
        dropBlocks(blockFormation);
        transferBlocksToBoard(blockFormation);
    }

    private Map<Integer, TreeSet<Block>> filterByHeight(int blockY) {
        Map<Integer, TreeSet<Block>> filteredBlocks = landedBlocks.entrySet()
                .stream()
                .filter(map -> map.getKey() < blockY)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return filteredBlocks;
    }

    private BlockFormation blocksToBlockFormation(Map<Integer, TreeSet<Block>> filteredBlocks) {
        BlockFormation blockFormation = new BlockFormation();
        TreeSet<Block> blockSet = new TreeSet<>();

        for (TreeSet<Block> blocks : filteredBlocks.values()) {
            blockSet.addAll(blocks);
        }

        blockFormation.setBlocks(new ArrayList<>(blockSet));
        return blockFormation;
    }
}
