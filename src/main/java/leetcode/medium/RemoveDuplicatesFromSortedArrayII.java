package leetcode.medium;

//80. Remove Duplicates from Sorted Array II
public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3}));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        var duplicateCounter = 0;
        var duplicate = 0;
        var previous = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == previous) {
                duplicate++;
            } else {
                duplicate = 0;
                previous = nums[i];
            }
            if (duplicate >= 2) {
                duplicateCounter++;
            }
            nums[i - duplicateCounter] = nums[i];
        }
        return nums.length - duplicateCounter;
    }
}
