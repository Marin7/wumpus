package wumpus;

import action.*;
import checker.AdjacentCellsChecker;
import checker.GoldChecker;
import checker.KillerChecker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    void play() {
        System.out.println("Welcome to the Wumpus game!");

        while (true) {
            System.out.println("Press 1 to start the game, 2 to see the rules or 3 to exit.");

            int command;
            try {
                command = Integer.parseInt(reader.readLine());

                switch (command) {
                    case 1:
                        startGame();
                        System.out.println("Game over!");
                        break;
                    case 2:
                        System.out.println("Rules: " +
                                "You are a hunter searching for the gold in a labyrinth and you have to exit without " +
                                "being killed by the Wumpus or falling into a well.\n" +
                                "At each moment you will know if the Wumpus is close, if a well is close or if the gold is close.\n" +
                                "Also, you will know when you kill the Wumpus, by throwing an arrow in it.\n" +
                                "You have 4 commands available: \n" +
                                "a - advance to the facing cell\n" +
                                "b - rotate 90 degrees to the right\n" +
                                "c - throw an arrow\n" +
                                "d - exit (if you are in the exit cell)\n");
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Invalid command");
                }
            } catch (IOException e) {
                System.out.println("Invalid command");
            }
        }
    }

    private void startGame() throws IOException {
        int rowsCount = ConsoleReaderHelper.getRowsCount(reader);
        int wellsCount = ConsoleReaderHelper.getWellsCount(reader, rowsCount);
        int arrowsCount = ConsoleReaderHelper.getArrowsCount(reader);

        Cell[][] map = new MapBuilder(rowsCount, wellsCount).buildMap();

        AdjacentCellsChecker adjacentCellsChecker = new AdjacentCellsChecker(map, rowsCount);
        GoldChecker goldChecker = new GoldChecker(map);
        KillerChecker killerChecker = new KillerChecker(map);

        Action advanceAction = new AdvanceAction(rowsCount);
        Action rotateAction = new RotateAction();
        Action throwArrowAction = new ThrowArrowAction(map, arrowsCount, adjacentCellsChecker);
        ExitAction exitAction = new ExitAction(map, goldChecker);

        System.out.println("The game begins!!!");

        Hunter hunter = getInitialHunter(map);

        while (true) {
            if (killerChecker.isCurrentCellKiller(hunter)) {
                return;
            }

            adjacentCellsChecker.checkAdjacentCells(hunter);
            goldChecker.checkTheGoldCell(hunter);

            String command = reader.readLine();
            switch (command) {
                case "a":
                    advanceAction.process(hunter);
                    break;
                case "b":
                    rotateAction.process(hunter);
                    break;
                case "c":
                    throwArrowAction.process(hunter);
                    break;
                case "d":
                    exitAction.process(hunter);
                    if (exitAction.hasExited()) {
                        return;
                    }
                    break;
                default:
                    System.out.println("Enter a valid command!");
            }
        }
    }

    private Hunter getInitialHunter(Cell[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == Cell.START) {
                    return new Hunter(i, j, Direction.EAST);
                }
            }
        }

        throw new RuntimeException("The starting cell is missing");
    }
}
