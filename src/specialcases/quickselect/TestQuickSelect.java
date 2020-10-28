package specialcases.quickselect;

class TestQuickSelect {

	public static void main(String[] args) {

//		int[] arr = { 5, 3, 0, 1, 1, 8, 9, 6, 16, -1 };
		int[] arr = { 5, 3, 6, 1, 2, 9 };
		QuickSelect quickSelect = new QuickSelect();
		int k = 2;
		System.out.println(quickSelect.quickSelect(arr, k));

	}

}	
