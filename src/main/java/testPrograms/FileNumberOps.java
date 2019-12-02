package testPrograms;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FileNumberOps {
    public static double averageNums(String filePath) throws IOException {
        return fileToIntStream(filePath).average().orElseThrow();
    }

    public static double sumNums(String filePath) throws IOException {
        return fileToIntStream(filePath).sum();
    }

    private static IntStream fileToIntStream(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath)).flatMap(line -> Stream.of(line.split(""))).mapToInt(Integer::parseInt);
    }
    public static void main(String[] args) throws IOException {
        String file = "src/testPrograms/numbers.txt";
        System.out.println(averageNums(file));
        System.out.println(sumNums(file));
    }
}