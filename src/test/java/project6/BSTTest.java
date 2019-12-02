package project6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BSTTest {

    private BinarySearchTree<Integer> tree;

    @BeforeEach
    public void setup() {
        tree = new BinarySearchTree<>();
    }

    // @ParameterizedTest
    // @ValueSource(strings = { "-7, -3, -2, 3, 4, 6, 7, 11", "5, 4, 8, 11, 13, 4, 7, 2, 1", "1, 2, 3, 4, 5, 6" })
    // public void testParams(String input) {
    //     int[] param = Stream.of(input.split(", ")).mapToInt(Integer::parseInt).toArray();
    //     addAllToBST(param);
    //     Arrays.sort(param);
    //     int sl = param[param.length-2];
    //     assertEquals(sl, tree.getSecondLargest());
    // }

    @Test
    public void testGetSecondLargest_Negative() {
        addAllToBST(-7, -3, -2, 3, 4, 6, 7, 11);
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
    public void testPrintPaths() {
        addAllToBST(5, 4, 8, 11, 13, 4, 7, 2, 1);
        fail("Not implemented yet!");
    }

    private void addAllToBST(int... values) {
        IntStream.of(values).forEach(tree::add);
    }

}