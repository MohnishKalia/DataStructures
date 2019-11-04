package assignment5;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;
import static java.util.Collections.reverseOrder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class WordFrequency {
    public static void main(String[] args) throws IOException {
        // get the lines from the text, split over whitespace/punctuation and create a
        // stream of words, filter out the empty string, map to
        // lowercase, then count frequency
         Map<String, Long> wordFreq = Files.lines(Paths.get("src/assignment5/WordFrequencyTests/OneLinerProgram.txt"))
                .flatMap(line -> Stream.of(line.split("[\\s\\p{Punct}]"))).filter(line -> !line.equals(""))
                .map(String::toLowerCase).collect(groupingBy(line -> line, counting()));

        // create a new linkedhashmap to allow mutability, stream over the entries,
        // reverse sort by the entry value, and collect into a
        // linkedhashmap (to preserve order)
        Map<String, Long> sortedMap = new LinkedHashMap<>(wordFreq).entrySet().stream()
                .sorted(reverseOrder(Map.Entry.comparingByValue()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (k, v) -> k, LinkedHashMap::new));
        System.out.println(sortedMap);

        // use http://www.writewords.org.uk/word_count.asp for frequency check

        // System.out.println(new LinkedHashMap<>(Files.lines(Paths.get("src/assignment5/OneLinerProgram.txt"))
        //         .flatMap(line -> Stream.of(line.split("[\\s\\p{Punct}]"))).filter(line -> !line.equals(""))
        //         .map(String::toLowerCase).collect(groupingBy(line -> line, counting()))).entrySet().stream()
        //                 .sorted(reverseOrder(Map.Entry.comparingByValue()))
        //                 .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (k, v) -> k, LinkedHashMap::new)));
    }
}