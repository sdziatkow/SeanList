import org.junit.Test;
import static org.junit.Assert.assertEquals;
import time.Timer;

public class TestTimer {
    private Timer time = new Timer();

    @Test
    public void testTimer() throws InterruptedException {
        time.startTimer();
        System.out.wait(1000);
        time.endTimer();
        long exp = 5;
        long act = time.timeElapsed();
        assertEquals(exp, act);
    }
}
