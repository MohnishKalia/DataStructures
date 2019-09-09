package assignment2;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class PrefixAverageCalculations {
    public static void main(String[] args) throws IOException {
        String dataFormat = "\n%d,%d,%d";

        try (Scanner input = new Scanner(System.in)) {
            // while (true) {
            System.out.println("What is the input size you wish to test?");
            long[] data = computeTimes(input.nextLong());
            List<String> stringWrapper = new ArrayList<String>();
            stringWrapper.add(String.format(dataFormat, data[0], data[1], data[2]));
            Files.write(Paths.get("src/assignment2/times.csv"), stringWrapper, StandardOpenOption.APPEND);
            // }
        }
    }

    private static long[] computeTimes(long inputSize) {
        long[] data = new long[3];
        long before, after;
        data[0] = inputSize;

        before = System.currentTimeMillis();
        // run alg 1
        for (int i = 0; i < inputSize * 10; i++) {
        }
        after = System.currentTimeMillis();
        data[1] = after - before;

        before = System.currentTimeMillis();
        // run alg 2
        for (int i = 0; i < inputSize * 30; i++) {
        }
        after = System.currentTimeMillis();
        data[2] = after - before;

        return data;
    }
}