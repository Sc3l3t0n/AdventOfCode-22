package D06;

import utils.FileReader;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = FileReader.readTheFile("src/D06/puzzleInput");

        String signal = scanner.nextLine();

        // Puzzle 1
        IdentifierLocator identifierLocator = new IdentifierLocator(signal);

        System.out.println("The identifier is: " + identifierLocator.getIdentifier());
        System.out.println("The number of characters past the identifier is: " + identifierLocator.getIdentifierIndex());

        //Puzzle 2
        MessageLocator messageLocator = new MessageLocator(signal);

        System.out.println("The signal starter is: " + messageLocator.getMessageStarter());
        System.out.println("The number of characters past the signal starter is: " + messageLocator.getMessageStarterIndex());

    }
}
