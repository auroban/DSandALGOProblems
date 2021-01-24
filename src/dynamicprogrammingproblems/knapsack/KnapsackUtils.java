package dynamicprogrammingproblems.knapsack;

import java.util.logging.Logger;

class KnapsackUtils {

    private static final Logger LOGGER = Logger.getLogger(KnapsackUtils.class.getSimpleName());

    public static int knapsackRecursive(final int[] weights, final int[] values, final int capacity) {
        if (weights.length != values.length) {
            LOGGER.warning("Inconsistent size");
            throw new RuntimeException("Inconsistent Size");
        }
        return knapsackRecursive(weights, values, capacity, weights.length);
    }

    private static int knapsackRecursive(final int[] weights, final int[] values, final int capacity, final int size) {

        if (size == 0 || capacity == 0) {
            return 0;
        }

        final int index = size - 1;

        final int currentWeight = weights[index];
        final int currentValue = values[index];

        LOGGER.info("Current Weight: " + currentWeight);
        LOGGER.info("Current Value: " + currentValue);
        LOGGER.info("Current Capacity: " + capacity);
        LOGGER.info("Current Size: " + size);

        if (currentWeight <= capacity) {
            LOGGER.info("Current Weight is within capacity");
            final int val1 = currentValue + knapsackRecursive(weights, values, (capacity - currentWeight), size - 1);
            final int val2 = knapsackRecursive(weights, values, capacity, size - 1);
            return Math.max(val1, val2);
        } else {
            return knapsackRecursive(weights, values, capacity, size - 1);
        }
    }

    public static int knapsackDynamic(final int[] weights, final int[] values, final int capacity) {
        if (weights.length != values.length) {
            LOGGER.warning("Inconsistent size");
            throw new RuntimeException("Inconsistent Size");
        }
        return knapsackDynamic(weights, values, capacity, weights.length);
    }

    private static int knapsackDynamic(final int[] weights, final int[] values, final int capacity, final int size) {

        final int[][] matrix = new int[size + 1][capacity + 1];
        for (int i = 0; i < size + 1; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                if ( i == 0 || j == 0) {
                    matrix[i][j] = 0;
                } else {
                    final int currentWeight = weights[i-1];
                    final int currentValue = values[i-1];
                    LOGGER.info("Current Weight: " + currentWeight);
                    LOGGER.info("Current Value: " + currentValue);
                    LOGGER.info("Current Sack Weight: " + j);

                    if (currentWeight == j) {
                        LOGGER.info("Current Weight of item is equal to current Sack Weight");
                        matrix[i][j] = currentValue;
                    } else if (currentWeight < j) {
                        LOGGER.info("Current Weight of item is less than current Sack Weight");
                        final int left = j - currentWeight;
                        final int additionalValue = matrix[i-1][left];
                        final int totalValue = currentValue + additionalValue;
                        matrix[i][j] = totalValue;
                    } else {
                        LOGGER.info("Current Weight is greater than current Sack Weight");
                        matrix[i][j] = matrix[i - 1][j];
                    }
                }
            }
        }
        return matrix[size][capacity];
    }
}
