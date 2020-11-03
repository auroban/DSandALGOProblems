package dsandalgos.arrays.arrayproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public class AllSubArraysHavingSumK {

    private static final Logger LOGGER = Logger.getLogger(AllSubArraysHavingSumK.class.getSimpleName());

    static class Point {
        final int startAt;
        final int endAt;

        Point(final int startAt, final int endAt) {
            this.startAt = startAt;
            this.endAt = endAt;
        }

        @Override
        public String toString() {
            return "Point(" + startAt + "," + endAt + ')';
        }
    }

    public List<Point> findAllSubArrays(final Integer[] arr, final Integer theSum) {

        LOGGER.info("Received Array: " + Arrays.toString(arr));
        LOGGER.info("Received Sum: " + theSum);
        List<Point> points = new ArrayList<>();

        if (arr == null || arr.length == 0) {
            LOGGER.warning("Empty Array!!");
            return points;
        }

        if (theSum == null) {
            LOGGER.warning("Sum is null");
            return points;
        }


        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            LOGGER.info("Current Index: " + i);
            LOGGER.info("Current Element: " + arr[i]);
            sum += arr[i];
            LOGGER.info("Sum so far: " + sum);
            if (theSum.equals(sum)) {
                LOGGER.info("Sum matched from 0 to " + i);
                Point p = new Point(0, i);
                points.add(p);
            }

            map.putIfAbsent(sum, i);

            int difference = sum - theSum;
            LOGGER.info("Current Difference");
            if (map.containsKey(difference)) {
                LOGGER.info("Map contains difference " + difference);
                int indexAt = map.get(difference);
                int delta = i - indexAt;
                if (delta > 0) {
                    points.add(new Point(indexAt + 1, i));
                }
            }
        }
        return points;
    }

    public static void main(String[] args) {
//        Integer[] arr = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        Integer[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Integer k = 0;
        AllSubArraysHavingSumK util = new AllSubArraysHavingSumK();
        List<Point> points = util.findAllSubArrays(arr, k);

        points.forEach((point) -> {
            System.out.println(point);
            StringBuilder builder = new StringBuilder();
            builder.append("{ ");
            for (int i = point.startAt; i <= point.endAt; i++) {
                builder.append(arr[i]);
                if (i < point.endAt) {
                    builder.append(", ");
                }
            }
            builder.append(" }");

            System.out.println("Array: " + builder);
        });
    }
}
