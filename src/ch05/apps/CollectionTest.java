package ch05.apps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class CollectionTest {

    @Test
    public void testRemoveDupilcates() {
        List<String> words = List.of("This is a test test of the duplication of the thing".split(" "));
        List<String> expected = List.of("This is a test of the duplication thing".split(" "));
        assertEquals(expected, removeDuplicates(words));
    }

    private static <T> List<T> removeDuplicates(List<T> of) {
        return of.stream().distinct().collect(Collectors.toList());
    }
}