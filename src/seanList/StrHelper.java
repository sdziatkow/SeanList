package seanList;

public class StrHelper {

    /** Will be used to determine which order to sort a given String or list of Strings. */
    public enum SortOrder {ASC, DESC}
    private static SortOrder order;

    /**
     * Will compare given strings s1 and s2.
     * If s1 is smaller than s2 and order ASC -> true.
     * If s1 is bigger than s2 and order DESC -> true.
     */
    private static boolean extremeFound(String s1, String s2) {
        boolean extremeFound;
        int compare = s1.compareTo(s2);

        if (order.equals(SortOrder.ASC)) {
            extremeFound = (compare < 0);
        }
        else {
            extremeFound = (compare > 0);
        }

        return extremeFound;
    }

    /**
     * @param list: A list of String Objects.
     * @param start: The index of the element to start with.
     * @return: The index of the next extreme in the list relative to start.
     */
    private static int findExtreme(SeanList<String> list, int start) {
        int extreme = start;
        for (int i = start; i < list.size(); ++i) {
            if (extremeFound(list.get(i), list.get(extreme))) {
                extreme = i;
            }
        }
        return extreme;
    }

    /** This method will swap the values of the elements at given pos1 and pos2. */
    private static void swap(SeanList<String> list, int pos1, int pos2) {
        String temp = list.get(pos1);
        list.replace(list.get(pos2), pos1);
        list.replace(temp, pos2);
    }

    /**
     *
     * @param list: A list containing String Objects.
     * @param sortOrder: The order in which the list should be sorted (SortOrder.ASC, SortOrder.DESC).
     */
    public static void sort(SeanList<String> list, SortOrder sortOrder) {
        order = sortOrder;
        for (int i = 0; i < list.size(); ++i) {
            int extreme = findExtreme(list, i);
            swap(list, i, extreme);
        }
    }
}
