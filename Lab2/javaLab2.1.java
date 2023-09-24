import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static String findLongestSubstring(String s) {
        int startChar = 0;
        int endChar = 0;
        int maxLen = 0;
        int maxLengthStart = 0;
        Set<Character> uniqChars = new HashSet<>();

        while (endChar < s.length()) {
            char current = s.charAt(endChar);
            if (uniqChars.contains(current)) {
                if (endChar - startChar > maxLen) {
                    maxLen = endChar - startChar;
                    maxLengthStart = startChar;
                }
                while (s.charAt(startChar) != current) {
                    uniqChars.remove(s.charAt(startChar));
                    startChar++;
                }
                startChar++;
            } else {
                uniqChars.add(current);
            }
            endChar++;
        }

        if (endChar - startChar > maxLen) {
            maxLen = endChar - startChar;
            maxLengthStart = startChar;
        }

        String longestSubstring;
        if (maxLen == 0) {
            longestSubstring = "";
        } else {
            longestSubstring = s.substring(maxLengthStart, maxLengthStart + maxLen);
        }

        return longestSubstring;
    }

    public static void main(String[] args) {
        String input = "abcabcbb";
        String longestSubstring = findLongestSubstring(input);
        System.out.println("Наибольшая подстрока без повторяющихся символов: " + longestSubstring);
    }
}