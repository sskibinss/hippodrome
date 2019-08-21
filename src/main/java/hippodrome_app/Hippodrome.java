package hippodrome_app;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses;
    static Hippodrome game;
    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<Horse>());
        Horse zoro = new Horse("Zoro",3,0);
        Horse wolf = new Horse("Wolf",3,0);
        Horse arka = new Horse("Arka",3,0);
        game.getHorses().add(zoro);game.getHorses().add(wolf);game.getHorses().add(arka);
        game.run();
        game.printWinner();
    }
    public Horse getWinner(){
        Horse winner = horses.get(0);
        for (int i = 1; i < horses.size(); i++) {
            if (horses.get(i).getDistance() > winner.getDistance())
                winner = horses.get(i);
        }
        return winner;
    }
    public void printWinner(){
        System.out.println(String.format("Winner is %s!",getWinner().getName()));
    }

    public void run() throws InterruptedException{
        for (int i = 1; i <=100 ; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move(){
        for (Horse horse:getHorses()) {
            horse.move();
        }
    }


    public void print(){
        for (Horse horse:getHorses()) {
            horse.print();
        }
        for (int i = 0; i < 10 ; i++) {
            System.out.println();
        }
    }
}
