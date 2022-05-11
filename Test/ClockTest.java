import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClockTest {
    public Clock c;
    @Before
    public void setUp() {
        c = new Clock(9.0F);
    }

    @Test
    public void peekElapsedCycleTest() {
        c.peekElapsedCycle();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void setCyclesPerSecond() {
        c.setCyclesPerSecond(8.0F);
    }

    @Test
    public void reset() {
        c.reset();
    }

    @Test
    public void update() {
    }

    @Test
    public void setPaused() {
    }

    @Test
    public void isPaused() {
    }

    @Test
    public void hasElapsedCycle() {
    }

    @Test
    public void peekElapsedCycle() {
    }

    @Test
    public void getCurrentTime() {
    }
}
