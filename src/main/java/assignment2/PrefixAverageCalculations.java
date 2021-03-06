package assignment2;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This application compares the time complexities for two Prefix Average
 * calculation algorithms and exports the data to a times.csv file within the
 * same directory level.
 *
 * @author Mohnish Kalia
 */
public class PrefixAverageCalculations {
    public static void main(String[] args) throws IOException, InterruptedException {
        String dataFormat = "%d,%d,%d"; // format for csv data
        List<String> dataLines = new ArrayList<String>();
        Random gen = new Random();

        int min = 0, max = 300000;
        for (int i = 0; i < 10; i++) {
            long[] data = computeTimes(min + gen.nextInt(max - min + 1));
            // create 10 data points by using random input size [0-300000]
            dataLines.add(String.format(dataFormat, data[0], data[1], data[2]));
            // [inputSize, alg 1 time, alg 2 time]
        }
        // write to the csv file
        Files.write(Paths.get("src/assignment2/times.csv"), dataLines, StandardOpenOption.APPEND);
    }

    /**
     * Computes the time of the processed algorithms and returns the resulting data
     *
     * @param inputSize the desired value of inputs
     * @return a long array with 3 values: the input size, time for algorithm 1, and
     *         the time for algorithm 2
     */
    private static long[] computeTimes(int inputSize) throws InterruptedException {
        double[] values = new Random().doubles(inputSize).map(d -> d * 50).toArray();
        // create a double array with length as input size and fill with random doubles [0-50)
        long[] data = new long[3];
        long before, after; // data format initialization
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