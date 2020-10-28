package numberproblems;

import java.util.Scanner;

public class BinaryConversionExample {

	public static void main(String[] args) {
		
		Scanner inputScanner = new Scanner(System.in);
		System.out.println("Please enter the number to be converted to Binary:");
		int numToConvert = inputScanner.nextInt();
		inputScanner.close();
		System.out.println("The converted number is:\t" + convertToBinary(numToConvert));
	}
	
	private static long convertToBinary(int num) {
		
		int remainder = 0;
		long binaryValue = 0;
		int power = 0;
		
		while (num>0) {
			remainder = num % 2;
			long toMultiplyWith = 1;
			for	(int i=0; i<=power; i++) {
				if (i>0) {
					toMultiplyWith = toMultiplyWith * 10;
				}
			}
			binaryValue = binaryValue + (remainder*toMultiplyWith);
			power++;
			num = num/2;
		}
		
		return binaryValue;
	}

}
