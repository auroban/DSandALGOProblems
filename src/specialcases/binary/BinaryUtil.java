package specialcases.binary;

public class BinaryUtil {

	public static void main(String... args) {

		String binaryNum1 = "111001";
		String binaryNum2 = "111";

		System.out.println(multiplyUsingKaratsuba(binaryNum1, binaryNum2));
	}

	public static long add(final long input1, final long input2) {
		System.out.println(input1);
		System.out.println(input2);
		StringBuilder sum = new StringBuilder();
		long result = 0;
		long carry = 0;

		long num1 = input1;
		long num2 = input2;
		while (num1 != 0 || num2 != 0) {

			long first = num1 % 10;
			long second = num2 % 10;

			result = (first + second + carry) % 2;
			carry = (first + second + carry) / 2;
			sum.insert(0, ""+result);

			num1 /= 10;
			num2 /= 10;

		}
		if (carry > 0) {
			sum.insert(0, carry);
		}
		
		System.out.println(sum.toString());
		return Long.parseLong(sum.toString());
	}

	public static String add(final String input1, final String input2) {
		StringBuilder sum = new StringBuilder();

		int len1 = input1.length();
		int len2 = input2.length();
		String num1, num2;
		int length;
		int carry = 0;

		if (len1 > len2) {
			num1 = input1;
			num2 = addPadding(input2, (len1 - len2));
			length = len1;
		} else {
			num1 = input2;
			num2 = addPadding(input1, (len2 - len1));
			length = len2;
		}

		for (int i = length - 1; i >= 0; i--) {
			int n1 = num1.charAt(i) - '0';
			int n2 = num2.charAt(i) - '0';
			int result = (n1 + n2 + carry) % 2;
			carry = (n1 + n2 + carry) / 2;
			sum.insert(0, String.valueOf(result));
		}

		if (carry > 0) {
			sum.insert(0, carry);
		}

		return sum.toString();

	}

	public static long subtract(final long input1, final long input2) {
		StringBuilder difference = new StringBuilder();
		long num1 = input1;
		long num2 = input2;
		long borrow = 0;
		while (num1 != 0 || num2 != 0) {
			long n1 = num1 % 10;
			long n2 = num2 % 10;
			n1 = n1 - borrow;
			
			if (n1 < 0) {
				n1 = 1;
				borrow = 1;
			} else {
				borrow = 0;
			}

			long result = n1 - n2;
			if (result < 0) {
				result = 1;
				borrow = 1;
			}
			difference.insert(0, result);
			num1 /= 10;
			num2 /= 10;
		}
		if (borrow > 0) {
			difference.insert(0, 1);
		}
		return Long.parseLong(difference.toString());
	}

	public static String subtract(final String input1, final String input2) {
		StringBuilder difference = new StringBuilder();

		int len1 = input1.length();
		int len2 = input2.length();
		String num1, num2;
		int length;
		int borrow = 0;
		if (len1 > len2) {
			int diff = len1 - len2;
			num1 = input1;
			num2 = addPadding(input2, diff);
			length = len1;
		} else {
			int diff = len2 - len1;
			num1 = input2;
			num2 = addPadding(input1, diff);
			length = len2;
		}

		for (int i = length - 1; i >= 0; i--) {
			int n1 = num1.charAt(i) - '0';
			int n2 = num2.charAt(i) - '0';

			n1 = n1 - borrow;
			if (n1 < 0) {
				n1 = 1;
				borrow = 1;
			} else {
				borrow = 0;
			}

			int result = n1 - n2;
			if (result < 0) {
				result = 1;
				borrow = 1;
			}
			difference.insert(0, String.valueOf(result));
		}
		if (borrow > 0) {
			difference.insert(0, 1);
		}

		return difference.toString();
	}

	public static long multiply(final long input1, final long input2) {
		long num1, num2;
		int length1 = String.valueOf(input1).length();
		int length2 = String.valueOf(input2).length();

		if (length1 > length2) {
			num1 = input1;
			num2 = input2;
		} else {
			num1 = input2;
			num2 = input1;
		}

		long sum = 0;
		long power = 0;
		while (num2 != 0) {
			long n = num2 % 10;
			long multiplicand;
			if (n == 1) {

				long p = (long) Math.pow(10, power++);
				multiplicand = num1 * p;
				sum = add(sum, multiplicand);
			} else {
				power++;
			}
			num2 /= 10;
		}
		return sum;
	}
	
	static int count = 1;
	public static String multiplyUsingKaratsuba(final String input1, final String input2) {
		
		System.out.println("***************");
//		
//		System.out.println("ITR " + count);
//		System.out.println("Input1: " + input1);
//		System.out.println("Input2: " + input2);
		
		int len1 = input1.length();
		int len2 = input2.length();
		
		System.out.println("Len1: " + len1);
		System.out.println("Len2: " + len2);
		
		if (len1 == 1 && len2 == 1) {
//			System.out.println("In Here: ");
			int n1 = input1.charAt(0) - '0';
			int n2 = input2.charAt(0) - '0';
//			System.out.println("N1: " + n1);
//			System.out.println("N2: " + n2);
			int res = n1*n2;
//			System.out.println("Res: " + res);
			return String.valueOf(res);
		}
		String num1, num2;
		int length;
		
		if (len1 > len2) {
			int diff = len1 - len2;
			num1 = input1;
			num2 = addPadding(input2, diff);
			length = len1;
		} else {
			int diff = len2 - len1;
			num1 = input2;
			num2 = addPadding(input1, diff);
			length = len2;
		}
		
//		System.out.println("Length: " + length);
		
		int m = length/2;
		
//		System.out.println("Half-Length: " + m);
		
		String xH = num1.substring(0,m);
		String xL = num1.substring(m,length);
		
//		System.out.println("xH: " + xH);
//		System.out.println("xL: " + xL);
		
		String yH = num2.substring(0, m);
		String yL = num2.substring(m, length);
		
//		System.out.println("yH: " + yH);
//		System.out.println("yL: " + yL);
		
		String a = multiplyUsingKaratsuba(xH, yH);
//		System.out.println("A: " + a);
		
		String b = multiplyUsingKaratsuba(xL, yL);
//		System.out.println("B: " + b);
		
		String cX = add(xH, xL);
//		System.out.println("cX: " + cX);
		
		String cY = add(yH, yL);
//		System.out.println("cY: " + cY);
		
		String cXY = multiplyUsingKaratsuba(cX, cY);
//		System.out.println("cXY: " + cXY);
		
		String cAB = add(a, b);
//		System.out.println("cAB: " + cAB);
		
		String c = subtract(cXY, cAB);
//		System.out.println("C: " + c);		
		
		long aNum = Long.parseLong(a,10);
		long cNum = Long.parseLong(c,10);
		long bNum = Long.parseLong(b,10);
		
//		System.out.println("aNUM: " + aNum);
//		System.out.println("bNUM: " + bNum);
//		System.out.println("cNUM: " + cNum);
		
		long coeff1 = Long.parseLong(Long.toBinaryString((1<<(2*m))), 10);
		long coeff2 = Long.parseLong(Long.toBinaryString((1<<m)),10);
		System.out.println("Coeff1: " + coeff1);
		System.out.println("Coeff2: " + coeff2);
		long part1 = aNum*coeff1;
		long part2 = cNum*coeff2;
		System.out.println("Part1: " + part1);
		System.out.println("Part2: " + part2);
		String res = add(add(""+part1, ""+part2),""+bNum);
//		System.out.println("result: " + res);
		count++;
		System.out.println("-----------------");
		return String.valueOf(res);
	}

	public static long convertToDecimal(final long binaryNum) {
		if (binaryNum > 0) {
			long num = binaryNum;
			int power = 0;
			long sum = 0;
			while (num != 0) {
				long n = num % 10;
				sum = sum + (n * (long) Math.pow(2, power++));
				num /= 10;
			}
			return sum;
		}
		return binaryNum;
	}

	public static long convertToBinary(final long decimalNum) {
		if (decimalNum > 0) {
			StringBuilder sum = new StringBuilder();
			long num = decimalNum;
			while (num != 0) {
				sum.insert(0, (num % 2));
				num /= 2;
			}
			return Long.parseLong(sum.toString());
		}
		return decimalNum;
	}

	/**
	 * This operation takes a time-complexity of O(n)
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isBinary(long number) {
		if (number <= 0) {
			return false;
		}
		while (number != 0) {
			long n = number % 10;
			if (n > 1) {
				return false;
			}
			number /= 10;
		}
		return true;
	}

	public static boolean isBinary(String number) {
		if (number.length() == 0) {
			return false;
		}
		char[] charArr = number.toCharArray();
		for (char ch : charArr) {
			int res = ch - '0';
			if (!(res >= 48 && res <= 49)) {
				return false;
			}
		}
		return true;
	}
	
	private static String addPadding(final String number, int diff) {
		StringBuilder sb = new StringBuilder(number);
		while (diff != 0) {
			sb.insert(0, "0");
			diff--;
		}
		return sb.toString();
	}
}
