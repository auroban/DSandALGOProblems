package patternprintproblems;

import java.util.Scanner;

public class PrintStarsWithoutLoop {

	private static int numOfLines = 0;
	private static int midLine = 0;
	private static int count = 0;

	public static void main(String[] args) {

		System.out.println("Please enter a number:");
		Scanner scanner = new Scanner(System.in);
		numOfLines = scanner.nextInt();
		scanner.close();
		if (numOfLines % 2 == 0) {
			midLine = numOfLines / 2;
		} else {
			midLine = (numOfLines / 2) + 1;
		}
		count = 1;
		printPatternAtLine(1);
	}

	private static void printPatternAtLine(int line) {

		if (count <= numOfLines) {
			printStar(1, line);
			System.out.println();
			if (count < midLine) {
				count++;
				printPatternAtLine(++line);
			} else if (count == midLine) {
				count++;
				if ((numOfLines % 2) == 0) {
					printPatternAtLine(line);
				} else {
					printPatternAtLine(--line);
				}
			} else {
				count++;
				printPatternAtLine(--line);
			}
		}

	}

	private static void printStar(int init, int numOfStars) {
		if (init <= numOfStars) {
			System.out.print("*");
			printStar(++init, numOfStars);

		}
	}

}
