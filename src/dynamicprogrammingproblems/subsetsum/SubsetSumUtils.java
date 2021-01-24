package dynamicprogrammingproblems.subsetsum;

import java.util.logging.Logger;

class SubsetSumUtils {

    private static final Logger LOGGER = Logger.getLogger(SubsetSumUtils.class.getName());

    public static boolean subsetSumDynamic(final int[] arr, final int sum) {

        final boolean[][] matrix = new boolean[arr.length + 1][sum + 1];

        for (int i = 0; i < arr.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                boolean value = false;
                if (i == 0 && j == 0) {
                    value = true;
                } else if (i == 0) {
                } else if (j == 0) {
                    value = true;
                } else {
                    final int currentItem = arr[i-1];
                    if (currentItem == j) {
                        value = true;
                    } else if (currentItem < j) {
                        final int diff = j - currentItem;
                        value = matrix[i-1][diff];
                    } else {
                        value = matrix[i-1][j];
                    }
                }
                matrix[i][j] = value;
            }
        }
        return matrix[arr.length][sum];
    }
}
