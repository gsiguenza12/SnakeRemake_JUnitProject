import java.awt.event.KeyEvent;

import org.junit.jupiter.api.Test;

class SnakeGameTest {

    @Test
    void snakeGame() {
        SnakeGame g = new SnakeGame();

        // initializing thread to override model control
        main thread = new main(g);
        thread.start();

        // delay key press to start game.
        try
        {
            Thread.sleep(500);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

        // to circumvent dealing with EXIT_ON_CLOSE while (true) which disables testing while SnakeGame is active - we take advantage of the
        // KeyEvent from java awt to pass input to the keylistener in SnakeRemake, allows us to test the SnakeGame() method and updateSnake()

        // generating KeyEvent.VK_ENTER - Enter Key to start game
        KeyEvent key = new KeyEvent(g, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_ENTER);
        g.getKeyListeners()[0].keyPressed(key);

        // generating KeyEvent.VK_LEFT - simulating left key press
        key = new KeyEvent(g, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_LEFT);
        g.getKeyListeners()[0].keyPressed(key);

        // generating KeyEvent.VK_LEFT - simulating left key press
        key = new KeyEvent(g, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_RIGHT);
        g.getKeyListeners()[0].keyPressed(key);

        // generating KeyEvent.VK_LEFT - simulating left key press
        key = new KeyEvent(g, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_UP);
        g.getKeyListeners()[0].keyPressed(key);

        // generating KeyEvent.VK_LEFT - simulating left key press
        key = new KeyEvent(g, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_DOWN);
        g.getKeyListeners()[0].keyPressed(key);


        // delay key presses, allow seed time for remaining inputs to be processed.
        try
        {
            Thread.sleep(3000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

        // generating KeyEvent.VK_P - Pause
        key = new KeyEvent(g, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_P);
        g.getKeyListeners()[0].keyPressed(key);


    }

}

// extract main class from SnakeGame class to hand control to JUnitTest
class main extends Thread {
    private SnakeGame g;

    public main(SnakeGame g) {
        this.g = g;
    }

    public void run() {
        this.g.startGame();
    }
}

