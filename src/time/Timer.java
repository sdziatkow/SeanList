package time;

public class Timer {
    public enum TimerState{GOING, STOPPED}
    private TimerState state;
    private Long startTime;
    private Long endTime;
    private Long timeElapsed;

    public Timer() {
        state = TimerState.STOPPED;
        startTime = null;
        endTime = null;
    }

    public void startTimer() {
        if (state == TimerState.STOPPED) {
            state = TimerState.GOING;
            startTime = System.currentTimeMillis();
        }
    }
    public void endTimer() {
        if (state == TimerState.GOING) {
            state = TimerState.STOPPED;
            endTime = System.currentTimeMillis();
            timeElapsed = endTime - startTime;
        }
    }
    public void clearTimer() {
        state = TimerState.STOPPED;
        startTime = null;
        endTime = null;
        timeElapsed = null;
    }
    public Long timeElapsed() {
        return timeElapsed;
    }
    public TimerState state() {
        return state;
    }
}
