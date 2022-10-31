package leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

//692. Top K Frequent Words
class TopKFrequentWords {
    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[]{
                "i", "love", "leetcode", "i", "love", "coding"
        }, 2));
    }
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String s : words) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        return map.entrySet().stream()
                .sorted((v1, v2) ->
                        v2.getValue().compareTo(v1.getValue()) == 0 ?
                                v1.getKey().compareTo(v2.getKey()) : v2.getValue().compareTo(v1.getValue()))
                .map(Map.Entry::getKey).limit(k).collect(Collectors.toList());
    }
}