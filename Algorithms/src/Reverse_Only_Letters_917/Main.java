package Reverse_Only_Letters_917;

public class Main {
    public static void main(String[] args) {
        String s = "a-bC-dEf-ghIj";
        System.out.println(reverseOnlyLetters(s));

    }
    public static String reverseOnlyLetters(String s){
        char[] chars = s.toCharArray();
        int left = 0, right = s.length() -1;
        while (left < right){
            if(Character.isLetter(chars[left]) && Character.isLetter(chars[right])){
                char temp = chars[left];
                chars[left++] = chars[right];
                chars[right--] = temp;
            } else if (!Character.isLetter(chars[left])) {
                left++;
            } else {
                right--;
            }
        }
        return new String(chars);
    }
}
