package lesson4_1_double_arrays.Homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main_home_work_task4 {
    public static void main(String[] args) {
//        Задача 4 Создать учебное расписание для школьника с понедельника по пятницу включительно.
//        Каждый день у школьника проходит по 3 урока.
//        Список возможных уроков: математика, русский, английский, литература, биология, химия, история.
//        Заполнение предметами сделать через Random.
//
//        Вывести расписание на консоль в формате:
//        Пн: математика, английский, история
//....
//        Пт: биология, математика, химия
//
//        Далее пользователь должен иметь возможность один раз изменить
//        любой предмет в любой день недели.
//        К примеру, школьник хочет заменить в пятницу биологию на русский.
//        Для этого юзер вводит с консоли день недели, заменяемый предмет и новый предмет.
//        После сделанных изменений нужно вывести расписание на консоль и проверить, что изменения вступили в силу
        String[][] timeTable = new String[5][3];
        Random rnd = new Random();
        String[] dayOfWeek = {"Понедельник", "Вторник", "Среда", "Четверг", "Пятница"};
        String[] lessons = {"математика", "русский", "английский", "литература", "биология",
                "химия", "история"};

        for (int i = 0; i < timeTable.length; i++) {
            for (int j = 0; j < timeTable[i].length; j++) {
                int randomLessons = rnd.nextInt(lessons.length);
                timeTable[i][j] = lessons[randomLessons];
            }
            System.out.println(dayOfWeek[i] + Arrays.toString(timeTable[i]));
//            if (i == 0) {
//                System.out.println("Понедельник" + Arrays.toString(timeTable[i]));
//            }
//            if (i == 1) {
//                System.out.println("Вторник" + Arrays.toString(timeTable[i]));
//            }
//            if (i == 2) {
//                System.out.println("Среда" + Arrays.toString(timeTable[i]));
//            }
//            if (i == 3) {
//                System.out.println("Четверг" + Arrays.toString(timeTable[i]));
//            }
//            if (i == 4) {
//                System.out.println("Пятница" + Arrays.toString(timeTable[i]));
//            }
        }
        Scanner scn = new Scanner(System.in);

        System.out.println("Введите день недели" +
                " в котором вы хотите заменить урок: ");
        String day = scn.next();
        for (int i = 0; i < dayOfWeek.length; i++){
           if (day.equals(dayOfWeek[i])){
               System.out.println("Введите предмет который вы хотите заменить: ");
               String lessonOut = scn.next();
               System.out.println("Введите предмет на который вы хотите заменить: ");
               String lessonIn = scn.next();
               String[] arr = timeTable[i];
               for (int j = 0; j < arr.length; j++) {
                   if (lessonOut.equals(arr[j])) {
                       arr[j] = lessonIn;
                   }
               }
           }

        }


//        String[] arr = timeTable[dayOfWeek.length];
//        for (int i = 0; i < arr.length; i++) {
//            if (lessonOut.equals(arr[i])) {
//                arr[i] = lessonIn;
//            }
//        }

        for (int i = 0; i < timeTable.length; i++) {
            for (int j = 0; j < timeTable[i].length; j++) {
            }
            System.out.println(dayOfWeek[i] + Arrays.toString(timeTable[i]));
//            if (i == 0) {
//                System.out.println("Понедельник" + Arrays.toString(timeTable[i]));
//            }
//            if (i == 1) {
//                System.out.println("Вторник" + Arrays.toString(timeTable[i]));
//            }
//            if (i == 2) {
//                System.out.println("Среда" + Arrays.toString(timeTable[i]));
//            }
//            if (i == 3) {
//                System.out.println("Четверг" + Arrays.toString(timeTable[i]));
//            }
//            if (i == 4) {
//                System.out.println("Пятница" + Arrays.toString(timeTable[i]));
//            }
        }


    }
}
