package D05;

import utils.FileReader;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        CrateStacks crateStacks = new CrateStacks();
        CrateStacksMoveInOne crateStacksMoveInOne = new CrateStacksMoveInOne();

        crateStacks.getCrateStacks().forEach(System.out::println);

        // Puzzle 1
        Scanner scanner = FileReader.readTheFile("src/D05/puzzleInput");

        FileReader.toNextBlankLine(scanner);

        while (scanner.hasNextLine()) {
            MoveCommand mc = new MoveCommand(scanner.nextLine());
            crateStacks.moveCrates(mc);
            crateStacks.getCrateStacks().forEach(System.out::println);
            System.out.println("-------------------------------------");
        }

        scanner.close();

        crateStacks.getCratesOnTop().forEach(System.out::print);

        // Puzzle 2
        scanner = FileReader.readTheFile("src/D05/puzzleInput");

        FileReader.toNextBlankLine(scanner);

        while (scanner.hasNextLine()) {
            MoveCommand mc = new MoveCommand(scanner.nextLine());
            crateStacksMoveInOne.moveCrates(mc);
            crateStacksMoveInOne.getCrateStacks().forEach(System.out::println);
            System.out.println("-------------------------------------");
        }

        System.out.print("Puzzle One: ");
        crateStacks.getCratesOnTop().forEach(System.out::print);
        System.out.print("\n" + "Puzzle Two: ");
        crateStacksMoveInOne.getCratesOnTop().forEach(System.out::print);
    }

}
