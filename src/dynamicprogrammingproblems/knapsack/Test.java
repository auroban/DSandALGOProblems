package dynamicprogrammingproblems.knapsack;

class Test {

    public static void main(String[] args) {
        final int[] values = { 60, 100, 120 };
//        final int[] values = { 20, 30, 10, 15 };
        final int[] weights = { 10, 20, 30 };
//        final int[] weights = { 5, 4, 7, 2 };
        final int capacity = 50;
//        final int capacity = 7;
//        final int maxValue = KnapsackUtils.knapsackRecursive(weights, values, capacity);
        final int maxValue = KnapsackUtils.knapsackDynamic(weights, values, capacity);
        System.out.println("Max Value: " + maxValue);
    }
}
