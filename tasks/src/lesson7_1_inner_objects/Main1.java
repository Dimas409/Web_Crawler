package lesson7_1_inner_objects;

public class Main1 {
    public static void main(String[] args) {
        //Создать класс BlankCurrency (бумажная купюра) с полями номинал, тип (рубли, доллары...). Создать конструктор класса.
        //Создать класс CoinCurrency (монета) с полями номинал, тип. Создать конструктор класса.
        //Создать класс Wallet (кошелек) c полями blankCurrency и coinCurrency
        //Создать конструктор класса Wallet.
        //
        //
        //В мейне создать объект Wallet, проинициализировать его поля.
        //Вывести на консоль суммарную сумму в бумажнике.
        //
        //
        Blank blank = new Blank("RUB", 100);

        //private access
//        blank.nominal = -100;
//        blank.currency = "abc";

        blank.setNominal(50);
        System.out.println(blank.getNominal());

        Wallet wallet = new Wallet(blank, new Coin("RUB", 50));
        System.out.println("total sum: "+wallet.getTotalSumInRub());
        wallet.setBlank(new Blank("USD", 1000));
        System.out.println("total sum: "+wallet.getTotalSumInRub());

        System.out.println(wallet.getCoin().getNominal());


    }
}
//SOLID
//S - single responsibility (принцип единой ответственности)
//каждый класс должен отвечать только за самого себя и не брать на себя обязанности других классов



//Инкапсулция (от слова капсула) - когда класс скрывает прямой доступ к своим полям

class Wallet {
    private Blank blank;
    private Coin coin;

    public Wallet(Blank blank, Coin coin) {
        this.blank = blank;
        this.coin = coin;
    }

    double getTotalSumInRub() {
        return blank.getSumInRub() + coin.getSumInRub();
    }

    public Blank getBlank() {
        return blank;
    }

    public void setBlank(Blank blank) {
        this.blank = blank;
    }

    public Coin getCoin() {
        return coin;
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }
}

class Blank {
    private String currency;
    private int nominal;

    public Blank(String currency, int nominal) {
        this.currency = currency;
        this.nominal = nominal;
    }

    //геттер
    public int getNominal(){
        return nominal;
    }
    //сеттер
    public void setNominal(int nominal){
        this.nominal = nominal;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


    double getSumInRub(){
        double totalSum = 0;
        if (currency.equals("USD")) {
            totalSum += nominal * 70;
        } else if (currency.equals("EUR")) {
            totalSum += nominal * 75;
        } else {
            totalSum += nominal;
        }
        return totalSum;
    }
}


class Coin {
    private String currency;
    private int nominal;

    public Coin(String currency, int nominal) {
        this.currency = currency;
        this.nominal = nominal;
    }
    double getSumInRub(){
        double totalSum = 0;
        if (currency.equals("USD")) {
            totalSum += nominal * 70 / 100d;
        } else if (currency.equals("EUR")) {
            totalSum += nominal * 75 / 100d;
        } else {
            totalSum += nominal / 100d;
        }
        return totalSum;
    }

    public String getCurrency() {
        return currency;
    }

    public int getNominal() {
        return nominal;
    }
}
