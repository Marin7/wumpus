package wumpus;

import java.io.BufferedReader;
import java.io.IOException;

class ConsoleReaderHelper {

    static int getRowsCount(BufferedReader reader) throws IOException {
        System.out.println("Please introduce the number of rows: ");
        return Integer.parseInt(reader.readLine());
    }

    static int getWellsCount(BufferedReader reader, int rows) throws IOException {
        int wells;
        do {
            System.out.println("Please introduce the number of wells: ");
            wells = Integer.parseInt(reader.readLine());

            if (wells > rows * rows - 4) {
                System.out.println("The number of wells must be lower!");
            }
        } while (wells < 0 || wells > rows * rows - 4);

        return wells;
    }

    static int getArrowsCount(BufferedReader reader) throws IOException {
        System.out.println("Please introduce the number of arrows: ");
        return Integer.parseInt(reader.readLine());
    }
}
