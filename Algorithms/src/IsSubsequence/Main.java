package IsSubsequence;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println(isSubsequence2("", "abc"));



    }
    public static boolean isSubsequence(String s, String t){
        if(s.length() == 0) return false;
        int indexS = 0;
        for (int i = 0; i < t.length(); i++) {
            if(t.charAt(i) == s.charAt(indexS)){
                indexS++;
            }
            if(indexS == s.length()){
                return true;
            }
        }
        return false;
    }
    public static boolean isSubsequence2(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

}
