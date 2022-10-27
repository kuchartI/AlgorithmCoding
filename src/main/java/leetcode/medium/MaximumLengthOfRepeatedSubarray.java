package leetcode.medium;

class MaximumLengthOfRepeatedSubarray {
    public static void main(String[] args) {
        System.out.println(findLength(new int[]{2, 3, 2, 1}, new int[]{3, 2, 1, 4}));
    }
    //718. Maximum Length of Repeated Subarray
    public static int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        int result = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = i > 0 && j > 0 ? dp[i - 1][j - 1] + 1 : dp[i][j] + 1;
                    if (result < dp[i][j]) {
                        result = dp[i][j];
                    }
                }
            }
        }
        return result;
    }
}