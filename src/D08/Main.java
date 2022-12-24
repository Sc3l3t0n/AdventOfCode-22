package D08;

import utils.FileReader;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main class for the Day 8 challenge.
 *
 * @author Marlon Rosenberg
 */
public class Main {

    /**
     * Main method for the Day 8 challenge.
     *
     * @param args Command line arguments.
     * @throws FileNotFoundException If the input file is not found.
     */
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = FileReader.readTheFile("src/D08/puzzleInput");

        DroneFootage droneFootage = new DroneFootage(scanner);
        droneFootage.convertInput();
        TreehouseSpotter treehouseSpotter = new TreehouseSpotter(droneFootage);
        // Puzzle 1
        System.out.println("Number of visible trees: " + treehouseSpotter.getNumberOfVisibleTrees());
        // Puzzle 2
        System.out.println("Highest scenic score: " + treehouseSpotter.getHighestScenicScore());

    }
}
