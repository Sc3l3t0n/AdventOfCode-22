package D08;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to convert the input into a 2D ArrayList.
 *
 * @author Marlon Rosenberg
 */
public class DroneFootage {

    private final Scanner scanner;
    private final ArrayList<ArrayList<Integer>> treeMap = new ArrayList<>();

    /**
     * Constructor for the DroneFootage class.
     *
     * @param scanner Scanner to read the input.
     */
    public DroneFootage(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Converts the input into a 2D ArrayList.
     */
    public void convertInput() {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] lineArray = line.split("");
            ArrayList<Integer> lineArrayList = new ArrayList<>();
            for (String s : lineArray) {
                lineArrayList.add(Integer.parseInt(s));
            }
            treeMap.add(lineArrayList);
        }
    }

    /**
     * Returns for the treeMap as 2D ArrayList.
     *
     * @return the treeMap as 2D ArrayList.
     */
    public ArrayList<ArrayList<Integer>> getTreeMap() {
        return treeMap;
    }

}
