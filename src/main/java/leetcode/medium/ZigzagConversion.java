package leetcode.medium;

public class ZigzagConversion {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
        //P     I    N
        //A   L S  I G
        //Y A   H R
        //P     I
    }

    private static String convert(String s, int numRows) {
        StringBuilder result = new StringBuilder();
        int space = numRows + numRows - 2;
        if (space == 0) {
            return s;
        }
        for (int i = 0; i < numRows; i++) {
            int left = i;
            int right = space - i;
            while (left < s.length()) {
                result.append(s.charAt(left));
                if (right < s.length() && (i != 0 && i != numRows - 1)) {
                    result.append(s.charAt(right));
                }
                left += space;
                right += space;
            }
        }
        return result.toString();
    }
}
