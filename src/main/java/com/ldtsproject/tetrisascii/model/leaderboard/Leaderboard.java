package com.ldtsproject.tetrisascii.model.leaderboard;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Leaderboard {
    private static Leaderboard instance;
    private final LinkedHashMap<String, Integer> playersScore;

    public Leaderboard() {
        playersScore = new LinkedHashMap<>();
    }

    public static Leaderboard getInstance() {
        if (instance == null) {
            instance = new Leaderboard();
        }
        return instance;
    }

    public HashMap<String, Integer> getPlayersScore() {
        return playersScore;
    }

    public void addScore(String username, Integer score) {
        if (playersScore.containsKey(username)) {
            if (score > playersScore.get(username))
                playersScore.replace(username, score);
        }
        else {
            playersScore.put(username, score);
        }
        sortByScores();
    }

    public void sortByScores() {
        ArrayList<Entry<String, Integer>> entryList = new ArrayList<>(playersScore.entrySet());
        entryList.sort(Entry.<String, Integer>comparingByValue().reversed());

        playersScore.clear();

        for (Entry<String, Integer> entry : entryList) {
            playersScore.put(entry.getKey(), entry.getValue());
        }
    }

    public void restoreLeaderboard() throws IOException {
        BufferedReader reader
                = new BufferedReader(new FileReader("src/main/resources/leaderboard/leaderboard.txt"));
        String line;

        while((line = reader.readLine()) != null) {
            String[] parts = line.split(" : ");

            String username = parts[0].trim();
            String score = parts[1].trim();

            if (!username.equals("") && !score.equals(""))
                playersScore.put(username, Integer.parseInt(score));
        }
    }

    public void saveLeaderboard() throws IOException {
        BufferedWriter writer
                = new BufferedWriter(new FileWriter("src/main/resources/leaderboard/leaderboard.txt"));

        for (HashMap.Entry<String, Integer> entry : playersScore.entrySet()) {
            writer.write(entry.getKey() + " : " + entry.getValue() + "\n");
        }

        writer.close();
    }
}
