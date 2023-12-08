
public class Main {
    private static boolean ready;
    public static int number;
    private static class ReaderThread extends Thread{
        public void run(){
            while (!ready){
                Thread.yield();
                System.out.println(number);

            }
        }
    }
    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;




    }

//    public static int firstEl(int[] arr){
//        HashMap<Integer, Integer> map = new LinkedHashMap<>();
//
//        for (int i : arr) {
//            map.put(i, map.getOrDefault(i, 0) + 1);
//        }
//
//        for (int i : arr) {
//            if(map.get(i) == 1){
//                return i;
//            }
//        }
//        throw new RuntimeException();
//    }



}
