package multithreading;

import java.util.Objects;

public class Ex12 {
    static final Object lock = new Object();

    void mobileCall() {
        synchronized (lock) {
            System.out.println("Mobile call starts");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Mobile call ends");
        }
    }
    void skypeCall(){
        synchronized (lock) {
            System.out.println("Skype call starts");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Skype call ends");
        }
    }
    void whatAppCall(){
        synchronized (lock) {
            System.out.println("WhatsApp call starts");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("WhatsApp call ends");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnableImplMobile());
        Thread thread2 = new Thread(new RunnableImplSkype());
        Thread thread3 = new Thread(new RunnableImplWhatsApp());
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
class RunnableImplMobile implements Runnable{
    @Override
    public void run() {
       new Ex12().mobileCall();
    }
}
class RunnableImplSkype implements Runnable{
    @Override
    public void run() {
        new Ex12().skypeCall();
    }
}
class RunnableImplWhatsApp implements Runnable{
    @Override
    public void run() {
        new Ex12().whatAppCall();
    }
}
