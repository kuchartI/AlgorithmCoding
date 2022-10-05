package leetcode.medium;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("asdweraaaaaaar"));
    }

    private static String longestPalindrome(String s) {
        char[] c = s.toCharArray();
        int length = c.length;
        int[] longest = new int[] {0, 0};
        int[] even;
        int[] odd;
        for (int i = 0; i < length; i++) {
            odd = extendPalindrome(c, i, i);
            if (odd[1] - odd[0] > longest[1] - longest[0]) {
                longest = odd;
            }
            even = extendPalindrome(c, i, i + 1);
            if (even[1] - even[0] > longest[1] - longest[0]) {
                longest = even;
            }
        }

        return s.substring(longest[0] + 1, longest[1]);
    }

    private static int[] extendPalindrome(char[] c, int left, int right) {
        while (left >= 0 && right < c.length && c[left] == c[right]) {
            left--;
            right++;
        }

        return new int[] {left, right};
    }
}
