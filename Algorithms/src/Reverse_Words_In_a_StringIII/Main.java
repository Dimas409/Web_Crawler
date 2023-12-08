package Reverse_Words_In_a_StringIII;

import java.util.*;

import static java.util.Collections.*;

public class Main {
    public static void main(String[] args) {
        String s = "a good   example";
        char[] arrChars = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        reverseWords2_1(arrChars);

        System.out.println(Arrays.toString(arrChars));

    }
    public static String reverseWords3(String s){
        String[] arr = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String s1 : arr) {
            char[] chars = s1.toCharArray();
            for (int i = 0; i < chars.length/2; i++) {
                char temp = chars[i];
                chars[i] = chars[chars.length - i - 1];
                chars[chars.length - i - 1] = temp;
            }
            String reversedStr = new String(chars);
            sb.append(reversedStr).append(" ");

        }
        return sb.toString().strip();
    }
    public static String reverseWords1(String s){
        String s1 = s.strip();
        String[] arr = s1.split("\\s+");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length/2; i++) {
            String t = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = t;
        }
        Arrays.stream(arr).forEach(s2 -> sb.append(s2).append(" "));

        return sb.toString().strip();
    }
    public static String reverseWords1_1(String s){
        s = s.strip();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
        // Time complexity: O(n)
        // Space complexity: O(n)
    }

    // 186. Reverse Words in a String II First Approach
    public static void reverse(char[] s, int left, int right){
        while (left < right){
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }
    public static void reverseEachWord(char[] s){
        int n = s.length;
        int start = 0, end = 0;
        while (start < n){
            // go to the end of the word
            while (end < n && s[end] != ' ') ++end;
            // reverse the word
            reverse(s, start, end - 1);
            // move to the next word
            start = end + 1;
            ++end;
        }
    }
    public static void reverseWords2_1(char[] s) {
        // reverse the whole string
        reverse(s, 0, s.length - 1);
        reverseEachWord(s);
    }
    // Time complexity: O(n), it's two passes along the string
    // Space complexity: O(1), it's a constant space solution


    // Закавыристый способ перевернуть строку
    public static StringBuilder trimSpaces(String s){
        int left = 0, right = s.length() -1;
        // remove leading spaces
        while (left <= right && s.charAt(left) == ' ') ++left;

        // remove trailing spaces
        while (left <= right && s.charAt(right) == ' ') --right;

        // reduce multiple spaces to single one
        StringBuilder sb  = new StringBuilder();
        while (left <= right){
            char c = s.charAt(left);

            if(c != ' ') sb.append(c);
            else if(s.charAt(sb.length() - 1) != ' ') sb.append(c);
            ++left;
        }
        return sb;
    }
    public static void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
    }
    public static void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;
        while (start < n) {
            // go to the end of the word
            while (end < n && sb.charAt(end) != ' ') ++end;
            // reverse the word
            reverse(sb, start, end -1);
            // move to the next word
            start = end + 1;
            ++end;
        }
    }
    public static String reverseWords(String s) {
        // converts string to string builder
        // and trim spaces at the same time
        StringBuilder sb = trimSpaces(s);

        // reverse the whole string
        reverse(sb, 0, sb.length() -1);

        //reverse each word
        reverseEachWord(sb);
        return sb.toString();
        // Time complexity: O(n)
        // Space complexity: O(n)
    }
    public static String reverseWords1_2(String s) {
        int left = 0, right = s.length() -1;
        // remove leading spaces
        while (left <= right && s.charAt(left) == ' ') ++left;

        // remove trailing spaces
        while (left <= right && s.charAt(right) == ' ') --right;

        Deque<String> d = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();
        // push word by word in front of deque
        while (left <= right) {
            char c = s.charAt(left);
            if((word.length() != 0) && (c == ' ')) {
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if(c != ' ') {
                word.append(c);
            }
            ++left;
        }
        d.offerFirst(word.toString());
        return String.join(" ", d);

        //Time complexity: O(n)
        //Space complexity: O(n)
    }
    public static String reverseWords3_1(String s) {
        StringBuilder result = new StringBuilder();
        int lastSpaceIndex = -1;
        for (int strIndex = 0; strIndex < s.length(); strIndex++) {
            if ((strIndex == s.length() - 1) || s.charAt(strIndex) == ' ') {
                int reverseStrIndex = (strIndex == s.length() - 1) ? strIndex : strIndex - 1;
                for (; reverseStrIndex > lastSpaceIndex; reverseStrIndex--) {
                    result.append(s.charAt(reverseStrIndex));
                }
                if (strIndex != s.length() - 1) {
                    result.append(' ');
                }
                lastSpaceIndex = strIndex;
            }
        }
        return new String(result);
        //Time Complexity: O(N)\mathcal{O}(N)O(N) Every character in the string is traversed twice. First,
        // to find the end of the current word, and second to reverse the word and append it to the result.
        // Thus the time complexity is, O(N+N)=O(N).
        //
        //Space Complexity: O(1)\mathcal{O}(1)O(1) We use constant extra space to track the last space index.
        // You could also argue that we are using O(n) space to build the output string
        // (we normally don't count the output as part of the space complexity,
        // but in this case we are temporarily using some space to build it).
    }
}
