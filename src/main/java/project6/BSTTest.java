package project6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BSTTest {

    private BinarySearchTree<Integer> tree;
    private ByteArrayOutputStream outContent;
    private int[] negative = { 3, 4, 6, 7, 11, -7, -3, -2 }, givenCase = { 5, 4, 8, 11, 13, 7, 2, 1 },
            sequential = { 1, 2, 3, 4, 5, 6 };

    @BeforeEach
    public void setup() {
        tree = new BinarySearchTree<>();
        // setting up for testing output
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testGetSecondLargest_Empty() {
        assertEquals(null, tree.getSecondLargest());
    }

    @Test
    public void testGetSecondLargest_Sequential() {
        addAllToBST(sequential);
        assertEquals(5, tree.getSecondLargest());
    }

    @Test
    public void testGetSecondLargest_Negative() {
        addAllToBST(negative);
        assertEquals(7, tree.getSecondLargest());
    }

    @Test
    public void testGetSecondLargest_GivenCase() {
        addAllToBST(givenCase);
        assertEquals(11, tree.getSecondLargest());
    }

    @Test
    public void testPrintPaths_Empty() {
        tree.printPaths();

        String expected = "";
        String actual = outContent.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintPaths_Sequential() {
        addAllToBST(sequential);
        tree.printPaths();

        String expected = "1, 2, 3, 4, 5, 6\n";
        String actual = outContent.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintPaths_Negative() {
        addAllToBST(negative);
        tree.printPaths();

        String expected = "3, -7, -3, -2\n3, 4, 6, 7, 11\n";
        String actual = outContent.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testPrintPaths_GivenCase() {
        addAllToBST(givenCase);
        tree.printPaths();

        String expected = "5, 4, 2, 1\n5, 8, 7\n5, 8, 11, 13\n";
        String actual = outContent.toString();

        assertEquals(expected, actual);
    }

    private void addAllToBST(int... values) {
        IntStream.of(values).forEach(tree::add);
    }

}