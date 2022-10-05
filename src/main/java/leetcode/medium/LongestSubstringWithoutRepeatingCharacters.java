package leetcode.medium;

import java.util.HashMap;
import java.util.Map;


public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("kdlajsdowqiwrqwpla"));
    }

    private static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> resultSet = new HashMap<>();

        final int[] maxLength = {0};
        final int[] currentLength = {0};
        final int[] counter = {0};
        s.chars().forEach(character -> {
            if (resultSet.containsKey((char) character)) {
                if (maxLength[0] < currentLength[0]) {
                    maxLength[0] = currentLength[0];
                }
                currentLength[0] = Math.min(counter[0] - resultSet.get((char) character), ++currentLength[0]);
            } else {
                currentLength[0]++;
            }
            resultSet.put((char) character, counter[0]);
            counter[0]++;
        });
        return Math.max(currentLength[0], maxLength[0]);
    }
}