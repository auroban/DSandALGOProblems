package dsandalgos.arrays.arrayproblems;

import java.util.ArrayList;
import java.util.Scanner;

public class SegregateOddFromEvenProblem {

	public static void main(String[] args) {
		
		System.out.println("Please enter the elements:");
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			arrayList.add(scanner.nextInt());
		}
		scanner.close();
		int array[] = arrayList.stream().mapToInt(Integer::intValue).toArray();
		array = getSortedArray(array);
		System.out.println("Sorted Array:");
		for (int num: array) {
			System.out.print(num + " ");
		}

	}
	
	private static int[] getSortedArray(int[] array) {
		
		int mid = array.length/2;
		int lastEvenIndex = 0;
		int lastOddIndex = mid;
		
		for (int i=0; i<array.length; i++) {
			
			if ((i==array.length-1) && (array[i]%2==0)) {
				int temp = array[mid];
				array[mid] = array[i];
				array[i] = temp;
			}
			
			if (array[i]%2 == 0) {
				if (!(i>0 && i<mid)) {
					for (int j=lastEvenIndex; j<mid; j++) {
						if (array[j]%2 != 0) {
							int temp = array[i];
							array[i] = array[j];
							array[j] = temp;
							lastEvenIndex++;
							break;
						}
					}
				}
			}
			else {
				if (!(i>=mid && i<array.length)) {
					for (int j = lastOddIndex; j<array.length; j++) {
						if (array[j]%2 == 0) {
							int temp = array[j];
							array[j] = array[i];
							array[i] = temp;
							lastOddIndex++;
							break;
						}
					}
				}
			}
		}
		return array;
	}

}
