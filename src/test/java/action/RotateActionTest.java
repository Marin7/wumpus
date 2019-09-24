package action;

import org.junit.Test;
import wumpus.Direction;
import wumpus.Hunter;

import static junit.framework.TestCase.assertEquals;

public class RotateActionTest {

    private final RotateAction subject = new RotateAction();

    @Test
    public void testRotation() {
        Hunter hunter = new Hunter(0, 0, Direction.EAST);

        subject.process(hunter);

        assertEquals(Direction.SOUTH, hunter.getDirection());
    }
}
