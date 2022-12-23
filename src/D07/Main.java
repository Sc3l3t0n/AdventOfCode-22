package D07;

import utils.FileReader;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main class for Day 7
 *
 * @author Marlon Rosenberg
 */
public class Main {

    /**
     * Main method for Day 7
     *
     * @param args command line arguments
     * @throws FileNotFoundException if file is not found
     */
    public static void main(String[] args) throws FileNotFoundException {
        ComputerSystem computerSystem = new ComputerSystem(70000000);
        Scanner scanner = FileReader.readTheFile("src/D07/puzzleInput");
        Terminal terminal = new Terminal(computerSystem, scanner);

        terminal.run();
        scanner.close();
        computerSystem.updateAllSize();
        computerSystem.printSystem();
        System.out.println("Size of directories under 100000: " + computerSystem.getSizeOfDirectoriesUnderSize(100000));
        System.out.println("Smallest directory to make up enough space: " + computerSystem.getSmallestDirectoryToMakeUpEnoughSpace(computerSystem.getSpaceNeededToUpdate(30000000)));
    }
}
