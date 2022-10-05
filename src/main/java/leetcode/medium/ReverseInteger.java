package leetcode.medium;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(-2147483642));
    }

    public static int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        x = x * sign;
        int result = 0;
        while (x > 0) {
            if (result * sign < Integer.MIN_VALUE / 10 || result * sign > Integer.MAX_VALUE / 10) {
                return 0;
            }
            result = result * 10 + x % 10;

            x /= 10;
        }
        return sign * result;
    }
}
