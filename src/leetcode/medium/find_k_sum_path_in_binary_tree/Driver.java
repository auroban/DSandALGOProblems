package leetcode.medium.find_k_sum_path_in_binary_tree;

import dsandalgos.trees.binarytree.BinaryTreeUtil;
import dsandalgos.trees.binarytree.Node;

import java.util.ArrayList;
import java.util.List;

class Driver {

    public static void main(String[] args) {

        final Node<Integer> root = new Node<>(1);
        root.setLeft(new Node<>(3));
        root.setRight(new Node<>(-1));

        var left = root.getLeft();
        left.setLeft(new Node<>(2));
        left.setRight(new Node<>(1));

        var right = root.getRight();
        right.setLeft(new Node<>(4));
        right.setRight(new Node<>(5));

        right = left.getRight();
        right.setLeft(new Node<>(1));

        right = root.getRight();
        left = right.getLeft();
        left.setLeft(new Node<>(1));
        left.setRight(new Node<>(2));

        right = right.getRight();
        right.setRight(new Node<>(6));

        System.out.println(BinaryTreeUtil.inOrder(root));


        findKSumPath(root, 5);

    }

     static void findKSumPath(final Node<Integer> root, final int k) {
         findKSumPath(root, new ArrayList<>(), k);
     }

     static void findKSumPath(final Node<Integer> root, final List<Integer> list, final int k) {

         if (root != null) {
//             System.out.println("Current Root: " + root.getValue());
//             System.out.println("Current List: " + list);

             list.add(root.getValue());
             findKSumPath(root.getLeft(), list, k);
             findKSumPath(root.getRight(), list, k);
             int sum = 0;
             for (int i = list.size() - 1; i >= 0; i--) {
                 sum = sum + list.get(i);
                 if (sum == k) {
                     printPath(list, i);
                 }
             }
             list.remove(list.size() - 1);
         }
     }

     static void printPath(final List<Integer> list, final int till) {
         if (list != null && list.size() > 0 && till < list.size()) {
             final StringBuilder stringBuilder = new StringBuilder();
             for (int i = till; i < list.size(); i++) {
                 stringBuilder.append(list.get(i));
                 if (i != list.size() - 1) {
                     stringBuilder.append(" -> ");
                 }
             }
             System.out.println(stringBuilder);
         }
     }
}
