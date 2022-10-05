package hackerrank.medium.non_divisible_subset;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {
    //https://www.hackerrank.com/challenges/non-divisible-subset

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    //Solution if it is a subset
    public static int nonDivisibleSubset2(int k, List<Integer> s) {
        int[] maxSubSet = {1};
        List<Integer> subSet = new ArrayList<>();
        s.forEach(num -> {
            subSet.add(num);
            if (subSet.size() > 1) {
                for (int i = 0; i < subSet.size(); i++) {
                    int numInSubSet = i;
                    IntStream.range(numInSubSet + 1, subSet.size()).forEach(t -> {
                        if (t < subSet.size() && (subSet.get(numInSubSet) + subSet.get(t)) % k == 0) {
                            List<Integer> copySubSet = new ArrayList<>(subSet);
                            Collections.copy(copySubSet, subSet);
                            subSet.clear();
                            subSet.addAll(copySubSet.subList(numInSubSet + 1, copySubSet.size()));
                        }
                    });
                }
            }
            maxSubSet[0] = Math.max(maxSubSet[0], subSet.size());
        });
        return maxSubSet[0];
    }

    // Complete the nonDivisibleSubset function below.
    static int nonDivisibleSubset(int k, List<Integer> s) {
        int[] index = new int[k];
        for (int each : s) {
            index[each % k]++;
        }
        int zeroWriter = index[0];
        int max = zeroWriter > 0 ? 1 : 0;
        for (int i = 1; i <= (k / 2); i++) {
            max += (i != k - i) ? Math.max(index[i], index[k - i]) : 1;
        }

        return max;
    }
}

public class NonDivisibleSubset {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/test.txt"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

