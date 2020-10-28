package dsandalgos.arrays.largestsuarray;

import java.util.HashSet;

class ArrayUtils {

	final static Integer[] largestContiguousSubarray(final Integer[] array) {
		int bIndex = 0; // Starting index of the sub-array
		int eIndex = 0; // End index of the sub-array

		int largest = 0;

		if (array.length <= 1) {
			return new Integer[0];
		}

		for (int i = 0; i < array.length - 1; i++) {
			HashSet<Integer> set = new HashSet<>();
			set.add(array[i]);
			int j = i + 1;
			int remaining = array.length - j;
			while (remaining > largest && j < array.length && !set.contains(array[j])) {
				set.add(array[j++]);
			}
			int length = j - i;
			if (length > 1 && length > largest) {
				largest = length;
				bIndex = i;
				eIndex = j - 1;
			}
		}

		int subArrLenght = eIndex + 1 - bIndex;
		Integer[] subArray = new Integer[subArrLenght];

		for (int i = 0, j = bIndex; i < subArrLenght; i++, j++) {
			subArray[i] = array[j];
		}
		return subArray;
	}

}
