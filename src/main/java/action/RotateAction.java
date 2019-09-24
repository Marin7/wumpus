package action;

import wumpus.Hunter;

public class RotateAction implements Action {
    @Override
    public void process(Hunter hunter) {
        hunter.rotate();
    }
}
