package leetcode.medium;

import java.util.Arrays;

//189. Rotate Array
public class RotateArray {
    public static void main(String[] args) {
        var nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        if (k >= nums.length) {
            k = k % nums.length;
        }
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    public static void reverse(int[] nums, int from, int to) {
        while (from < to) {
            var number = nums[from];
            nums[from] = nums[to];
            nums[to] = number;
            from++;
            to--;
        }
    }
}
