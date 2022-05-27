package hackerrank.medium.extra_long_factorials;
import java.io.*;
import java.math.*;

import static java.util.stream.Collectors.joining;

class Result {
    //https://www.hackerrank.com/challenges/extra-long-factorials?isFullScreen=true

    /*
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void extraLongFactorials(int n) {
        System.out.println(factorial(n));

    }
    static BigInteger factorial(int n) {
        assert (n >= 0);
        assert (n <= 10);

        if (n < 2) {
            return BigInteger.valueOf(1);
        }

        return factorial(n - 1).multiply(BigInteger.valueOf(n));
    }
}
public class ExtraLongFactorials {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.extraLongFactorials(n);

        bufferedReader.close();
    }
}
