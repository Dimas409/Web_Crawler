package lesson2;

public class Main3_max_min_sum {
    public static void main(String[] args) {
//        byte b = 1; //занимает 1 байт и позволяет вместит числа [-128;127]
//        short s = 2;  //занимает 2 байтa и позволяет вместит числа [-32255;32255]
//        int i = 10; //занимает 4 байтa и позволяет вместит числа [-2 147 483 648; 2 147 000 000]
//        long l = 20; //занимает 8 байтa и позволяет вместит числа [-9 223 372 036 854 775 808; 9 дофига]


        int[] arr = {200,-60,-10};
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Long.MIN_VALUE);
        int max = arr[0];
        int min = arr[0];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
            if(arr[i]>max){
                max = arr[i];
            }
            if(arr[i]<min){
                min = arr[i];
            }
            sum += arr[i];

        }
        System.out.println("\nmax = "+max);
        System.out.println("min = "+min);
        System.out.println("sum = "+sum);


    }
}
