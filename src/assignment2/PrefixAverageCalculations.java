package assignment2;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * This application compares the time complexities for two Prefix Average
 * calculation algorithms and exports the data to a times.csv file within the
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
                long[] data = computeTimes(input.nextInt());
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
     * @return a long array with 3 values: the input size, time for algorithm 1, and
     *         the time for algorithm 2
     */
    private static long[] computeTimes(int inputSize) throws InterruptedException {
        double[] values = new double[inputSize];
        for (int i = 0; i < values.length; i++)
            values[i] = Math.random() * 50;

        long[] data = new long[3];
        long before, after;
        data[0] = inputSize;

        before = System.currentTimeMillis();
        // run alg 1
        prefixAverage1(values);
        after = System.currentTimeMillis();
        data[1] = after - before;

        before = System.currentTimeMillis();
        // run alg 2
        prefixAverage2(values);
        after = System.currentTimeMillis();
        data[2] = after - before;

        return data;
    }

    /**
     * Returns an array a such that, for all j, a[j] equals the average of x[0],
     * ..., x[j].
     */
    public static double[] prefixAverage1(double[] x) {
        int n = x.length;
        double[] a = new double[n]; // filled with zeros by default
        for (int j = 0; j < n; j++) {
            double total = 0; // begin computing x[0] + ... + x[j]
            for (int i = 0; i <= j; i++)
                total += x[i];
            a[j] = total / (j + 1); // record the average
        }
        return a;
    }

    /**
     * Returns an array a such that, for all j, a[j] equals the average of x[0],
     * ..., x[j].
     */
    public static double[] prefixAverage2(double[] x) {
        int n = x.length;
        double[] a = new double[n]; // filled with zeros by default
        double total = 0; // compute prefix sum as x[0] + x[1] + ...
        for (int j = 0; j < n; j++) {
            total += x[j]; // update prefix sum to include x[j]
            a[j] = total / (j + 1); // compute average based on current sum
        }
        return a;
    }
}