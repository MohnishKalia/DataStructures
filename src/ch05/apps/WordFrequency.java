package ch05.apps;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class WordFrequency {
    public static void main(String[] args) throws IOException {
        // get the lines from the text, split over whitespace/punctuation and create a
        // stream of words, map to
        // lowercase, then count frequency
        Map<String, Long> wFreq = Files.lines(Paths.get("src/ch05/apps/OneLinerProgram.txt"))
                .flatMap(line -> Stream.of(line.split("[\\s\\p{Punct}]"))).map(String::toLowerCase)
                .collect(groupingBy(line -> line, counting()));
        System.out.println(wFreq);

        System.out.println("==================================================");

        // stream over the entries, sort by the entry value, and collect into a
        // linkedhashmap (to preserve order)
        Map<String, Long> sortedList = new LinkedHashMap<>(wFreq).entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (k, v) -> k, LinkedHashMap::new));
        System.out.println(sortedList);

        // System.out.println(new
        // LinkedHashMap<>(Files.lines(Paths.get("src/ch05/apps/OneLinerProgram.txt"))
        // .flatMap(line ->
        // Stream.of(line.split("[\\s\\p{Punct}]"))).map(String::toLowerCase)
        // .collect(groupingBy(line -> line,
        // counting()))).entrySet().stream().sorted(Map.Entry.comparingByValue())
        // .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (k, v) -> k,
        // LinkedHashMap::new)));
    }
}