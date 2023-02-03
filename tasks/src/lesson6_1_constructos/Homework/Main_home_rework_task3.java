package lesson6_1_constructos.Homework;

import java.util.Objects;
import java.util.Scanner;

public class Main_home_rework_task3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Comment1[] comments = new Comment1[10];
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
                    Comment1 comment = new Comment1(author, textOfComment);
                    comment.cleanNegativeText();
                    comments[index] = comment;
                    comments[index].print();
                    index++;
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
                Comment1 maxComment = new Comment1(null, null);
                for (int i = 0; i < comments.length; i++) {
                    if (comments[i] != null && comments[i].countOfLike >= maxComment.countOfLike) {
                        maxComment = comments[i];
                    }
                }
                maxComment.print();

            }
            else if (input == 7) {
                Comment1 minComment = new Comment1(null, null);
                for (int i = 0; i < comments.length; i++) {
                    if (comments[i] != null && comments[i].countOfLike <= minComment.countOfLike) {
                        minComment = comments[i];

                    }
                }
                minComment.print();
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
class Comment1 {
    String author;
    String textOfComment;
    int countOfLike;
    int countOfDisLike;

    public Comment1(String author, String textOfComment) {
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