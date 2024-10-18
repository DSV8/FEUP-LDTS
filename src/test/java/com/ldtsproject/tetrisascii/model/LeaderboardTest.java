package com.ldtsproject.tetrisascii.model;

import com.ldtsproject.tetrisascii.model.leaderboard.Leaderboard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class LeaderboardTest {
    private Leaderboard leaderboard;

    @BeforeEach
    public void setUp() {
        leaderboard = Leaderboard.getInstance();
    }

    @Test
    public void testGetInstance() {
        Leaderboard leaderboard1 = Leaderboard.getInstance();
        Leaderboard leaderboard2 = Leaderboard.getInstance();
        assertSame(leaderboard1, leaderboard2);
    }

    @Test
    public void testGetPlayersScore() {
        HashMap<String, Integer> playersScore = leaderboard.getPlayersScore();
        assertNotNull(playersScore);
        assertTrue(true);
    }

    @Test
    public void testAddScore() {
        leaderboard.addScore("player1", 10);
        assertEquals(10, (int) leaderboard.getPlayersScore().get("player1"));
        leaderboard.addScore("player1", 20);
        assertEquals(20, (int) leaderboard.getPlayersScore().get("player1"));
        leaderboard.addScore("player1", 5);
        assertEquals(20, (int) leaderboard.getPlayersScore().get("player1"));
        leaderboard.addScore("player2", 30);
        assertEquals(30, (int) leaderboard.getPlayersScore().get("player2"));
    }

    @Test
    public void testSortByScores() {
        leaderboard.addScore("player1", 10);
        leaderboard.addScore("player2", 20);
        leaderboard.addScore("player3", 15);
        leaderboard.sortByScores();
        assertEquals("player2", leaderboard.getPlayersScore().keySet().toArray()[0]);
        assertEquals("player3", leaderboard.getPlayersScore().keySet().toArray()[1]);
        assertEquals("player1", leaderboard.getPlayersScore().keySet().toArray()[2]);
    }
}
