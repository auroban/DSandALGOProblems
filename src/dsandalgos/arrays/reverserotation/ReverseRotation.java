package dsandalgos.arrays.reverserotation;

public class ReverseRotation {

	public static void main(String[] args) {
		Integer[] array = { 1, 2, 3 };
		ReverseRotation reverseRotation = new ReverseRotation();
		reverseRotation.reverseRotate(array, 4);
	}
	
	/**
	 * 
	 * @param <E>
	 * @param array
	 * @param rotationNum
	 * 
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 */

	public <E> void reverseRotate(E[] array, int rotationNum) {

		System.out.println("Before Rotation:\n");
		for (E item : array) {
			System.out.print(item + "\t");
		}
		System.out.println("\n\n");
		System.out.println("Rotation By: " + rotationNum);
		if (array != null && array.length > 1) {
			if (rotationNum > array.length) {
				rotationNum = rotationNum % array.length;
			}
			reverseRotate(array, 0, rotationNum - 1);
			reverseRotate(array, rotationNum, array.length - 1);
			reverseRotate(array, 0, array.length - 1);

			System.out.println("After Rotation:\n");
			for (E item : array) {
				System.out.print(item + "\t");
			}
			System.out.println("\n\n");
		}
	}

	private <E> void reverseRotate(E[] array, int startIndex, int endIndex) {

		if (startIndex < endIndex && endIndex < array.length) {

			int i = startIndex, j = endIndex;

			while (i < j) {
				E temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}
	}

}
