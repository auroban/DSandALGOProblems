package specialcases.karatsuba;

/**
 * 
 * @author auro Karatsuba Multiplication Algorithm For more info: >>
 *         https://brilliant.org/wiki/karatsuba-algorithm/ >>
 *         https://courses.csail.mit.edu/6.006/spring11/exams/notes3-karatsuba
 */

public class Karatsuba {

	public static void main(String[] args) throws Exception {
//		long num1 = 5555;
//		long num2 = 101010;
//		System.out.println(karatsubaMultiplication(num1, num2));

//		String num1 = "32160";
//		String num2 = "000009";
//		System.out.println(subtract(num1, num2));

		//TODO: Have to fix this program with the given inputs
		String input1 = "13697030";
		String input2 = "94";
		System.out.println(karatsubaMultiplication(input1, input2, 0));
		System.out.println("The End");
		
//		System.out.println(subtract(input1, input2));

	}

	public static long karatsubaMultiplication(long x, long y) {

		/**
		 * If either of X or Y is a single digit number (<10), perform simple
		 * multiplication
		 */
		if (x < 10 || y < 10) {
			return (x * y);
		}

		int length1 = getLengthOfNumber(x);
		int length2 = getLengthOfNumber(y);

		int maxNumOfDigits = length1 > length2 ? length1 : length2;
		int halfMaxDigits = maxNumOfDigits / 2;

		/**
		 * Find the high and low bits. For example: 1234 => 12 as high bits and 34 as
		 * low bits In order to get 12, we need to divide (/) the number 1234 by 100
		 * (10^2) In order to get 34, wee need to modulo (%) the number 1234 by 100
		 * (10^2) The power of 10 (2 in the case) is decided my getting the max length
		 * of two of those given numbers and diving it by 2
		 */

		long xHigh = findHigh(x, halfMaxDigits);
		long xLow = findLow(x, halfMaxDigits);

		long yHigh = findHigh(y, halfMaxDigits);
		long yLow = findLow(y, halfMaxDigits);

		/**
		 * Example: X = 1234 Y = 4321 xHigh = 12 yHigh = 43 xLow = 34 yLow = 21
		 * 
		 * Formula: a = (xHigh * yHigh) b = (xLow * yLow) c = {(xHigh + xLow) * (yHigh +
		 * yLow)} - a - b
		 * 
		 * Final result: [a*(10^(2*m))] + [c*(10^m)] + b
		 * 
		 */
		long a = karatsubaMultiplication(xHigh, yHigh);
		long b = karatsubaMultiplication(xLow, yLow);
		long c = karatsubaMultiplication((xHigh + xLow), (yHigh + yLow)) - a - b;

		long part1 = (long) (a * Math.pow(10, 2 * halfMaxDigits));
		long part2 = (long) (c * Math.pow(10, halfMaxDigits));
		long finalNum = part1 + part2 + b;
		return finalNum;
	}

	public static String karatsubaMultiplication(final String input1, final String input2, int counter) throws Exception {
		System.out.println("**************************************************");
		System.out.println("========================");
		System.out.println("ITERATION: " + (++counter));
		System.out.println("========================");

		System.out.println("Received Input1: " + input1);
		System.out.println("Received Input2: " + input2);
		int len1 = input1.length();
		int len2 = input2.length();

		System.out.println("Received Input1 Length: " + input1.length());
		System.out.println("Received Input2 Length: " + input2.length());
		int length = 0;

		String x, y;

		if (len1 == 1 || len2 == 1) {

			System.out.println("Either of the two is single digit");
			String multiplicand;
			String multiplier;
			if (len1 > len2) {
				multiplicand = input1;
				multiplier = input2;
			} else {
				multiplicand = input2;
				multiplier = input1;
			}
			System.out.println("Multiplicand: " + multiplicand);
			System.out.println("Multiplier: " + multiplier);
			String res = multiplyDigitByDigit(multiplicand, multiplier);
			
			StringBuilder stringBuilder = null;
			
			for (int i = 0; i < res.length(); i++) {
				if (res.charAt(i) != '0') {
					stringBuilder = new StringBuilder(res.substring(i));
					break;
				}
			}
			
			if (stringBuilder == null) {
				return String.valueOf(0);
			}
			return stringBuilder.toString();
		}

		if (len1 > len2) {
			int diff = len1 - len2;
			length = len1;
			x = input1;
			y = addPadding(input2, diff);
		} else {
			int diff = len2 - len1;
			length = len2;
			x = input2;
			y = addPadding(input1, diff);
		}

		System.out.println("X = " + x);
		System.out.println("Y = " + y);

		int m = length / 2;

		System.out.println("Length: " + length);
		System.out.println("Half Length: " + m);
		String xH = x.substring(0, m);
		String xL = x.substring(m, length);

		System.out.println("xH => " + xH);
		System.out.println("xL => " + xL);

		String yH = y.substring(0, m);
		String yL = y.substring(m, length);

		System.out.println("yH => " + yH);
		System.out.println("yL => " + yL);

		String a = karatsubaMultiplication(xH, yH,counter);
		System.out.println("A of ITR " + counter + " :=> " + a);
		String b = karatsubaMultiplication(xL, yL, counter);
		System.out.println("B of ITR " + counter + " :=> " + b);
		String cX = add(xH, xL);
		System.out.println("cX of ITR " + counter + " :=> " + cX);
		String cY = add(yH, yL);
		System.out.println("cY of ITR " + counter + " :=> " + cY);
		String cXY = karatsubaMultiplication(cX, cY, counter);
		System.out.println("cXY of ITR " + counter + " :=> " + cXY);
		String cAB = add(a, b);
		System.out.println("cAB of ITR " + counter + " :=> " + cAB);
		String c = subtract(cXY, cAB);
		System.out.println("c of ITR " + counter + " :=> " + c);

		String coeff1 = String.valueOf(((int) Math.pow(10, (2 * m))));
		String coeff2 = String.valueOf((int) Math.pow(10, m));

		System.out.println("coeff1 of ITR " + counter + " :=> " + coeff1);
		System.out.println("coeff2 of ITR " + counter + " :=> " + coeff2);

		String resA = karatsubaMultiplication(a, coeff1, counter);
		System.out.println("resA of ITR " + counter + " :=> " + resA);
		String resC = karatsubaMultiplication(c, coeff2, counter);
		System.out.println("resC of ITR " + counter + " :=> " + resC);
		String resAC = add(resA, resC);
		System.out.println("resAC of ITR " + counter + " :=> " + resAC);
		String resACB = add(resAC, b);
		System.out.println("resACB of ITR " + counter + " :=> " + resACB);
		
//		StringBuilder sb = null;
//		
//		for (int i = 0; i < resACB.length(); i++) {
//			if (resACB.charAt(i) != '0') {
//				sb = new StringBuilder(resACB.substring(i));
//				break;
//			}
//		}
//		if (sb == null) {
//			return String.valueOf(0);
//		}

//		return sb.toString();
		return resACB;
	}

	private static int getLengthOfNumber(long number) {
		int count = 0;
		while (number != 0) {
			number /= 10;
			count++;
		}
		return count;
	}

	private static long findHigh(long num, int power) {
		long div = (long) Math.pow(10, power);
		return (num / div);
	}

	private static long findLow(long num, int power) {
		long div = (long) Math.pow(10, power);
		return (num % div);
	}

	private static String multiplyDigitByDigit(String multiplicand, String multiplier) throws Exception {

		StringBuilder sb = new StringBuilder();

		int m = multiplier.charAt(0) - '0';

		int carry = 0;
		for (int i = multiplicand.length() - 1; i >= 0; i--) {
			char ch = multiplicand.charAt(i);
			if (!(((int) ch) >= 48 && ((int) ch) <= 57)) {
				throw new Exception("The String " + multiplicand + " contains a non digit. Please correct it");
			}
			int n = ch - '0';
			int res = ((n * m) + carry) % 10;
			carry = ((n * m) + carry) / 10;
			sb.insert(0, String.valueOf(res));
		}
		if (carry > 0) {
			sb.insert(0, carry);
		}
		return sb.toString();
	}

	private static String add(String num1, String num2) throws Exception {

		System.out.println("ADD NUM1: " + num1);
		System.out.println("ADD NUM2: " + num2);

		int len1 = num1.length();
		int len2 = num2.length();

		if (len1 > len2) {
			num2 = addPadding(num2, (len1 - len2));
		} else {
			num1 = addPadding(num1, (len2 - len1));
		}
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		for (int i = num1.length() - 1; i >= 0; i--) {
			int n1 = num1.charAt(i) - '0';
			int n2 = num2.charAt(i) - '0';
			int res = (n1 + n2 + carry) % 10;
			carry = (n1 + n2 + carry) / 10;
			sb.insert(0, String.valueOf(res));
		}
		if (carry > 0) {
			sb.insert(0, carry);
		}
		return sb.toString();
	}

	private static String subtract(String num1, String num2) {

		StringBuilder sb = new StringBuilder();
		String bigger, smaller;
		String n1 = "0", n2 = "0";
		for (int i = 0; i < num1.length(); i++) {
			if (num1.charAt(i) != '0') {
				n1 = num1.substring(i);
				break;
			}
		}
		for (int i = 0; i < num2.length(); i++) {
			if (num2.charAt(i) != '0') {
				n2 = num2.substring(i);
				break;
			}
		}
		if (n1.length() > n2.length()) {
			bigger = n1;
			smaller = n2;
		} else if (n2.length() > n1.length()) {
			bigger = n2;
			smaller = n1;
		} else {
			int m1 = n1.charAt(0) - '0';
			int m2 = n2.charAt(0) - '0';
			if (m1 > m2) {
				bigger = n1;
				smaller = n2;
			} else {
				bigger = n2;
				smaller = n1;
			}
		}
		smaller = addPadding(smaller, (bigger.length() - smaller.length()));

		System.out.println("Bigger: " + bigger);
		System.out.println("Smaller: " + smaller);
		int length = smaller.length();
		int borrow = 0;
		for (int i = (length - 1); i >= 0; i--) {
			int k1 = bigger.charAt(i) - '0';
			int k2 = smaller.charAt(i) - '0';
			k2 += borrow;
			if (k1 < k2) {
				k1 += 10;
				borrow = 1;
			} else {
				borrow = 0;
			}
			int res = (k1 - k2) % 10;
			sb.insert(0, res);
		}
		return sb.toString();
	}

	private static String addPadding(String number, int diff) {
		StringBuilder sb = new StringBuilder(number);
		while (diff != 0) {
			sb.insert(0, String.valueOf(0));
			diff--;
		}
		return sb.toString();
	}
}
