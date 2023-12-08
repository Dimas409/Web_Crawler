package Polindrom;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
//        String s1 = " ";
        String s2 = "0P";
//        String str = s.replaceAll("[^A-Za-z]","").toLowerCase();
//        String s3 = s2.replaceAll("[^A-Za-z]", "");
//        System.out.println(s3);
//        System.out.println(str);
//        System.out.println(isPalindrome(s));
//        System.out.println(isPalindrome(s1));
        System.out.println(isPalindrome(s2));
    }
    public static boolean isPalindrome(String s){
        if(s == null) return false;
        if(s.isEmpty()) return true;
        String str = s.replaceAll("[^A-Za-z0-9]","");
        String s1 = str.toLowerCase();
        int start = 0;
        int finish = s1.length() - 1;
        for (int i = 0; i < s1.length()/2; i++) {
            if(s1.charAt(start) != s1.charAt(finish)){
                return false;
            }else {
                    start++;
                    finish--;
            }
        }
        return true;
    }
}
