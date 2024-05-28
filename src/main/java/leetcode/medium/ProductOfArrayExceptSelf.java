package leetcode.medium;

import java.util.Arrays;

//238. Product of Array Except Self
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4, 5})));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        Arrays.fill(answer, 1);

        int current = 1;
        for (int i = 0; i < n; i++) {
            answer[i] = current;
            current *= nums[i];
        }

        current = 1;

        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= current;
            current *= nums[i];
        }

        return answer;
    }
}
