package D02;

import utils.FileReader;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = FileReader.readTheFile("src/D02/puzzleInput");

        int gamePoints = 0;

        while (scanner.hasNextLine()) {

            String nextLine = scanner.nextLine();
            char[] chars = nextLine.toCharArray();

            RockPaperScissorGame game = new RockPaperScissorGame(chars[0], chars[2]);

            gamePoints += game.getPoints();

        }

        scanner.close();

        System.out.println(gamePoints);

        scanner = FileReader.readTheFile("src/D02/puzzleInput");

        int gamePointsOtherStrategy = 0;

        while (scanner.hasNextLine()) {

            String nextLine = scanner.nextLine();
            char[] chars = nextLine.toCharArray();

            RockPaperScissorGameWinDrawLose game = new RockPaperScissorGameWinDrawLose(chars[0], chars[2]);

            gamePointsOtherStrategy += game.getPoints();

        }

        System.out.println(gamePointsOtherStrategy);

    }
}
