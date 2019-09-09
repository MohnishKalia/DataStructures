package assignment2;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

/**
 * This application compares the time complexities for two Prefix Average
 * calulation algorithms and exports the data to a times.csv file within the
 * same directory level.
 * 
 * @author Mohnish Kalia
 */
public class PrefixAverageCalculations {
    public static void main(String[] args) throws IOException, InterruptedException {
        String dataFormat = "%d,%d,%d";
        List<String> dataLines = new ArrayList<String>();

        try (Scanner input = new Scanner(System.in)) {
            boolean flag = true;
            while (flag) {
                System.out.println("What is the input size you wish to test?");
                long[] data = computeTimes(input.nextLong());
                dataLines.add(String.format(dataFormat, data[0], data[1], data[2]));
                System.out.println("Continue? y : n");
                input.nextLine();
                flag = input.next().equalsIgnoreCase("y");
            }
            Files.write(Paths.get("src/assignment2/times.csv"), dataLines, StandardOpenOption.APPEND);
        }
    }

    /**
     * Computes the time of the processed algorithms and return the data
     * 
     * @param inputSize the desired value of inputs
     * @return a long array with 3 values: the input size, time for algorithm 1, and the time
     *         for algorithm 2
     */
    private static long[] computeTimes(long inputSize) throws InterruptedException {
        long[] data = new long[3];
        long before, after;
        data[0] = inputSize;

        before = System.currentTimeMillis();
        // run alg 1
        Thread.sleep(inputSize);
        after = System.currentTimeMillis();
        data[1] = after - before;

        before = System.currentTimeMillis();
        // run alg 2
        Thread.sleep(inputSize * 3);
        after = System.currentTimeMillis();
        data[2] = after - before;

        return data;
    }
}