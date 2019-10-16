package ch05.apps;

import java.util.List;
import java.util.stream.Collectors;

public class CollectionTest {
    public static void main(String[] args) {
        System.out.println(
            removeDuplicates(
                List.of(
                    "This is a test test of the duplication of the thing".split(" ")
                )
            )
        );
    }

    private static <T> List<T> removeDuplicates(List<T> of) {
        return of.stream().distinct().collect(Collectors.toList());
    }
}