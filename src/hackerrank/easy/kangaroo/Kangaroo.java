package hackerrank.easy.kangaroo;

import java.io.*;

class Result {
    //https://www.hackerrank.com/challenges/kangaroo/problem?isFullScreen=true

    /*
     * Complete the 'kangaroo' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER x1
     *  2. INTEGER v1
     *  3. INTEGER x2
     *  4. INTEGER v2
     */

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        if ((x1 >= x2 && v1 > v2) || (x1 <= x2 && v1 < v2)) {
            return "NO";
        } else {
            int kangoroo1 = x1;
            int kangoroo2 = x2;
            while (true) {
                kangoroo1 += v1;
                kangoroo2 += v2;
                if (kangoroo1 == kangoroo2) {
                    return "YES";
                } else if ((kangoroo1 > kangoroo2 && v1 >= v2) || (kangoroo1 < kangoroo2 && v1 < v2)) {
                    return "NO";
                }
            }
        }
    }

}

public class Kangaroo {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/text.txt"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int x1 = Integer.parseInt(firstMultipleInput[0]);

        int v1 = Integer.parseInt(firstMultipleInput[1]);

        int x2 = Integer.parseInt(firstMultipleInput[2]);

        int v2 = Integer.parseInt(firstMultipleInput[3]);

        String result = Result.kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

