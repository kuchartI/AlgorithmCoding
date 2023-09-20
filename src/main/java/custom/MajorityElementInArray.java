package custom;

//The majority element is that elements that appears more than n/2 times.
// You may assume that the majority element always exist in array
//[2,2,1,1,1,2,2] - 2
public class MajorityElementInArray {

    private static int majorityElement(int[] nums) {
        int majority = nums[0];
        int counter = 1;
        for (int i = 1; i < nums.length; i++) {
            if (counter == 0) {
                majority = nums[i];
                counter = 1;
            } else if (majority == nums[i]) {
                counter++;
            } else {
                counter--;
            }

        }
        return majority;
    }

    public static void main(String[] args) {
        System.out.println("The majority element " + majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2, 3, 2, 2}));
    }
}
