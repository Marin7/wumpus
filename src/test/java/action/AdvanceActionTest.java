package action;

import org.junit.Test;
import wumpus.Direction;
import wumpus.Hunter;

import static org.junit.Assert.assertEquals;

public class AdvanceActionTest {

    private AdvanceAction subject = new AdvanceAction(4);

    @Test
    public void testAdvanceFromEast() {
        Hunter hunter = new Hunter(0, 0, Direction.EAST);

        subject.process(hunter);

        assertEquals(0, hunter.getRow());
        assertEquals(1, hunter.getColumn());
    }

    @Test
    public void testAdvanceFromSouth() {
        Hunter hunter = new Hunter(0, 0, Direction.SOUTH);

        subject.process(hunter);

        assertEquals(1, hunter.getRow());
        assertEquals(0, hunter.getColumn());
    }

    @Test
    public void testAdvanceFromWest() {
        Hunter hunter = new Hunter(1, 1, Direction.WEST);

        subject.process(hunter);

        assertEquals(1, hunter.getRow());
        assertEquals(0, hunter.getColumn());
    }

    @Test
    public void testAdvanceFromNorth() {
        Hunter hunter = new Hunter(1, 1, Direction.NORTH);

        subject.process(hunter);

        assertEquals(0, hunter.getRow());
        assertEquals(1, hunter.getColumn());
    }
}
