package leetcode.medium;

import java.util.*;

//347. Top K Frequent Elements
class TopKFrequentElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 2, 2, 3}, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        var result = new int[k];
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        Queue<Map.Entry<Integer, Integer>> queue =
                new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(entry);
        }

        for (int i = 0; i < k; i++) {
            result[i] = queue.poll().getKey();
        }
        return result;
    }
}