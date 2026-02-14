package fromLecture;

import seanList.GenericAList;
import seanList.SeanList;
import time.Timer;

public class SpeedTestAList {
    public static void main(String[] args) {
        Timer time = new Timer();
        time.startTimer();

        SeanList<Integer> L = new GenericAList<>();
        int i = 0;
        while (i < 10000000) {
            L.addLast(i);
            i = i + 1;
        }

        time.endTimer();
        System.out.println("Total runtime: " + time.timeElapsed() + " ms");
    }
}
