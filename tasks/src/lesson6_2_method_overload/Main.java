package lesson6_2_method_overload;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        int res = calc.sum(2,3);
        double res2 = calc.sum(2.5, 4.3);
        int res3 = calc.sum("3", 4);
        int res4 = calc.sum(4, "3");
        int res5 = calc.sum("2", "3");


    }
}


class Calculator{
    //перегруженные методы:
    //Правила перегрузки:
    //1. Методы должны отличаться кол-во параметров
    //2. если кол-во параметров совпадает, они должны отличаться типами параметров
    //3. если кол-во и типы параметров совпадают, они должны отличаться порядком следвоания этих параметров
    //Перегруженные методы могут иметь разный тип возвращаемого значения
    int sum (int a,int b){
        return a+b;
    }

    double sum (double a,double b){
        return a+b;
    }
    int sum (String a,String b){
//        int i = Integer.parseInt(a); //"2" -> 2
        return Integer.parseInt(a)+Integer.parseInt(b);
    }

    int sum (String a,int b){
//        int i = Integer.parseInt(a); //"2" -> 2
        return Integer.parseInt(a)+b;
    }

    int sum (int a,String b){
        return Integer.parseInt(b)+a;
    }







}