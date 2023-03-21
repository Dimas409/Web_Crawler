import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class Game {
    Scanner scn = new Scanner(System.in);
    private final String[][] gameField = new String[3][3];
    public static final String X = "|X|";
    public static final String O = "|O|";
    public static final String EMPTY = "|_|";
    public Game(){
        init();
    }
    public void init(){
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField.length; j++) {
                gameField[i][j] = EMPTY;
            }

        }
    }
    public void startGame(){
        System.out.println("1. Human vs Human");
        System.out.println("2. Human vs Computer");
        System.out.println("3. Computer vs Computer");
        System.out.println("4. Human vs ComputerKiller");
        int input = scn.nextInt();
        Player player1 = null;
        Player player2 = null;
        switch (input){
            case 1 -> {
                player1 = new HumanPlayer(gameField, X);
                player2 = new HumanPlayer(gameField, O);
            }
            case 2 -> {
                player1 = new HumanPlayer(gameField, X);
                player2 = new ComputerPlayer(gameField, O);
            }
            case 3 -> {
                player1 = new ComputerPlayer(gameField, X);
                player2 = new ComputerPlayer(gameField, O);
            }
            case 4 -> {
                player1 = new HumanPlayer(gameField, X);
                player2 = new ComputerKiller(gameField, O, X);
            }
        }
        int turn = 0;
        while (!checkDraw() && !checkWinner()){
            toString();
            if(turn % 2 == 0) {
                player1.makeStep();
            }else {
                player2.makeStep();
            }
            turn++;
        }
        toString();
    }

    public boolean checkWinner(){
        for (int i = 0; i < gameField.length; i++) {
            if(gameField[i][0].equals(X) && gameField[i][1].equals(X) && gameField[i][2].equals(X) ||
               gameField[0][i].equals(X) && gameField[1][i].equals(X) && gameField[2][i].equals(X) ||
               gameField[0][0].equals(X) && gameField[1][1].equals(X) && gameField[2][2].equals(X) ||
               gameField[2][0].equals(X) && gameField[1][1].equals(X) && gameField[0][2].equals(X)){
                System.out.println("Победа крестиков");
                return true;
            } else if (gameField[i][0].equals(O) && gameField[i][1].equals(O) && gameField[i][2].equals(O) ||
                       gameField[0][i].equals(O) && gameField[1][i].equals(O) && gameField[2][i].equals(O) ||
                       gameField[0][0].equals(O) && gameField[1][1].equals(O) && gameField[2][2].equals(O) ||
                       gameField[2][0].equals(O) && gameField[1][1].equals(O) && gameField[0][2].equals(O)) {
                System.out.println("Победа ноликов");
            }
        }
        return false;
    }
    public boolean checkDraw(){
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField.length; j++) {
                if(gameField[i][j].equals(EMPTY)){
                    return false;
                }
            }
        }
        System.out.println("Ничья");
        return true;
    }

    @Override
    public String toString() {
        for(String[] field: gameField){
            for(String field1: field){
                System.out.print(field1);
            }
            System.out.println();
        }
        System.out.println();
        return "";
    }

}
