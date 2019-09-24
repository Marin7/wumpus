package action;

import checker.GoldChecker;
import wumpus.Cell;
import wumpus.Hunter;

public class ExitAction implements Action {

    private final Cell[][] map;
    private final GoldChecker goldChecker;
    private boolean hasExited;

    public ExitAction(Cell[][] map, GoldChecker goldChecker) {
        this.map = map;
        this.goldChecker = goldChecker;
    }

    @Override
    public void process(Hunter hunter) {
        if (!canExit(hunter)) {
            return;
        }

        hasExited = true;
        if (goldChecker.hasGold()) {
            System.out.println("Congratulations, you have exited the game with the gold");
        } else {
            System.out.println("You have exited the game, but without the gold...");
        }
    }

    private boolean canExit(Hunter hunter) {
        return map[hunter.getRow()][hunter.getColumn()] == Cell.EXIT;
    }

    public boolean hasExited() {
        return hasExited;
    }
}
