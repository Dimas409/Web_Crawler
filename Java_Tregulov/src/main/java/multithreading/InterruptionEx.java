package multithreading;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.concurrent.BlockingDeque;

public class InterruptionEx {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main starts");
        InterruptedThread thread = new InterruptedThread();
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
        thread.join();
        System.out.println("Main ends");

    }
}
class InterruptedThread extends Thread{
    double sqrtSum = 0;

    @Override
    public void run() {
        for (int i = 0; i <= 1000000000; i++) {
            if(isInterrupted()){
                System.out.println("Potok xotyat prervat");
                System.out.println("Mi ubedilis, chto sostoyanie " +
                        " vsex obyektov normalnoe i reshili zavershit rabotu potoka");
                System.out.println(sqrtSum);
                return;
            }
            sqrtSum += Math.sqrt(i);
            try {
                sleep(100);
            }catch (InterruptedException e){
                System.out.println("Поток хотят прервать во время сна." +
                        " Давайте завершим его работу");
                System.out.println(sqrtSum);
                return;
            }
        }
        System.out.println(sqrtSum);
    }
}
