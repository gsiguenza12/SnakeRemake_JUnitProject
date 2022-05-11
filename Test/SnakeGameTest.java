import static org.junit.jupiter.api.Assertions.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import com.sun.tools.javac.Main;
import org.junit.jupiter.api.Test;

class SnakeGameTest {

    @Test
    void snakeGame() {
        SnakeGame g = new SnakeGame();
        main thread = new main(g);
        thread.start();
        try
        {
            Thread.sleep(500);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

        KeyEvent key = new KeyEvent(g, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_ENTER);
        g.getKeyListeners()[0].keyPressed(key);

        key = new KeyEvent(g, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_LEFT);
        g.getKeyListeners()[0].keyPressed(key);

        try
        {
            Thread.sleep(3000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

        key = new KeyEvent(g, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_P);
        g.getKeyListeners()[0].keyPressed(key);

    }

}

class main extends Thread {
    private SnakeGame game;

    public main(SnakeGame game) {
        this.game = game;
    }

    public void run() {
        this.game.startGame();
    }
}

