package arrayproblems;


import java.util.*;

/**
 * Length of the largest subarray with unique contiguous elements
 * <p>
 * Origin: https://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-1/
 * <p>
 * Solution:
 * <p>
 * The idea is to iterate over the array while maintaining a map of all the items already visited
 * For one element, we have to find the min and the max
 * Get the indices for both min and max
 * Find out if there's any index of a possible contiguous element that's lower than the current index
 * If elements are contiguously positioned, then the difference between max and min
 * and that between the lower index and current index should be same
 * If same, replace max Length by the diff value ONLY if it's larger than current max Length
 * <p>
 * <p>
 * This solution will work even if the array contains duplicate elements
 * Step 1: Maintain a map to remember all the numbers visited
 * Step 2: Maintain a variable to keep the max length so far
 * Step 3: Iterate over the array and pick the current element
 * Step 4: Within the iteration, maintain a variable to find out the lower index
 * Step 5: Push the current element and its index in the memory map
 * Step 6: If the memory map contains an element that is 1 less than the current element, keep going until you find the lowest
 * Step 7: If any index in this process is found lesser than the current lower Index, replace it
 * Step 8: If the memory map contains an element that is 1 more than current element, keep going until you find the highest
 * Step 9: If any index in this process is found lesser than the current lower Index, replace it
 * Step 10: Find out the difference between max and min
 * Step 11: Find out the difference between lowerIndex and current Index (i)
 * Step 12: Compare both differences. If they are same, we have found a sub-array that contains elements that can be rearranged to form a contiguous sub-array
 * Step 13: If that difference is greater than current max Length, replace current max Length
 */
public class LengthOfLargestSubArrayWithContiguousElements {

    public static void main(String[] args) {
        final Integer[] array = {1, 56, 0, 57, 56, 58, 0, 0, 91, 45};
        LengthOfLargestSubArrayWithContiguousElements util = new LengthOfLargestSubArrayWithContiguousElements();
        System.out.println(util.findLongest(array));
    }

    public Map<String, Integer> findLongest(final Integer[] array) {

        final Map<String, Integer> hashMap = new HashMap<>();

        if (array == null || array.length == 0) {
            return hashMap;
        }

        if (array.length == 1) {
            return hashMap;
        }


        final Map<Integer, Integer> memoryMap = new HashMap<>();
        int maxLength = 0;
        int beginIndex = -1, endIndex = -1;

        for (int i = 0; i < array.length; i++) {

            int num = array[i];
            int lowerIndex = i;
            int min = num, max = num;
            memoryMap.put(num, i);
            System.out.println("Current Num: " + num);
            /**
             * Find the minimum and see if its index is lower than the current lowerIndex
             */
            while (memoryMap.containsKey(num - 1)) {
                min = num - 1;
                int index = memoryMap.get(num - 1);
                if (index < lowerIndex) {
                    lowerIndex = index;
                }
                num = num - 1;
            }

            /**
             * Find the maximum and see if its index is lower than the current lowerIndex
             */
            while (memoryMap.containsKey(num + 1)) {
                max = num + 1;
                int index = memoryMap.get(num + 1);
                if (index < lowerIndex) {
                    lowerIndex = index;
                }
                num = num + 1;
            }

            int diffIndices = i - lowerIndex + 1;
            int diffNumbers = max - min + 1;


            if (diffIndices == diffNumbers && diffNumbers > maxLength && diffNumbers > 1) {
                maxLength = diffNumbers;
                beginIndex = lowerIndex;
                endIndex = i;
            }
        }
        hashMap.put("maxLength", maxLength);
        hashMap.put("beginningAt", beginIndex);
        hashMap.put("endingAt", endIndex);
        return hashMap;
    }

}
