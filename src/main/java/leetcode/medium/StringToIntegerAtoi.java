package leetcode.medium;

public class StringToIntegerAtoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("-22"));
    }

    public static int myAtoi(String s) {
        int res = 0;
        s = s.trim();
        byte sign;
        if (s.isEmpty()) {
            return 0;
        }
        if (s.charAt(0) == '-') {
            sign = -1;
        } else if (s.charAt(0) == '+') {
            sign = 1;
        } else if (s.charAt(0) >= '0' && s.charAt(0) <= '9') {
            res = (s.charAt(0) - '0');
            sign = 1;
        } else {
            return 0;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                long promRes = res * 10L + (s.charAt(i) - '0');
                if (promRes * sign <= Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                } else if (promRes * sign >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                res = (int) promRes;

            } else {
                return res * sign;
            }
        }
        return res * sign;
    }
}
