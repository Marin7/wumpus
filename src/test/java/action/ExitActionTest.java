package action;

import checker.GoldChecker;
import org.junit.Test;
import wumpus.Cell;
import wumpus.Direction;
import wumpus.Hunter;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class ExitActionTest {

    private Cell[][] cell = new Cell[1][1];
    private ExitAction subject = new ExitAction(cell, new GoldChecker(cell));

    @Test
    public void testExitSuccessfully() {
        Hunter hunter = new Hunter(0, 0, Direction.EAST);
        cell[0][0] = Cell.EXIT;

        subject.process(hunter);

        assertTrue(subject.hasExited());
    }

    @Test
    public void testDontExitUnlessExitCell() {
        Hunter hunter = new Hunter(0, 0, Direction.EAST);
        cell[0][0] = Cell.EMPTY;

        subject.process(hunter);

        assertFalse(subject.hasExited());
    }
}
