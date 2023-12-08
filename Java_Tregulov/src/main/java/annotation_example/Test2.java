package annotation_example;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.lang.annotation.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException, InterruptedException {
//        Class xiaomiClass = Class.forName("annotation_example.Xiaomi");
//        Annotation annotation1 = xiaomiClass.getAnnotation(SmartPhone.class);
//        SmartPhone sm1 = (SmartPhone) annotation1;
//        System.out.println("Annotation info from Xiaomi class: " +
//                sm1.OS() + ", " + sm1.yearOfCompanyCreation());
//
//        Class iphoneClass = Class.forName("annotation_example.Iphone");
//        Annotation annotation2 = iphoneClass.getAnnotation(SmartPhone.class);
//        SmartPhone sm2 = (SmartPhone) annotation2;
//        System.out.println("Annotation info from Iphone class: " +
//                sm2.OS() + ", " + sm2.yearOfCompanyCreation());

        ArrayList<Integer> integers = new ArrayList<>(List.of(3, 4 , 6 , 87, 93));
        LinkedHashMap<String, String> map = new LinkedHashMap<>(10, 7, true);
        map.put("Hi", "Hui");
        map.put("No", "Ne no");
        map.put("third", "word");
        System.out.println(map.get("Hi"));
        for(Map.Entry<String, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + entry.getValue());
        }


}
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhone{
    String OS() default "Android";
    int yearOfCompanyCreation() default 2010;

}
@SmartPhone
class Xiaomi{
    String model;
    double price;
}
@SmartPhone(OS = "IOS", yearOfCompanyCreation = 1976)
class Iphone{
    String model;
    double price;
}
