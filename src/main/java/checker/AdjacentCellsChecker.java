package checker;

import wumpus.Cell;
import wumpus.Hunter;

import java.util.ArrayList;
import java.util.List;

public class AdjacentCellsChecker {

    private final Cell[][] map;
    private final int rowsCount;

    public AdjacentCellsChecker(Cell[][] map, int rowsCount) {
        this.map = map;
        this.rowsCount = rowsCount;
    }

    public void checkAdjacentCells(Hunter hunter) {
        List<Cell> adjacentCells = getAdjacentCells(hunter);
        if (adjacentCells.stream().anyMatch(c -> c == Cell.WUMPUS)) {
            System.out.println("Wumpus is close");
        }
        if (adjacentCells.stream().anyMatch(c -> c == Cell.WELL)) {
            System.out.println("A well is close");
        }
        if (adjacentCells.stream().anyMatch(c -> c == Cell.GOLD)) {
            System.out.println("The gold is close");
        }
        if (getFacingCell(hunter) == Cell.WALL) {
            System.out.println("The hunter is facing a wall");
        }
    }

    public Cell getFacingCell(Hunter hunter) {
        switch (hunter.getDirection()) {
            case NORTH:
                if (hunter.getRow() == 0) {
                    return Cell.WALL;
                }
                return map[hunter.getRow() - 1][hunter.getColumn()];
            case EAST:
                if (hunter.getColumn() == rowsCount - 1) {
                    return Cell.WALL;
                }
                return map[hunter.getRow()][hunter.getColumn() + 1];
            case SOUTH:
                if (hunter.getRow() == rowsCount - 1) {
                    return Cell.WALL;
                }
                return map[hunter.getRow() + 1][hunter.getColumn()];
            case WEST:
                if (hunter.getColumn() == 0) {
                    return Cell.WALL;
                }
                return map[hunter.getRow()][hunter.getColumn() - 1];
        }
        return map[hunter.getRow()][hunter.getColumn()];
    }

    private List<Cell> getAdjacentCells(Hunter hunter) {
        List<Cell> cells = new ArrayList<>();
        if (hunter.getRow() > 0) {
            cells.add(map[hunter.getRow() - 1][hunter.getColumn()]);
        }
        if (hunter.getColumn() > 0) {
            cells.add(map[hunter.getRow()][hunter.getColumn() - 1]);
        }
        if (hunter.getRow() < rowsCount - 1) {
            cells.add(map[hunter.getRow() + 1][hunter.getColumn()]);
        }
        if (hunter.getColumn() < rowsCount - 1) {
            cells.add(map[hunter.getRow()][hunter.getColumn() + 1]);
        }
        return cells;
    }
}
