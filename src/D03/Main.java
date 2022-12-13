package D03;

import utils.FileReader;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = FileReader.readTheFile("src/D03/puzzleInput");
        int prioritySum = 0;


        // First Puzzle
        while (scanner.hasNextLine()) {

            String nextLine = scanner.nextLine();

            BackpackSort bps = new BackpackSort(nextLine);

            System.out.println(nextLine + "(" + nextLine.length() + ")" + " : " + Arrays.toString(bps.getCompartmentOne()) + " + " + Arrays.toString(bps.getCompartmentTwo()));
            System.out.println(bps.getIdentifier() + " : " + bps.getPriorityValue());

            prioritySum += bps.getPriorityValue();
        }

        System.out.println(prioritySum);

        scanner.close();

        // Second Puzzle

        scanner = FileReader.readTheFile("src/D03/puzzleInput");

        prioritySum = 0;

        while (scanner.hasNextLine()) {

            String nextLine = scanner.nextLine();
            String nextNextLine = scanner.nextLine();
            String nextNextNextLine = scanner.nextLine();

            BackpackSortGroups bps = new BackpackSortGroups(nextLine, nextNextLine, nextNextNextLine);

            prioritySum += bps.getPriorityValue();
        }

        System.out.println(prioritySum);

        scanner.close();

    }
}
