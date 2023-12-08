package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex2 {
    public static void main(String[] args) {
//        String s1 = "ABCD ABCE, ABCFABCGABCH";
//        Pattern pattern = Pattern.compile("ABC");
//        String s1 = "ABCOPABDOP";
//        Pattern pattern = Pattern.compile("AB[C-F]OP");
//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern = Pattern.compile("abc[^e-g4-7]");
//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern = Pattern.compile("abc(e|5)");
//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern = Pattern.compile("abc.");
//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern = Pattern.compile("abch$");
//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern = Pattern.compile("\\D");
//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern = Pattern.compile("\\w");
//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern = Pattern.compile("\\w+");
//        String s1 = "abcd!?abce=====abc ++abc5abcg6abch";
//        Pattern pattern = Pattern.compile("\\W+");
//        String s1 = "poka abc Zaur dom kino abctrakcionizm";
//        Pattern pattern = Pattern.compile("\\w{4}");
//        String s1 = "poka             abc               Zaur dom kino abctrakcionizm";
//        Pattern pattern = Pattern.compile("\\w\\S+\\w");
//        String s1 = "abcd abce3 abcfa78abcg6abch!!!!!!!!!!!!!!";
//        Pattern pattern = Pattern.compile("\\D{2,}");
//        String s1 = "ABCABABDA";
//        Pattern pattern = Pattern.compile("(AB){2,3}");
//        String s1 = "DABCDABABDABABABABD";
//        Pattern pattern = Pattern.compile("D(AB){2,}");
//        String s1 = "DABCDABABDA";
//        Pattern pattern = Pattern.compile("D(AB)*");
        String s1 = "abcd abce abcfabcgabch";
        Pattern pattern = Pattern.compile("[abcd][efgh3-8]");
        Matcher matcher = pattern.matcher(s1);
        while (matcher.find()){
            System.out.println("Position: " + matcher.start() +  " " + matcher.group());
        }
    }
}
