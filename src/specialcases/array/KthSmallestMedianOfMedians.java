package specialcases.array;

class KthSmallestMedianOfMedians {

	public static void main(String[] args) {
		

	}
	
	private KthSmallestMedianOfMedians() {};
	
	static int findKthSmallest(int[] arr, int low, int high, int k) throws Exception {
		
		
		if (k > (high - low) + 1) {
			throw new Exception("K value exceeding array size");
		}
		
		if (low == high) {
			return arr[low];
		}
		if (low < high) {
			int lengthOfArray = high - low + 1;
			int numOfMedians = lengthOfArray / 5;
			if (lengthOfArray % 5 != 0) {
				numOfMedians++;
			}
			int[] medians = new int[numOfMedians];
			
			int i = 0;
			int boundaryWall = low;
			while (i < numOfMedians && (boundaryWall + 4) <= high) {
				
			}
		}
		
		return arr[high];
	}

}
