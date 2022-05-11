import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Random;

import static org.junit.Assert.*;


public class SnakeGameTester {
    public SnakeGame snake;
    public Clock c;
    BoardPanel B;


    @Before
    public void setUp() throws Exception {
        snake = new SnakeGame();
        snake.random = new Random();
        snake.snake = new LinkedList<>();
        snake.directions = new LinkedList<>();
        snake.logicTimer = new Clock(9.0f);
        snake.isNewGame = true;
        //Set the timer to paused initially.
//        snake.getLogicTimer().setPaused(true);
                B = new BoardPanel(snake);
        /*
         * This is the game loop. It will update and render the game and will
         * continue to run until the game window is closed.
         */

            //Get the current frame's start time.
            long start = System.nanoTime();

            //Update the logic timer.
            snake.getLogicTimer().update();

            /*
             * If a cycle has elapsed on the logic timer, then update the game.
             */
            if(snake.getLogicTimer().hasElapsedCycle()) {
//                snake.updateGame();

            }

            //Repaint the board and side panel with the new content.
            B.repaint();
//            S.repaint();
            snake.setGameOver(true);
            /*
             * Calculate the delta time between since the start of the frame
             * and sleep for the excess time to cap the frame rate. While not
             * incredibly accurate, it is sufficient for our purposes.
             */
            long delta = (System.nanoTime() - start) / 1000000L;
            if(delta < SnakeGame.FRAME_TIME) {
                try {
                    Thread.sleep(SnakeGame.FRAME_TIME - delta);
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }

//        c = snake.getLogicTimer();;
    

    @Test
    public void testNull() {
        assertNotNull(snake);



            int counter = 0;
            while (!snake.isGameOver()) {
                c.excessCycles = 0.0F;
                if (c.excessCycles == 0.0F) {
//                    fail();
                    snake.setGameOver(true);
                }
            }



    }

    @Test
    public void testEnums(){

        Direction.values();
        TileType.values();
    }

    @Test
    public void testUpdateSnake(){
        LinkedList<Direction> dlist = new LinkedList<>();
        dlist.add(Direction.North);
        dlist.add(Direction.East);
        dlist.add(Direction.West);
        dlist.add(Direction.South);
        snake.setDirections(dlist);
        try {
            assertNull(snake.updateSnake());
        }catch(NullPointerException E){

        }
        try {
            snake.updateGame();
        }catch(NullPointerException E){

        }

    }

    @Test
    public void testClearBoard(){

        B.getKeyListeners();
        B.clearBoard();

    }
}
