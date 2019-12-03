package project6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BSTTest {

    private BinarySearchTree<Integer> tree;

    @BeforeEach
    public void setup() {
        tree = new BinarySearchTree<>();
    }

    @Test
    public void testGetSecondLargest_Negative() {
        addAllToBST(3, 4, 6, 7, 11, -7, -3, -2);
        assertEquals(7, tree.getSecondLargest());
    }

    @Test
    public void testGetSecondLargest_GivenCase() {
        addAllToBST(5, 4, 8, 11, 13, 4, 7, 2, 1);
        assertEquals(11, tree.getSecondLargest());
    }

    @Test
    public void testGetSecondLargest_Sequential() {
        addAllToBST(1, 2, 3, 4, 5, 6);
        assertEquals(5, tree.getSecondLargest());
    }

    @Test
    public void testGetSecondLargest_Empty() {
        assertEquals(null, tree.getSecondLargest());
    }

    @Test
    public void testPrintPaths() {
        addAllToBST(5, 4, 8, 11, 13, 4, 7, 2, 1);
        tree.printPaths();
        fail("Not implemented yet!");
    }

    private void addAllToBST(int... values) {
        IntStream.of(values).forEach(tree::add);
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(3);
        tree.add(1);
        tree.add(-6);
        tree.add(5);
        tree.add(2);
        tree.printSideways();
    }

}