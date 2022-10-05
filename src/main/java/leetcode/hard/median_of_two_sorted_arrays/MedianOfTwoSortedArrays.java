package leetcode.hard.median_of_two_sorted_arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{2, 2, 4, 4}, new int[]{2, 2, 4, 4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int counterNums1 = 0;
        int counterNums2 = 0;
        int[] mergedArray = new int[nums1.length + nums2.length];
        for (int i = 0; i < mergedArray.length; i++) {
            if (nums1.length > counterNums1 && nums2.length > counterNums2) {
                if (nums1[counterNums1] <= nums2[counterNums2]) {
                    mergedArray[i] = nums1[counterNums1++];
                } else if (nums1[counterNums1] > nums2[counterNums2]) {
                    mergedArray[i] = nums2[counterNums2++];
                }
            } else if (nums1.length == counterNums1) {
                mergedArray[i] = nums2[counterNums2++];
            } else {
                mergedArray[i] = nums1[counterNums1++];
            }
        }
        if (mergedArray.length % 2 == 0) {
            return (double) (mergedArray[mergedArray.length / 2] + mergedArray[mergedArray.length / 2 - 1]) / 2;
        } else {
            return mergedArray[mergedArray.length / 2];
        }
    }
}
