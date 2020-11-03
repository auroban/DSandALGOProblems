package dsandalgos.arrays.arrayproblems;

import java.util.HashMap;
import java.util.Optional;
import java.util.logging.Logger;


/**
 * Question: Longest sub-array having sum k
 * https://www.geeksforgeeks.org/longest-sub-array-sum-k/
 */
public class LongestSubArrayHavingSumEqualToK {

    private static final Logger LOGGER = Logger.getLogger(LongestSubArrayHavingSumEqualToK.class.getSimpleName());

    static class Pair {
        final int startAt;
        final int endAt;

        Pair(final int startAt, final int endAt) {
            this.startAt = startAt;
            this.endAt = endAt;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "startAt=" + startAt +
                    ", endAt=" + endAt +
                    '}';
        }
    }


    public Optional<Pair> findLongestSubArray(final Integer[] arr, final Integer theSum) {

        if (arr == null || arr.length == 0) {
            LOGGER.warning("Array is NULL!!");
            return Optional.empty();
        }

        if (theSum == null) {
            LOGGER.warning("The Sum is NULL!!");
            return Optional.empty();
        }

        if (arr.length == 1) {
            LOGGER.info("Array Length: 1");
            if (arr[0].equals(theSum)) {
                LOGGER.info("Array element is equal to sum");
                Pair p = new Pair(0, 0);
                return Optional.of(p);
            } else {
                LOGGER.severe("Array element is not equal to sum");
                return Optional.empty();
            }
        }

        int startAt = 0;
        int endAt = 0;
        // HashMap to keep the sums calculated upto different indices
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            LOGGER.info("Currently at Index: " + i);
            sum += arr[i];
            LOGGER.info("Sum so far: " + sum);

            // If the current sum is equal to the give sum
            // The assumption is that the startAt index starts at 0 (the beginning)
            if (sum == theSum) {
                LOGGER.info("Sum matched upto the given sum: " + theSum);
                int diff = i + 1;
                if (maxLength < diff) {
                    LOGGER.info("Current Max Length: " + maxLength);
                    LOGGER.info("Current Diff: " + diff);
                    maxLength = diff;
                    endAt = i;
                }
            }

            map.putIfAbsent(sum, i);

            int diff = sum - theSum;
            LOGGER.info("Difference Needed: " + diff);
            if (map.containsKey(diff)) {
                LOGGER.info("Map Contains Diff: " + diff);
                Integer indexAt = map.get(diff);
                LOGGER.info("Index at which diff was found: " + indexAt);
                int delta = i - (indexAt + 1);
                LOGGER.info("Delta: " + delta);
                if (delta > 0 && delta > maxLength) {
                    LOGGER.info("Sum from index " + (indexAt + 1) + " to index " + i + " matched up to the Sum: " + theSum);
                    maxLength = delta + 1;
                    startAt = indexAt + 1;
                    endAt = i;
                }
            }
        }
        Pair p = new Pair(startAt, endAt);
        return Optional.of(p);
    }

    public static void main(String[] args) {
//        Integer[] arr = {5, 0, 9, -9, 3, -1, 6};
//        Integer[] arr = {5, 0, 0, 4, 4, 9, 3};
        Integer[] arr = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        Integer k = 8;
        LongestSubArrayHavingSumEqualToK obj = new LongestSubArrayHavingSumEqualToK();
        Optional<Pair> pairOptional = obj.findLongestSubArray(arr, k);

        pairOptional.ifPresentOrElse(LongestSubArrayHavingSumEqualToK::display, () -> System.err.println("Nothing found"));
    }

    private static void display(final Pair pair) {
        System.out.println(pair);
        int i = 0;
        System.out.println("Length: " + (i = (pair.endAt - pair.startAt) + 1));

    }
}
