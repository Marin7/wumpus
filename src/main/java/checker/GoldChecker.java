package checker;

import wumpus.Cell;
import wumpus.Hunter;

public class GoldChecker {

    private final Cell[][] map;
    private boolean hasGold;

    public GoldChecker(Cell[][] map) {
        this.map = map;
    }

    public void checkTheGoldCell(Hunter hunter) {
        if (!hasGold && map[hunter.getRow()][hunter.getColumn()] == Cell.GOLD) {
            hasGold = true;
            map[hunter.getRow()][hunter.getColumn()] = Cell.EMPTY;
        }
    }

    public boolean hasGold() {
        return hasGold;
    }
}
