package D04;

import utils.FileReader;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = FileReader.readTheFile("src/D04/puzzleInput");

        int counter = 0;

        while (scanner.hasNextLine()) {

            String[] nextLine = scanner.nextLine().split(",");

            WorkplaceAssignmentContain wa = new WorkplaceAssignmentContain(nextLine[0], nextLine[1]);

            System.out.println(" " + nextLine[0] + " " + wa.getStartOfWorker(1) + " " + wa.getEndOfWorker(1));
            System.out.println(" " +nextLine[1] + " " + wa.getStartOfWorker(2) + " " + wa.getEndOfWorker(2));
            System.out.println(" ");

            counter += wa.containsWholeWorkplace() ? 1: 0;

        }

        scanner.close();

        System.out.println("Number of workplaces completely in the other one : " + counter);

        // Puzzle 2

        scanner = FileReader.readTheFile("src/D04/puzzleInput");
        counter = 0;

        while (scanner.hasNextLine()) {

            String[] nextLine = scanner.nextLine().split(",");

            WorkplaceAssignmentOverlapped wa = new WorkplaceAssignmentOverlapped(nextLine[0], nextLine[1]);

            if (!(wa.areWorkspacesOverlapping() || wa.containsWholeWorkplace())) {
                System.out.println(" " + nextLine[0] + " " + wa.getStartOfWorker(1) + " " + wa.getEndOfWorker(1));
                System.out.println(" " +nextLine[1] + " " + wa.getStartOfWorker(2) + " " + wa.getEndOfWorker(2));
                System.out.println((wa.areWorkspacesOverlapping()|| wa.containsWholeWorkplace()));
                System.out.println(" ");
            }

            counter += wa.areWorkspacesOverlapping() || wa.containsWholeWorkplace() ? 1 : 0;

        }

        System.out.println("Number of workplaces overlapping : " + counter);

    }

}
