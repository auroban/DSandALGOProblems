package dynamicprogrammingproblems.subsetsum;

class Test {

    public static void main(String[] args) {
        final int[] arr = { 3, 34, 4, 12, 5 };
        final int sum = 100;
        System.out.println(SubsetSumUtils.subsetSumDynamic(arr, sum));
    }
}
