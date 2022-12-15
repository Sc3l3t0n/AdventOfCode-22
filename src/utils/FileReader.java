package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    public static Scanner readTheFile(String filename) throws FileNotFoundException {

        File file = new File(filename);

        Scanner scanner = new Scanner(file);

        System.out.println("Scanner has been created.");

        return scanner;

    }

    public static void toNextBlankLine(Scanner scanner){
        while (!scanner.nextLine().isEmpty());
    }

}
