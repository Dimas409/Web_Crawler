import java.util.Scanner;

public class HumanPlayer extends Player {
    Scanner scn = new Scanner(System.in);

    public HumanPlayer(String[][] gameField, String symbol) {
        super(gameField, symbol);
    }
    void makeStep(){
        boolean isRight = false;
        while (!isRight){
            System.out.println("Введите позицию в строке: ");
            int row = scn.nextInt();
            System.out.println("Введите номер столбца: ");
            int col = scn.nextInt();
            if (row > gameField.length || col > gameField.length){
                System.out.println("Такой ячейки не существует, попробуйте еще раз!");
            } else {
                if (gameField[row][col].equals(Game.EMPTY)){
                    gameField[row][col] = symbol;
                    isRight = true;
                } else {
                    System.out.println("Эта клетка занята, выберите другую!");
                }
            }
        }
    }

}
