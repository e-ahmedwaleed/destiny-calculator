package destiny.joe.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileReader {

    private final String fileLocation;
    private final String delimiter;

    public FileReader(String fileLocation, String delimiter) throws FileNotFoundException {
        this.fileLocation = fileLocation;
        this.delimiter = delimiter;
    }

    public String[][] read() throws IOException {
        int dataRowsCount = lineCounter();
        Scanner inputScanner = new Scanner(new File(fileLocation));
        return readFile(inputScanner, dataRowsCount);
    }

    private int lineCounter() throws IOException {
        Path path = Paths.get(fileLocation);
        return (int) Files.lines(path).count();
    }

    private String[] readLine(Scanner input) {
        String data = input.nextLine();
        return data.split(delimiter);
    }

    private String[][] readFile(Scanner input, int rows) {

        String[][] tmpArray = new String[rows][];

        int n = 0;
        while (input.hasNext()) {
            tmpArray[n] = readLine(input);
            n++;
        }

        return tmpArray;

    }

}
