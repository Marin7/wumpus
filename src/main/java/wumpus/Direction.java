package wumpus;

public enum Direction {

    NORTH {
        @Override
        Direction rotate() {
            return EAST;
        }
    },

    EAST {
        @Override
        Direction rotate() {
            return SOUTH;
        }
    },

    SOUTH {
        @Override
        Direction rotate() {
            return WEST;
        }
    },

    WEST {
        @Override
        Direction rotate() {
            return NORTH;
        }
    };

    abstract Direction rotate();
}
