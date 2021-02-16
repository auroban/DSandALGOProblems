package leetcode.medium.find_next_greater_number_with_same_set_of_digits;

/**
 * Source: https://www.geeksforgeeks.org/find-next-greater-number-set-digits/
 *
 * The idea is that you pick the last digit and keep going left until you encounter a digit less than itself;
 * At this point, you swap the two digits, so you know till the swapping point, right part of the number is the next greater
 * Now for the remaining part on the left of swapping point, you keep iterating until all your digits are in ascending order
 * In every iteration, you find out the min and max and swap them
 */

class Driver {

    public static void main(String[] args) {
        System.out.println(findNextGreater("1234"));
        System.out.println(findNextGreater("534976"));
        System.out.println(findNextGreater("231"));
    }


    private static String findNextGreater(final String number) {
        if (number == null || number.length() <=1) {
            return number;
        }
        boolean possible = false;
        int replacementIndex = -1;
        final StringBuilder numberBuilder = new StringBuilder(number);

        for (int i = numberBuilder.length() - 1; i >= 0; i--) {
            final int num1 = getInt(numberBuilder.charAt(i));
            for (int j = i - 1; j >= 0; j--) {
                final int num2 = getInt(numberBuilder.charAt(j));
                if (num2 < num1) {
                    numberBuilder.setCharAt(j, getChar(num1));
                    numberBuilder.setCharAt(i, getChar(num2));
                    replacementIndex = j;
                    possible = true;
                    break;
                }
            }
            if (possible) {
                break;
            }
        }

        if (!possible) {
            return "Not Possible";
        }
        return modifyString(numberBuilder, replacementIndex + 1, numberBuilder.length() - 1);
    }

    private static String modifyString(final StringBuilder number, final int low, final int high) {
        if (low >= high) {
            return number.toString();
        }
        int min = -1;
        int max = -1;
        int minIndex = -1;
        int maxIndex = -1;

        for (int i = low; i <= high; i++) {
            int n = number.charAt(i) - '0';
            if (min == -1) {
                min = n;
                max = n;
                minIndex = i;
                maxIndex = i;
            } else {
                if (n < min) {
                    min = n;
                    minIndex = i;
                } else if (n > max) {
                    max = n;
                    maxIndex = i;
                }
            }
        }
        number.setCharAt(minIndex, (char) ('0' + max));
        number.setCharAt(maxIndex, (char) ('0' + min));
        return modifyString(number, low + 1, high - 1);
    }

    private static int getInt(final char c) {
        return c - '0';
    }

    private static char getChar(final int n) {
        return (char) (n + '0');
    }
}
