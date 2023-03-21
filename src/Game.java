
public class Game {
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
