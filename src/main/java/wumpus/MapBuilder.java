package wumpus;

import java.util.Random;

class MapBuilder {

    private final int rowsCount;
    private final int wellsCount;
    private final Cell[][] map;
    private final Random random = new Random();

    MapBuilder(int rowsCount, int wellsCount) {
        this.rowsCount = rowsCount;
        this.wellsCount = wellsCount;
        map = new Cell[rowsCount][rowsCount];
    }

    Cell[][] buildMap() {
        initMap();
        generateWells();
        generateCellAtRandomPosition(Cell.WUMPUS);
        generateCellAtRandomPosition(Cell.EXIT);
        generateCellAtRandomPosition(Cell.GOLD);
        generateCellAtRandomPosition(Cell.START);

        return map;
    }

    private void generateWells() {
        for (int i = 0; i < wellsCount; i++) {
            generateCellAtRandomPosition(Cell.WELL);
        }
    }

    private void generateCellAtRandomPosition(Cell cell) {
        int randomRow, randomColumn;
        do {
            randomRow = random.nextInt(rowsCount);
            randomColumn = random.nextInt(rowsCount);
        } while (map[randomRow][randomColumn] != Cell.EMPTY);

        map[randomRow][randomColumn] = cell;
    }

    private void initMap() {
        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < rowsCount; j++) {
                map[i][j] = Cell.EMPTY;
            }
        }
    }
}
