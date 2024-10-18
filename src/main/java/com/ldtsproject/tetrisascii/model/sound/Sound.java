package com.ldtsproject.tetrisascii.model.sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {
    private static Sound instance;
    private Clip musicClip;
    private Clip fxClip;
    private AudioInputStream music;
    private AudioInputStream effect;
    private String path;

    public enum TYPE{
        MUSIC,
        SOUND_EFFECTS
    }

    public static Sound getInstance() {
        if (instance == null) {
            instance = new Sound();
        }
        return instance;
    }

    private AudioInputStream loadSong() throws UnsupportedAudioFileException, IOException {
        return AudioSystem.getAudioInputStream(new File(path));
    }

    private Clip loadClip(TYPE type) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if (type == TYPE.MUSIC)
            music = loadSong();
        else if (type == TYPE.SOUND_EFFECTS)
            effect = loadSong();
        return AudioSystem.getClip();
    }

    private void playMusic() {
        try {
            musicClip = loadClip(TYPE.MUSIC);
            musicClip.open(music);
        }
        catch (UnsupportedAudioFileException | LineUnavailableException | IOException e){
            e.printStackTrace();
        }
        musicClip.start();

        musicClip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    private void playSoundFx() {
        try {
            fxClip = loadClip(TYPE.SOUND_EFFECTS);
            fxClip.open(effect);
        }
        catch (UnsupportedAudioFileException | LineUnavailableException | IOException e){
            e.printStackTrace();
        }
        fxClip.start();
    }

    public void playMainMenu() {
        path = "src/main/resources/music/mainMenu.wav";
        playMusic();
    }

    public void playGameTheme() {
        path = "src/main/resources/music/gameTheme.wav";
        playMusic();
    }

    public void playResults() {
        path = "src/main/resources/music/results.wav";
        playMusic();
    }

    public void playGameOver() {
        path = "src/main/resources/soundfx/gameOver.wav";
        playSoundFx();
    }

    public void playLineClear() {
        path = "src/main/resources/soundfx/lineClear.wav";
        playSoundFx();
    }

    public void stopMusic() {
        musicClip.stop();
        musicClip.close();
        try {
            music.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
