import java.util.Random;

public class ComputerKiller extends ComputerPlayer {
    Random rnd = new Random();
    String enemySymbol;
    int coin;
    public ComputerKiller(String[][] gameField, String symbol, String enemySymbol) {
        super(gameField, symbol);
        this.enemySymbol = enemySymbol;
    }
    private void searchSymbol(String s){
        boolean find = false;
        while (!find){
            int row = rnd.nextInt(gameField.length);
            int col = rnd.nextInt(gameField.length);
            if(gameField[row][col].equals(s)){
                gameField[row][col] = symbol;
                find = true;
            }
        }
    }
    @Override
    void makeStep() {
        sleep();
        boolean isSymbol = false;
        for (String[] strings : gameField) {
            for (int j = 0; j < gameField.length; j++) {
                if (strings[j].equals(enemySymbol)) {
                    isSymbol = true;
                    break;
                }
            }
        }
        if(isSymbol) {
            coin = rnd.nextInt(0,2);
            if(coin == 1){
                searchSymbol(enemySymbol);
            } else {
                searchSymbol(Game.EMPTY);
            }
        } else {
            searchSymbol(Game.EMPTY);
        }


    }

    @Override
    void sleep() {
        super.sleep();
    }
}
