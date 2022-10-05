package leetcode.easy;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(10101));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int numLength = String.valueOf(x).length();
        int left = 10;
        int right = (int) Math.pow(10, numLength - 1);
        while (x > 0) {
            if (x / right != x % left) {
                return false;
            } else {
                x = x % right / left;
                right = right / 100;
            }
        }
        return true;
    }
}
