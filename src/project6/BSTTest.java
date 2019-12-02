package project6;

import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BSTTest {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        int[] test1 = { -7, -3, -2, 3, 4, 6, 7, 11 };
        int[] test2 = { 5, 4, 8, 11, 13, 4, 7, 2, 1 };
        int[] test3 = { 1, 2, 3, 4, 5, 6 };
        IntStream.of(test2).forEach(tree::add);
        System.out.println("---Testing getSecondLargest() method---");
        System.out.println(tree.getSecondLargest());
    }
}