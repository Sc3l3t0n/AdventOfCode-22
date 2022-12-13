package D01;

import utils.FileReader;

import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello world!");

        Scanner scanner = FileReader.readTheFile("C:\\Users\\marlo\\Documents\\Programmieren\\AdventOfCode\\src\\D01\\puzzleInput");

        int i = 0;

        ArrayList<Integer> calories = new ArrayList<>();

        while (scanner.hasNextLine()) {

            String nextLine = scanner.nextLine();

            if (nextLine.isEmpty()){
                i++;
            } else {
                try {
                    calories.set(i, calories.get(i) + Integer.parseInt(nextLine));
                } catch (Exception e) {
                    calories.add(Integer.parseInt(nextLine));
                }
            }
        }

        System.out.println(Collections.max(calories) + " at Index " + calories.indexOf(Collections.max(calories)));

        int calories3Max = Collections.max(calories);

        for (int j = 0; j < 2; j++) {
            calories.remove(Collections.max(calories));
            calories3Max += Collections.max(calories);
        }

        System.out.println("Max calories of three Elves " + calories3Max);






    }
}