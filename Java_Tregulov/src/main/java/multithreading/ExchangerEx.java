package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerEx {
    public static void main(String[] args) {
        Exchanger<Action> exchanger= new Exchanger<>();
        List<Action> friend1Action = new ArrayList<>();
        friend1Action.add(Action.SCISSORS);
        friend1Action.add(Action.SHEET);
        friend1Action.add(Action.SCISSORS);
        List<Action> friend2Action = new ArrayList<>();
        friend2Action.add(Action.SHEET);
        friend2Action.add(Action.STONE);
        friend2Action.add(Action.STONE);
        new BestFriend("Vanya", friend1Action, exchanger);
        new BestFriend("Petya", friend2Action, exchanger);
    }
}
enum Action{
    STONE, SCISSORS, SHEET;
}
class BestFriend extends Thread{
    private String name;
    private List<Action> myActions;
    private Exchanger<Action> exchanger;
    public BestFriend(String name, List<Action> myActions, Exchanger<Action> exchanger){
        this.name = name;
        this.myActions = myActions;
        this.exchanger = exchanger;
        this.start();
    }
    private void whoWins (Action myAction, Action friendsAction){
        if((myAction == Action.STONE && friendsAction == Action.SCISSORS)
        || (myAction == Action.SCISSORS && friendsAction == Action.SHEET)
        || (myAction == Action.SHEET && friendsAction == Action.STONE)){
            System.out.println(name + " WINS!!!");
        }
    }

    @Override
    public void run() {
        Action reply;
        for (Action action : myActions) {
            try {
                reply = exchanger.exchange(action);
                whoWins(action, reply);
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}