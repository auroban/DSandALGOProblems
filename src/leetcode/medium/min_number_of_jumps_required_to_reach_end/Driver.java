package leetcode.medium.min_number_of_jumps_required_to_reach_end;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * URL: https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
 */

class Driver {

    public static void main(String[] args) {
//        final int[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1};
        final int[] arr = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };

        long startTime = System.currentTimeMillis();
        System.out.println(minJumpRecursive(arr, 0));
        long endTime = System.currentTimeMillis();
        System.out.println("Total time Recursion: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        System.out.println(minJumpsMemoization(arr));
        endTime = System.currentTimeMillis();
        System.out.println("Total time Memoization: " + (endTime - startTime));

    }

    /**
     * Time Complexity: O(n^n)
     * Space Complexity: O(1)
     */
    public static int minJumpRecursive(final int[] arr, final int index) {
        if (arr == null || arr.length == 0 || arr[index] == 0) {
            return -1;
        }

        if (index == arr.length - 1) {
            if (index == 0) {
                return -1;
            } else {
                return 1;
            }
        }

        final int element = arr[index];
        final int currentJump = index == 0 ? 0 : 1;
        int minJump = -1;

        for (int i = 1; i <= element && (index + i) <= arr.length - 1; i++) {
            final int jump = minJumpRecursive(arr, index + i);
            if (jump > 0 && (minJump == -1 || minJump > jump)) {
                minJump = jump;
            }
        }

        return minJump == -1 ? minJump : minJump + currentJump;
    }

    public static int minJumpsMemoization(final int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        final int[] memArr = new int[arr.length];
        return minJumpsMemoization(arr, 0, memArr);
    }

    private static int minJumpsMemoization(final int[] arr, final int index, final int[] memArr) {

        if (memArr[index] != 0) {
            return memArr[index];
        }
        if (index == arr.length - 1) {
            if (index == 0) {
                memArr[index] = -1;
            } else {
                memArr[index] = 1;
            }
            return memArr[index];
        }
        final int element = arr[index];
        final int currentJump = index == 0 ? 0 : 1;
        int minJump = -1;
        for (int i = 1; i <= element && (index + i) <= arr.length - 1; i++) {
            final int jump = minJumpsMemoization(arr, index + i, memArr);
            if (jump > 0 && (minJump == -1 || minJump > jump)) {
                minJump = jump;
            }
        }
        memArr[index] = minJump == -1 ? minJump : (minJump + currentJump);
        return memArr[index];
    }
}
