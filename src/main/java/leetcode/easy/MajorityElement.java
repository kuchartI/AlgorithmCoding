package leetcode.easy;

//169. Majority Element

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    public static int majorityElement(int[] nums) {
        var result = 0;
        var counter = 0;
        for (int num : nums) {
            if (counter == 0) {
                result = num;
            }
            if (result == num) {
                counter++;
            } else {
                counter--;
            }
        }
        return result;
    }
}
