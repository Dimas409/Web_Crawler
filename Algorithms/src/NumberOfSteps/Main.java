package NumberOfSteps;

public class Main {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
    }

    /**
     *   1342. Number of Steps to Reduce a Number to Zero
     *
     *   Given an integer num, return the number of steps to reduce it to zero.
     *
     * In one step, if the current number is even, you have to divide it by 2,
     * otherwise, you have to subtract 1 from it.
     */
    public static int numberOfSteps(int num) {
        int i = 0;
        while(num > 0){
            if(num % 2 == 0){ //((num & 1) == 0) Можно использовать побитовые операции.
                num /= 2; //num >> = 1;
            }else{
                num--;
            }
            i++;
        }
        return i;
        // Time Complexity: O(Log n)
        // Space Complexity: O(1)
    }
    public static int numberOfStepsStr(int num) {

        // Get the binary for num, as a String.
        String binaryString = Integer.toBinaryString(num);

        int steps = 0;
        // Iterate over all the bits in the binary string.
        for (char bit : binaryString.toCharArray()) {
            if (bit == '1') { // If the bit is a 1
                steps = steps + 2; // Then it'll take 2 to remove.
            } else { // bit == '0'
                steps = steps + 1; // Then it'll take 1 to remove.
            }
        }

        // We need to subtract 1, because the last bit was over-counted.
        return steps - 1;
    }
    public static int numberOfStepsBits(int num) {

        // We need to handle this as a special case, otherwise it'll return -1.
        if (num == 0) return 0;

        int steps = 0;

        for (int powerOfTwo = 1; powerOfTwo <= num; powerOfTwo = powerOfTwo * 2) {
            // Apply the bit mask to check if the bit at "powerOfTwo" is a 1.
            if ((powerOfTwo & num) != 0) {
                steps = steps + 2;
            } else {
                steps = steps + 1;
            }
        }

        // We need to subtract 1, because the last bit was over-counted.
        return steps - 1;
    }

}
