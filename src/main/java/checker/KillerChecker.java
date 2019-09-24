package checker;

import wumpus.Cell;
import wumpus.Hunter;

public class KillerChecker {

    private final Cell[][] map;

    public KillerChecker(Cell[][] map) {
        this.map = map;
    }

    public boolean isCurrentCellKiller(Hunter hunter) {
        if (map[hunter.getRow()][hunter.getColumn()] == Cell.WUMPUS) {
            System.out.println("The wumpus killed the hunter...");
            return true;
        }

        if (map[hunter.getRow()][hunter.getColumn()] == Cell.WELL) {
            System.out.println("The hunter fell in a well...");
            return true;
        }
        return false;
    }
}
