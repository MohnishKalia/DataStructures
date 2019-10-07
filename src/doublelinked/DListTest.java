package doublelinked;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ch04.queues.QueueUnderflowException;

public class DListTest {
    private DList<Integer> empty;
    private DList<Integer> single;
    private DList<Integer> dList;

    @BeforeEach
    public void setup() {
        empty = new DList<Integer>();
        single = new DList<Integer>();
        single.addToLast(0);
        dList = new DList<Integer>();
        IntStream.rangeClosed(0, 3).forEach(i -> dList.addToLast(i));
    }

    @Test
    public void testRemoveLast_Empty() {
        assertThrows(QueueUnderflowException.class, () -> {
            empty.removeLast();
        });
    }

    @Test
    public void testRemoveLast_One() {
        single.removeLast();
        assertEquals("", single.toString());
    }

    @Test
    public void testRemoveLast_Regular() {
        dList.removeLast();
        assertEquals(toStringHelper(0, 2), dList.toString());
    }

    @Test
    public void testPop_Empty() {
        assertThrows(QueueUnderflowException.class, () -> {
            empty.pop();
        });
    }

    @Test
    public void testPop_One() {
        assertEquals(0, single.pop());
        assertEquals("", single.toString());
    }

    @Test
    public void testPop_Regular() {
        assertEquals(3, dList.pop());
        assertEquals(toStringHelper(0, 2), dList.toString());
    }

    @Test
    public void testPush_Empty() {
        empty.push(3);
        assertEquals("3", empty.toString());
    }

    @Test
    public void testPush_One() {
        single.push(1);
        assertEquals(toStringHelper(0, 1), single.toString());
    }

    @Test
    public void testPush_Regular() {
        dList.push(4);
        assertEquals(toStringHelper(0, 4), dList.toString());
    }

    /**
     * Method to assist in the formation of iterative strings in DLL format.
     * 
     * <blockquote>e.g. From 0-3, this method will return
     * <code>"0<=>1<=>2<=>3"</code></blockquote>
     * 
     * @param start
     * @param end
     * @return string containing all numbers from [start, end] with "<=>" delimiter
     */
    private static String toStringHelper(int start, int end) {
        return IntStream.rangeClosed(start, end).boxed().map(i -> i.toString()).collect(Collectors.joining("<=>"));
    }

}