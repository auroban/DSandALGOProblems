package arrayproblems;

import java.util.Scanner;

public class ArrayLeftRotation {

	public static void main(String[] args) {
		
		int n = 0, d = 0;
		int[] arr = null;
		System.out.println("Please enter the number of elements in the array:");
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		if (n < 1 || n > 100000) {
			System.out.println("Invalid range for number of elements in the array. Please specify a value within 1 <= n <= 100000");
		}
		else {
			System.out.println("Please enter the number of left rotations:");
			d = scanner.nextInt();
			
			if ( d < 1 || d > n) {
				System.out.println("Invalid range for rotation. Value should be within 1 <= d <= n");
			}
			else {
				arr = new int[n];
				System.out.print("Please enter the elements of the array:");
				for (int i = 0; i < n;) {
					int element = scanner.nextInt();
					if (element < 1 || element > 1000000) {
						System.out.println("Invalid range of element. Value must be within 1 to 1000000");
					}
					else {
						arr[i] = element;
						i++;
					}
				}
				
				
				System.out.println("Applying Left rotation " + d + " number of times");
				if (arr.length > 1) {
					for (int j = 1; j <= d; j++) {
						int temp = arr[0];
						for(int k = 0; (k+1) < n; k++) {
							arr[k] = arr[k+1];
						}
						arr[n-1] = temp;
					}	
				}
				for (int i = 0; i < arr.length; i++) {
					System.out.print(arr[i] + " ");
				}
				
				
					
			}
				
		}
		scanner.close();

	}

}
