import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    public Arena (int width, int height) {
        this.width = width;
        this.height = height;
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonsters();
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int c = 0; c < 10; c++) {
            Coin subst = new Coin(random.nextInt(width - 2) + 1,random.nextInt(height - 2) + 1);
            if (subst.getPosition().equals(hero.getPosition())) {
                c--;
                continue;
            }
            coins.add(subst);
        }
        return coins;
    }

    public void retrieveCoins() {
        for (Coin coin : coins) {
            if (coin.getPosition().equals(hero.getPosition()))
            {
                coins.remove(coin);
                break;
            }
        }
    }

    public List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int m = 0; m < 5; m++) {
            while (true) {
                Position pos = new Position(random.nextInt(width - 2) + 1,random.nextInt(height - 2) + 1);
                boolean overlaps = false;
                for (Coin coin : coins) {
                    if (coin.getPosition().equals(pos)) {overlaps = true; break;}
                }
                if (hero.getPosition().equals(pos)) {overlaps = true;}
                if (!overlaps) {monsters.add(new Monster(pos)); break;}
            }
        }
        return monsters;
    }

    public boolean heroDeath() {
        for (Monster monster: monsters) {
            if (hero.getPosition().equals(monster.getPosition())) {return true;}
        }
        return false;
    }

    public boolean endGame() {
        if (coins.size() == 0 || heroDeath()) {return true;}
        return false;
    }

    private int width;
    private int height;
    private Hero hero = new Hero(10,10);
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#888C8D"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(graphics);

        for (Monster monster : monsters)
            monster.draw(graphics);

        for (Coin coin : coins)
            coin.draw(graphics);

        for (Wall wall : walls)
            wall.draw(graphics);
    }

    public void moveHero(Position position) {
        if (canHeroMove(position)) {
            hero.setPosition(position);
            retrieveCoins();
        }
    }

    public boolean canHeroMove(Position position) {
        for (Wall wall : walls) {
            if (wall.getPosition().equals(position)) {return false;}
        }
        if ((position.getX() >= 0 && position.getX() <= width) && (position.getY() >= 0 && position.getY() <= height)) {return true;}
        return false;
    }

    public boolean canMonstersMove(Position position) {
        for (Wall wall : walls) {
            if (wall.getPosition().equals(position)) {return false;}
        }
        if ((position.getX() >= 0 && position.getX() <= width) && (position.getY() >= 0 && position.getY() <= height)) {return true;}
        return false;
    }



    public void processKey(KeyStroke key) {
        if ((key.getKeyType() == KeyType.ArrowUp) || (key.getKeyType() == KeyType.Character && key.getCharacter() == 'w')) {moveHero(hero.moveUp());}
        else if ((key.getKeyType() == KeyType.ArrowLeft) || (key.getKeyType() == KeyType.Character && key.getCharacter() == 'a')) {moveHero(hero.moveLeft());}
        else if ((key.getKeyType() == KeyType.ArrowDown) || (key.getKeyType() == KeyType.Character && key.getCharacter() == 's')) {moveHero(hero.moveDown());}
        else if ((key.getKeyType() == KeyType.ArrowRight) || (key.getKeyType() == KeyType.Character && key.getCharacter() == 'd')) {moveHero(hero.moveRight());}

        for (Monster monster : monsters) {
            while (true)
            {
                Position position = monster.move();
                if (canMonstersMove(position)) {monster.setPosition(position); break;}
            }
        }
    }
}
