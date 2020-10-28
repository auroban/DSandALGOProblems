package numberproblems;

import java.io.InputStreamReader;
import java.util.Scanner;

public class MultiplesOf3And5 {
	
	public static void main(String... args) {
		
		System.out.println("Please enter the range:\t");
		Scanner inScanner = new Scanner(new InputStreamReader(System.in));
		int numberRange = inScanner.nextInt();
		inScanner.close();
		int sum = 0;
		for	(int i = 0; i < numberRange; i++) {
			if (i % 5 == 0 || i % 3 == 0) {
				sum = sum + i;
			}
		}
		
		System.out.println("Sum:\t" + sum);
	}

}
