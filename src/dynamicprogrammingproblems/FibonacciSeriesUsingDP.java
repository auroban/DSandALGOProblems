package dynamicprogrammingproblems;

import java.util.Scanner;

public class FibonacciSeriesUsingDP {

	public static void main(String... args) {
		System.out.println("Please enter the nth term of the Fibonacci Series:");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();
		System.out.println("Fibonacci number of the " + n + "th term is :\n" + findFibonacci(0, 1, n));
		System.out.println("The Fibonacci Series unto " + n + "th term is:");
		int[] fibSeries = findFibonacciSeries(n);
		if (fibSeries == null) {
			System.out.println("No Series generated");
		}
		else {
			for (int i : fibSeries) {
				System.out.print(i + "\t");
			}
		}
	}

	private static int findFibonacci(int n1, int n2, int nth) {

		if (nth == 0) {
			return n1;
		}
		if (nth == 1) {
			return n2;
		} else {
			return findFibonacci(n2, (n2 + n1), --nth);
		}
	}

	private static int[] findFibonacciSeries(int nth) {

		if (nth == 0) {
			return null;
		} else if (nth == 1) {
			int[] fibSeries = { 0 };
			return fibSeries;
		} else {
			int[] fibSeries = new int[nth + 1];
			fibSeries[0] = 0;
			fibSeries[1] = 1;

			for (int i = 2; i <= nth; i++) {
				fibSeries[i] = fibSeries[i - 1] + fibSeries[i - 2];
			}

			return fibSeries;
		}
	}

}
