package wumpus;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        try {
            game.play();
        } catch (Exception e) {
            System.out.println("There was an exception during the game: ");
            e.printStackTrace();
        }
    }
}
