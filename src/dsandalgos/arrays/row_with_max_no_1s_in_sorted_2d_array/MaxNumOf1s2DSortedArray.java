package dsandalgos.arrays.row_with_max_no_1s_in_sorted_2d_array;

/**
 * Source: https://www.geeksforgeeks.org/find-the-row-with-maximum-number-1s/
 *
 * Computed Time Complexity: O(r + c) where r = rows and c = cols
 */

public class MaxNumOf1s2DSortedArray {

    private static int findRowWithMaxNumOf1s(final int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        final int rows = matrix.length;
        final int cols = matrix[0].length;

        System.out.println("Total Number of Rows: " + rows);
        System.out.println("Total Number of Cols: " + cols);

        int theRow = 0;
        int maxCount = 0;
        int lastZeroAt = cols - 1;

        for (int i = 0; i < rows; i++) {
            int onesSoFar = maxCount;
            int j = lastZeroAt;

            while (j >= 0 && matrix[i][j] == 1) {
                onesSoFar++;
                j--;
            }

            if (onesSoFar > maxCount) {
                maxCount = onesSoFar;
                theRow = i;
            }

            if (maxCount == cols) {
                break;
            }

            lastZeroAt = j;
        }

        return theRow;
    }


    public static void main(String[] args) {
        final int[][] array = {
                { 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1 },
                { 0, 0, 1, 1, 1 },
                { 0, 0, 0, 1, 1 }
        };

        System.out.println(findRowWithMaxNumOf1s(array));
    }
}
