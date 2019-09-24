package action;

import checker.AdjacentCellsChecker;
import org.junit.Test;
import org.mockito.Mockito;
import wumpus.Cell;
import wumpus.Direction;
import wumpus.Hunter;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotSame;
import static org.mockito.Mockito.when;

public class ThrowArrowActionTest {

    private Cell[][] map = new Cell[1][1];
    private AdjacentCellsChecker adjacentCellsChecker = Mockito.mock(AdjacentCellsChecker.class);

    private ThrowArrowAction subject = new ThrowArrowAction(map, 2, adjacentCellsChecker);

    @Test
    public void testWumpusGetsKilled() {
        map[0][0] = Cell.WUMPUS;
        Hunter hunter = new Hunter(0, 0, Direction.EAST);
        when(adjacentCellsChecker.getFacingCell(hunter)).thenReturn(Cell.WUMPUS);

        subject.process(hunter);

        assertEquals(Cell.EMPTY, map[0][0]);
    }

    @Test
    public void testMissedArrow() {
        map[0][0] = Cell.START;
        Hunter hunter = new Hunter(0, 0, Direction.EAST);
        when(adjacentCellsChecker.getFacingCell(hunter)).thenReturn(Cell.START);

        subject.process(hunter);

        assertNotSame(Cell.WUMPUS, map[0][0]);
    }

}
