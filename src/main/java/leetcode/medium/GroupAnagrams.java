package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//49. Group Anagrams
public class GroupAnagrams {

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            map.computeIfAbsent(findSort(str), val -> new ArrayList<String>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private static String findSort(String str) {
        var chars = new char[26];
        var result = new StringBuilder();
        for (char ch : str.toCharArray()) {
            chars[ch - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0) {
                result.append((char) ('a' + i)).append(chars[i]);
            }
        }
        return result.toString();
    }

}
