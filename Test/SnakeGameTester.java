import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;


public class SnakeGameTester {
    public SnakeGame snake;
    BoardPanel B;

    @Before
    public void setUp() throws Exception {
        snake = new SnakeGame();
        B = new BoardPanel(snake);
    }

    @Test
    public void testNull() {
        assertNotNull(snake);
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
    }

    @Test
    public void testClearBoard(){
        B.clearBoard();
    }
}
