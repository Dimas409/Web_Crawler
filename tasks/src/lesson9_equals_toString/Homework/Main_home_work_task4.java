package lesson9_equals_toString.Homework;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main_home_work_task4 {
    public static void main(String[] args) {
        //TODO: добавить конструкторы
        Scanner scn = new Scanner(System.in);
        int inputMainMenu = 0;
        while (inputMainMenu != 3){
            System.out.println("""
                    1. Книги
                    2. Фильмы""");
            inputMainMenu = scn.nextInt();
            if (inputMainMenu == 1) {
                ArrayList<Book> books = new ArrayList<>();
                int inputBooksMenu = 0;
                while (inputBooksMenu != 6) {
                    System.out.println("""
                    1. Добавить книгу в список книг (программа читает с консоли название, год и тип книги: школьная или нет. Смотрите пример ниже).
                    Книга должна добавляться в список только в том случае, если там ее еще нет. Повторов быть не должно. (используйте contains для проверки на наличие)
                    2. Вывести все книги
                    3. Вывести только школьные книги из списка книг
                    4. Вывести самую старую книгу (вывести название, год и forSchool с помощью toString)
                    5. Вывести самую старую школьную книгу (может быть сложно, поэтому оставьте это на конец)
                    6. Выход""");
                    inputBooksMenu = scn.nextInt();
                    int yearBook;
                    String schoolOrNo;
                    String nameBook;
                    if (inputBooksMenu == 1) {
                        System.out.println("Введите год выпуска книги: ");
                        yearBook = scn.nextInt();
                        System.out.println("Является ли книга школьной или нет? (введите да или нет)");
                        schoolOrNo = scn.next();
                        System.out.println("Введите название книги");
                        nameBook = scn.next();
                        //TODO заменить цикл на contains
                        boolean school = schoolOrNo.equals("да");
                        if (!books.contains(new Book(nameBook,yearBook,school))){
                           books.add(new Book(nameBook, yearBook, school));
                       } else {
                            System.out.println("Такая книга уже есть");
                        }
                    } else if (inputBooksMenu == 2) {
                        for (Book book : books) {
                            System.out.println(book);
                        }
                    } else if (inputBooksMenu == 3) {
                        for (Book book : books) {
                            if(book.isForSchool()){
                                System.out.println(book);
                            }
                        }
                    } else if (inputBooksMenu == 4) {
                        //TODO убрать второй цикл
                        int anyOldest = books.get(0).getYearOfRelease();
                        int maxOldestIndex = 0;
                        for (int i = 0; i < books.size(); i++) {
                            if(anyOldest > books.get(i).getYearOfRelease()){
                                anyOldest = books.get(i).getYearOfRelease();
                                maxOldestIndex = i;
                            }
                        }
                        System.out.println("Самая старая книга: " + books.get(maxOldestIndex).toString());
                    } else if (inputBooksMenu == 5) {
                        //TODO убрать второй цикл
                        int schoolOldest = books.get(0).getYearOfRelease();
                        int maxSchoolIndex = 0;
                        for (int i = 0; i < books.size(); i++) {
                            if (schoolOldest > books.get(i).getYearOfRelease() && books.get(i).isForSchool()){
                                schoolOldest = books.get(i).getYearOfRelease();
                                maxSchoolIndex = i;
                            }
                        }
                        System.out.println("Самая старая школьная книга: " + books.get(maxSchoolIndex).toString());
                    }
                }
            } else if (inputMainMenu == 2) {
                ArrayList<Film> films = new ArrayList<>();
                int inputFilmsMenu = 0;
                String filmName;
                int yearRelease;
                while (inputFilmsMenu != 4) {
                    System.out.println("""
                            1. Добавить фильм в список фильмов (программа читает с консоли название, год и time).
                            В список можно добавить новый фильм только в случае, если его еще нет в списке (то есть не должно быть повторов).
                            2. Узнать длительность фильма (юзер вводит название и год выпуска, программа выводит time, если такой фильм есть)
                            3. Вывести самый долгий фильм (вывести название, год и time с помощью toString)
                            4. Выход""");
                    inputFilmsMenu = scn.nextInt();
                    if (inputFilmsMenu == 1) {
                        boolean isExistFilm = false;
                        System.out.println("Введите название фильма");
                        filmName = scn.next();
                        System.out.println("Введите год выхода в прокат");
                        yearRelease = scn.nextInt();
                        System.out.println("Введите продолжительность фильма в минутах");
                        int durationFilm = scn.nextInt();
                        //TODO: заменить цикл на contains
                        if(!films.contains(new Film(filmName,yearRelease,0))){
                            films.add(new Film(filmName, yearRelease, durationFilm));
                        }else {
                            System.out.println("Такой фильм уже есть");
                        }
                        for (Film film: films){
                            System.out.println(film);
                        }
                    } else if (inputFilmsMenu == 2) {
                        System.out.println("Введите название фильма");
                        filmName = scn.next();
                        System.out.println("Введите год выхода в прокат");
                        yearRelease = scn.nextInt();
                        //TODO: заменить на indexOf
                        int indexFilm = films.indexOf(new Film(filmName,yearRelease,0));
                        System.out.println("Продолжительность фильма: " + films.get(indexFilm).getDurationOfFilm() + " мин.");

                    } else if (inputFilmsMenu == 3) {
                        //TODO: убрать второй цикл
                        int longestFilm = films.get(0).getDurationOfFilm();
                        int maxDurationIndex = 0;
                        for (int i = 0; i < films.size(); i++) {
                            if (films.get(i).getDurationOfFilm() > longestFilm) {
                                longestFilm = films.get(i).getDurationOfFilm();
                                maxDurationIndex = i;
                            }
                        }
                        System.out.println(films.get(maxDurationIndex).toString());
                    }
                }
            }


        }


    }
}
class Product {
    private String titleOfArt;
    private int yearOfRelease;

    public Product(String titleOfArt, int yearOfRelease) {
        this.titleOfArt = titleOfArt;
        this.yearOfRelease = yearOfRelease;
    }

    public String getTitleOfArt() {
        return titleOfArt;
    }

    public void setTitleOfArt(String titleOfArt) {
        this.titleOfArt = titleOfArt;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return yearOfRelease == product.yearOfRelease && Objects.equals(titleOfArt, product.titleOfArt);
    }

    @Override
    public String toString() {
        return "Название произведения: " + titleOfArt +
                ", год выпуска: " + yearOfRelease;
    }
}
class Book extends Product {
    private boolean forSchool;

    public Book(String titleOfArt, int yearOfRelease, boolean forSchool) {
        super(titleOfArt, yearOfRelease);
        this.forSchool = forSchool;
    }

    public boolean isForSchool() {
        return forSchool;
    }


    public void setForSchool(boolean forSchool) {
        this.forSchool = forSchool;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        //TODO: сравнить все три поля и без дублированного кода (через вызов родительского метода equals)
        return forSchool == book.forSchool && super.equals(book);
    }

    @Override
    public String toString() {
        return "Название книги: " + getTitleOfArt() +
                " Тип книги: " + (forSchool ? "для школы": " не для школы ") +
                " Год выпуска: " + getYearOfRelease();
    }
}
class Film extends Product {
    private int durationOfFilm;

    public Film(String titleOfArt, int yearOfRelease, int durationOfFilm) {
        super(titleOfArt, yearOfRelease);
        this.durationOfFilm = durationOfFilm;
    }

    public int getDurationOfFilm() {
        return durationOfFilm;
    }

    public void setDurationOfFilm(int durationOfFilm) {
        this.durationOfFilm = durationOfFilm;
    }

    @Override
    public String toString() {
        return "Название фильма: " + getTitleOfArt() +
                " Продолжительность фильма: " + durationOfFilm +
                " год выпуска: " + getYearOfRelease();
    }
}