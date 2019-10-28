package ch05.apps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class CollectionTest {

    @Test
    public void testRemoveDupilcates_List() {
        List<String> words = List.of("This is a test test of the duplication of the thing".split(" "));
        List<String> expected = List.of("This is a test of the duplication thing".split(" "));
        assertEquals(expected, removeDuplicatesList(words));
    }

    @Test
    public void testRemoveDupilcates_Set() {
        List<String> words = List.of("This is a test test of the duplication of the thing".split(" "));
        Set<String> expected = Set.of("This is a test of the duplication thing".split(" "));
        assertEquals(expected, removeDuplicatesSet(words));
    }

    private static <T> List<T> removeDuplicatesList(List<T> of) {
        return of.stream().distinct().collect(Collectors.toList());
    }

    private static <T> Set<T> removeDuplicatesSet(List<T> of) {
        return of.stream().collect(Collectors.toSet());
    }

    public static void main(String[] args) {

    }
}