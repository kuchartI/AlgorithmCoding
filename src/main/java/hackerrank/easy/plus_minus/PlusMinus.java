package hackerrank.easy.plus_minus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {
    //https://www.hackerrank.com/challenges/plus-minus?isFullScreen=true

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        AtomicInteger negative = new AtomicInteger();
        AtomicInteger positive = new AtomicInteger();
        AtomicInteger zero = new AtomicInteger();
        arr.forEach(num -> {
            if (num == 0) {
                zero.getAndIncrement();
            }
            if (num > 0) {
                positive.getAndIncrement();
            }
            if (num < 0) {
                negative.getAndIncrement();
            }
        });
        System.out.printf("%.6f%n", (positive.get() / (double) arr.size()));
        System.out.printf("%.6f%n", (negative.get() / (double) arr.size()));
        System.out.printf("%.6f%n", (zero.get() / (double) arr.size()));

    }

}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
