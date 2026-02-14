package fromLecture;

import seanList.GenericSList;
import seanList.SeanList;
import time.Timer;

public class SpeedTestSList {
    public static void main(String[] args) {
        Timer time = new Timer();
        time.startTimer();

        SeanList<Integer> L = new GenericSList<>();
        int i = 0;
        while (i < 10000000) {
            L.addFirst(i);
            i = i + 1;
        }

        time.endTimer();
        System.out.println("Total runtime: " + time.timeElapsed() + " ms");
    }
}
