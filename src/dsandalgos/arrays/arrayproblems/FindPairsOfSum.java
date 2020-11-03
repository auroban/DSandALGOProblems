package dsandalgos.arrays.arrayproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindPairsOfSum {

	private HashMap<Integer, Integer> map;
	private List<Pair> pairs;
	private Integer[] array;
	private Integer sum;

	public FindPairsOfSum(final Integer[] array, final Integer sum) {
		this.array = array;
		this.sum = sum;
		map = new HashMap<>();
		pairs = new ArrayList<>();
	}

	public List<Pair> find() {

		if (array != null && array.length > 1) {
			for (int i = 0; i < array.length; i++) {
				int rem = sum - array[i];

				if (map.containsKey(rem)) {
					int j = map.get(rem);
					Pair p = new Pair(array[i], array[j]);
					pairs.add(p);
				}
				map.put(array[i], i);
			}
		}
		return pairs;
	}

	private static class Pair {
		private final int x;
		private final int y;

		Pair(final int x, final int y) {
			this.x = x;
			this.y = y;
		}

		int getX() {
			return x;
		}

		int getY() {
			return y;
		}

		@Override
		public String toString() {
			return "(X = " + x + "   Y = " + y + ")";
		}

	}

	public static void main(String[] args) {
		Integer[] array = { 8, 7, 3, -1, 9, 0};
//		Integer[] array = { 8, 9 };
		FindPairsOfSum findPairsOfSum = new FindPairsOfSum(array, 7);
		List<Pair> pairs = findPairsOfSum.find();
		if (pairs.size() > 0) {
			pairs.forEach((pair) -> {
				System.out.println("Pair: " + pair.getX() + ", " + pair.getY());
			});
		} else {
			System.out.println("No pairs found");
		}
	}
}
