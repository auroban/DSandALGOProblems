package dsandalgos.arrays.largestsuarray;

class Test {

	public static void main(String[] args) {
//		Integer[] arr = { 2, 0, 2, 1, 4, 3, 1, 0 };
		Integer[] arr = { 1, 0, 2, 3, 0, 5, 7, 11, 9, 0 };
		Integer[] subArr = ArrayUtils.largestContiguousSubarray(arr);
		System.out.println("Length of SUb-Array: " + subArr.length);
		for (Integer i : subArr) {
			System.out.print(i);
			System.out.print("\t");
		}
	}
}