import java.util.Random;

public class ComputerPlayer extends Player {
    Random rnd = new Random();

    public ComputerPlayer(String[][] gameField, String symbol) {
        super(gameField, symbol);
    }

    @Override
    void makeStep() {
        System.out.println("Ход компьютера");
        boolean isRight = false;
        while (!isRight){
            int row = rnd.nextInt(gameField.length);
            int col = rnd.nextInt(gameField.length);
            if(gameField[row][col].equals(Game.EMPTY)){
                gameField[row][col] = symbol;
                isRight = true;
            }
        }
    }
    void sleep(){
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
