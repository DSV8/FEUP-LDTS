import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element {
    public Monster(int x, int y) {
        super(x, y);
    }

    public Monster(Position position) {
        super(position);
    }

    public Position move() {
        int random = new Random().nextInt(4);
        if (random == 0) {return new Position(position.getX(), position.getY() - 1);}
        else if (random == 1) {return new Position(position.getX() + 1, position.getY());}
        else if (random == 2) {return new Position(position.getX(), position.getY() + 1);}
        else {return new Position(position.getX() - 1, position.getY());}
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setCharacter(position.getX(), position.getY(), TextCharacter.fromCharacter('M')[0]);
        graphics.setBackgroundColor(TextColor.Factory.fromString("#888C8D"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#698362"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "M");
    }
}
