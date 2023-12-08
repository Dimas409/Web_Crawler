package IsPalindrome;

public class Main {
    public static void main(String[] args) {

    }
    public static boolean isPalindrome(int x){
        String s = Integer.toString(x);
        int first = 0;
        int finish =  s.length()-1;
        for (int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(first) != s.charAt(finish)){
                return false;

            }else {
                first++;
                finish--;
            }
        }
        return true;
    }
    public static boolean isPalindrome2(int x){
        // -Negative X can't be a palindrome.
        // -If we end with 0 we have to begin with 0
        if(x < 0 || (x % 10 == 0 && x != 0)) return false;
        int reversedNum = 0;
        //It is the number  to be checked for palindrome
        // Code to reverse a number
        while(x > reversedNum)
        {   // Append the last digit of x
            reversedNum = (reversedNum * 10) + x % 10;
            x /= 10;
        }
        // if given number equal to sum than number is palindrome otherwise not palindrome
        return reversedNum == x || x == reversedNum / 10;
        // Time Complexity: O(log10(N))
        // We divided the input by 10 for every iteration, so the time complexity is O(log10(n))
        // Where N = Input Number
        // Space Complexity: O(1)
    }
}
