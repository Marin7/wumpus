package action;

import wumpus.Hunter;

public class AdvanceAction implements Action {

    private final int rowsCount;

    public AdvanceAction(int rowsCount) {
        this.rowsCount = rowsCount;
    }

    @Override
    public void process(Hunter hunter) {
        int currentRow = hunter.getRow();
        int currentColumn = hunter.getColumn();

        switch (hunter.getDirection()) {
            case NORTH:
                if (currentRow == 0) {
                    System.out.println("Can not advance.");
                    break;
                }
                hunter.setRow(currentRow - 1);
                break;
            case EAST:
                if (currentColumn == rowsCount - 1) {
                    System.out.println("Can not advance.");
                    break;
                }
                hunter.setColumn(currentColumn + 1);
                break;
            case SOUTH:
                if (currentRow == rowsCount - 1) {
                    System.out.println("Can not advance.");
                    break;
                }
                hunter.setRow(currentRow + 1);
                break;
            case WEST:
                if (currentColumn == 0) {
                    System.out.println("Can not advance.");
                    break;
                }
                hunter.setColumn(currentColumn - 1);
                break;
        }
    }
}
