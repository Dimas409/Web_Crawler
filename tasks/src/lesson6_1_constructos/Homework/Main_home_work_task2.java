package lesson6_1_constructos.Homework;

public class Main_home_work_task2 {
    public static void main(String[] args) {

        Wallet wallet = new Wallet(100, "USD");
        wallet.currencyConverter();
        wallet.printInfo();

        Wallet wallet2 = new Wallet(150, "EUR");
        wallet2.currencyConverter();
        wallet2.printInfo();

        Wallet wallet3 = new Wallet(150, "RUB");
        wallet3.currencyConverter();
        wallet3.printInfo();
    }
}
class Wallet{
    double balance;
    String type; //Тип валюты (рубли, доллары, евро)
    double rub;
    public Wallet(double balance, String type) {
        this.balance = balance;
        this.type = type;
    }
    public void currencyConverter() {
        if(type.equals("USD")){
            rub = balance * 74;
        }
        else if(type.equals("EUR")){
            rub = balance * 95;
        }else{
            rub = balance;
        }
    }
    public void printInfo() {
        System.out.println("В бумажнике "+ rub +" руб.");
    }



}