package fromLecture;

import seanList.GenericAList;
import seanList.SeanList;

public class SpeedTestAList {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        SeanList<Integer> L = new GenericAList<>();
        int i = 0;
        while (i < 10000000) {
            L.addFirst(i);
            i = i + 1;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total runtime: "
                + (endTime - startTime) + " ms");
    }
}
