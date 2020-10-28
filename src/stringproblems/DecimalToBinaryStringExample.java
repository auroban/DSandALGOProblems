package stringproblems;

import java.util.Scanner;

public class DecimalToBinaryStringExample {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the number in decimal:");
		int num = scanner.nextInt();
		System.out.println("Please enter the number of iterations to be done:");
		int itr = scanner.nextInt();
		System.out.println("Please enter the i-th position:");
		int pos = scanner.nextInt();
		scanner.close();
		String binString = convertToBinaryString(num);
		for (int i=0; i<itr; i++) {
			String res = "";
			for	(int j=0; j<binString.length(); j++) {
				switch (binString.charAt(j)) {
					case '0' :
						res = res + "01";
						break;
					case '1' :
						res = res + "10";
						break;
				}
			}
			binString = res;
			System.out.println("Binary String after " + (i+1) + "th iteration(s):\t" + binString);
		}
		
		System.out.println("The element in the " + pos + "th position is:\t" + binString.charAt(pos));
		

	}
	
	private static String convertToBinaryString(int num) {
		
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
		
		return String.valueOf(binaryValue);
		
	}

}
