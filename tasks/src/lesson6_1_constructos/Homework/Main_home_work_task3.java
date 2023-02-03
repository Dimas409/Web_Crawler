package lesson6_1_constructos.Homework;

import java.util.Objects;
import java.util.Scanner;

public class Main_home_work_task3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        //КАК ИСПОЛЬЗОВАТЬ NEXTLINE В КОМБИНАЦИИ С ДРУГИМИ МЕТОДАМИ
//        System.out.print("Enter age: ");
//        int age = scn.nextInt(); //""
//        System.out.print("Enter val: ");
//        //scn.nextLine();
//        //scn = new Scanner(System.in);
//        String val = scn.nextLine();
//        System.out.println("val = "+val);
//        System.out.println("age = "+age);



        Comment[] comments = new Comment[10];
//        comments[0] = new Comment("author1", "text1");
//        comments[1] = new Comment("author1", "Комментарий удален");
//        comments[2] = new Comment("author1", "text1");
        String author;
        String textOfComment;
        int index = 0;
        int input = 0;
        while (input != 9) {
            System.out.println("""
                    1. Добавить комментарий (пользователь вводит с консоли имя автора, текст)
                    2. Поставить лайк комментарию под индексом (пользователь вводит индекс комментария)
                    3. Поставить дизлайк под индексом
                    4. Очистить все нецензурные комментарии
                    5. Вывести все комментарии
                    6. Вывести текст и имя автора самого популярного комментария
                    7. Вывести текст и имя автора самого непопулярного комментария
                    8. Удалить комментарий автора (пользователь вводит имя автора. нужно не просто приравнять к null, 
                    а удалить его коммент из массива, но с сохранением размера самого массива)
                    9. Выход
                    """);
            input = scn.nextInt();
            if (input == 1) {
                if (index < comments.length) {
                    System.out.println("Введите автора: ");
                    scn.nextLine();
                    author = scn.nextLine();
                    System.out.println("Введите комментарий ");
                    textOfComment = scn.nextLine();
                    Comment comment = new Comment(author, textOfComment);
                    comment.cleanNegativeText();
                    comments[index] = comment;
                    comments[index].print();
                    index++; //2->3
                } else {
                    System.out.println("В массиве нет свободных мест");
                }

            }


            else if (input == 2) {
                System.out.println("Введите индекс комментария которому хотите поставить лайк: ");
                index = scn.nextInt(); //0
                if (comments[index]!=null && !comments[index].textOfComment.equals("Комментарий удален")) {
                    comments[index].addLike();
                }
            }
            else if (input == 3) {
                System.out.println("Введите индекс комментария которому хотите поставить дизлайк");
                index = scn.nextInt();
                if (comments[index]!=null && !comments[index].textOfComment.equals("Комментарий удален")) {
                    comments[index].addDisLike();
                }
            }
            else if (input == 4) {
                for (int i = 0; i < comments.length - 1; i++) {
                    if (comments[i] != null && comments[i].textOfComment.equals("Комментарий удален")) {
                        for (int j = i; j < comments.length - 1; j++) {
                            comments[j] = comments[j + 1];
                        }
                    }
                }
                comments[comments.length - 1] = null;
            }
            else if (input == 5) {
                for (int i = 0; i < comments.length; i++) {
                    if (comments[i] != null) {
                        comments[i].print();
                    }
                }
            }
            else if (input == 6) {
                Comment maxComment = new Comment(null, null);
                for (int i = 0; i < comments.length; i++) {
                    if (comments[i] != null && comments[i].countOfLike >= maxComment.countOfDisLike) {
                        maxComment = comments[i];
                    }
                }
                maxComment.print();

            }
            else if (input == 7) {
                //TODO: исправить поиск минимума
                int min = 0;
                for (int i = 0; i < comments.length; i++) {
                    if (comments[i] != null && comments[i].countOfLike <= min) {
                        min = comments[i].countOfLike;
                        comments[i].print();
                    }
                }
            }
            else if (input == 8) {
                System.out.println("Введите имя автора которого вы хотите удалить: ");
                author = scn.next();
                for (int i = 0; i < comments.length - 1; i++) {
                    if (comments[i] != null && Objects.equals(comments[i].author, author)) {
                        for (int j = i; j < comments.length - 1; j++) {
                            comments[j] = comments[j + 1];
                        }
                        break;

                    }
                }
                comments[comments.length - 1] = null;
            }
        }
    }
}


class Comment {
    String author;
    String textOfComment;
    int countOfLike;
    int countOfDisLike;

    public Comment(String author, String textOfComment) {
        this.author = author;
        this.textOfComment = textOfComment;
    }

    public void cleanNegativeText() {
        if (Objects.equals(textOfComment, "плохой коммент")) {
            textOfComment = "Комментарий удален";
            countOfLike = 0;
            countOfDisLike = 0;
        }
    }

    public void print() {
        System.out.println(" Имя автора: " + author + "\n коментарий: " + textOfComment +
                "\n количество лайков: " + countOfLike + "\n количество дизлайков: " + countOfDisLike + "\n");
    }

    public void addLike() {
        countOfLike += 1;
    }

    public void addDisLike() {
        countOfDisLike += 1;
    }
}
