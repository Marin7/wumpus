package action;

import checker.AdjacentCellsChecker;
import wumpus.Cell;
import wumpus.Hunter;

public class ThrowArrowAction implements Action {

    private final Cell[][] map;
    private final AdjacentCellsChecker adjacentCellsChecker;

    private int arrowsCount;

    public ThrowArrowAction(Cell[][] map, int arrowsCount, AdjacentCellsChecker adjacentCellsChecker) {
        this.map = map;
        this.arrowsCount = arrowsCount;
        this.adjacentCellsChecker = adjacentCellsChecker;
    }

    @Override
    public void process(Hunter hunter) {
        if (arrowsCount == 0) {
            System.out.println("Sorry! No more arrows...");
            return;
        }

        Cell cell = adjacentCellsChecker.getFacingCell(hunter);
        if (cell == Cell.WUMPUS) {
            System.out.println("You have killed the Wumpus!!!");
            removeWumpus();
        }
        arrowsCount--;
    }

    private void removeWumpus() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == Cell.WUMPUS) {
                    map[i][j] = Cell.EMPTY;
                    return;
                }
            }
        }

        throw new RuntimeException("The wumpus cell is missing");
    }
}
