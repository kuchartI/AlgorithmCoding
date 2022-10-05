package custom;

import java.util.HashMap;
import java.util.Map;

//Дан текст T и строка S. Требуется найти подстроку S' в T такую, что она совпадает с S с точностью до перестановки букв.
// Вернуть индекс начала подстроки в T
//T: abbbdcdef   S: cdb {b,2}
public class AnagramInText {
    public static void main(String[] args) {
        System.out.println(getSubString("ссadссссссфыв", "сссссфыв"));
    }

    private static int getSubString(String t, String s) {
        Map<Character, Integer> subS = new HashMap<>();
        Map<Character, Integer> subT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (subS.get(s.charAt(i)) != null) {
                subS.put(s.charAt(i), subS.get(s.charAt(i)) + 1);
            } else {
                subS.put(s.charAt(i), 1);
            }
        }
        int right = s.length();
        int left = 0;
        for (int i = 0; i < t.length(); i++) {
            if (subS.get(t.charAt(i)) != null) {
                if (subT.get(t.charAt(i)) != null) {
                    subT.put(t.charAt(i), subT.get(t.charAt(i)) + 1);
                } else {
                    subT.put(t.charAt(i), 1);
                }
                if (subS.equals(subT)) {
                    return i - (right - 1);
                } else if (left >= right - 1) {
                    subT.put(t.charAt(i - left), subT.get(t.charAt(i - left)) - 1);
                } else {
                    left++;
                }
            } else {
                subT.clear();
                left = 0;
            }
        }
        return -1;
    }
}
