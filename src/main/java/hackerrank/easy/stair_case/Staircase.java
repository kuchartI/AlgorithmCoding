package hackerrank.easy.stair_case;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Result {
    //https://www.hackerrank.com/challenges/staircase?isFullScreen=true

    /*
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void staircase(int n) {
        for (int i = 1; i < n + 1; i++) {
            if (i != n) {
                System.out.print(String.format("%" + (n - i) + "s", ""));
            }
            System.out.println(String.format("%" + i + "s", "").replace(' ', '#'));
        }

    }

}

public class Staircase {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.staircase(n);

        bufferedReader.close();
    }
}

