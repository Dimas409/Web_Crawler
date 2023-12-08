package multithreading;

import java.util.concurrent.Semaphore;

public class SemaphoreEx {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        new Person("Zaur", semaphore);
        new Person("Oleg", semaphore);
        new Person("Elena", semaphore);
        new Person("Viktor", semaphore);
        new Person("Marina", semaphore);

    }
}
class Person extends Thread{
    String name;
    private Semaphore callBox;
    public Person(String name, Semaphore callBox){
        this.callBox = callBox;
        this.name = name;
        this.start();
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " ждёт...");
            callBox.acquire();
            System.out.println(name+ " пользуется телефоном");
            sleep(2000);
            System.out.println(name + " завершил(а) звонок");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            callBox.release();
        }
    }
}