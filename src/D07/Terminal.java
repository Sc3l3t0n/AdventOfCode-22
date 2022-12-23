package D07;

import java.util.Scanner;

/**
 * Class to run the input commands.
 *
 * @author Marlon Rosenberg
 */
public class Terminal {

    private final ComputerSystem computerSystem;
    private final Scanner scanner;
    private Directory currentDirectory;

    /**
     * Constructor for the Terminal class.
     *
     * @param computerSystem the computer system to run the commands on
     * @param scanner        the scanner to read the commands from
     */
    public Terminal(ComputerSystem computerSystem, Scanner scanner) {
        this.computerSystem = computerSystem;
        this.scanner = scanner;
        currentDirectory = computerSystem.getRootDirectory();
    }

    /**
     * Runs the commands.
     */
    public void run() {
        String line = scanner.nextLine();
        String[] parts = line.split(" ");
        while (scanner.hasNextLine()) {

            if (parts[0].equals("$")) {
                String command = parts[1];
                if (command.equals("cd")) {
                    cd(parts[2]);
                } else if (command.equals("ls")) {
                    line = ls();
                    parts = line.split(" ");
                    continue;
                }
            }
            if (scanner.hasNextLine()) {
                line = scanner.nextLine();
                parts = line.split(" ");
            } else {
                break;
            }
        }
    }

    /**
     * Changes the current directory.
     *
     * @param directoryName the name of the directory to change to
     */
    public void cd (String directoryName) {
        if (directoryName.equals("..")) {
            currentDirectory = currentDirectory.getParent();
        } else if (directoryName.equals("/")) {
            currentDirectory = computerSystem.getRootDirectory();
        } else {
            for (Directory directory : currentDirectory.getDirectories()) {
                if (directory.getName().equals(directoryName)) {
                    currentDirectory = directory;
                }
            }
        }
    }

    /**
     * Creates the files and directories in the current directory.
     * Returns the next line to read with a command.
     *
     * @return the next line to be read with a command
     */
    public String ls() {
        String line = scanner.nextLine();
        String[] parts = line.split(" ");
        while (!lineIsCommand(parts)){
            if(isDirectory(parts)){
                currentDirectory.addDirectory(new Directory(parts[1], currentDirectory, currentDirectory.getNumberOfDirectoriesAbove() + 1));
            } else {
                currentDirectory.addFile(new File(parts[1], Integer.parseInt(parts[0]), currentDirectory));
            }
            if (scanner.hasNextLine()) {
                line = scanner.nextLine();
                parts = line.split(" ");
            } else {
                break;
            }
        }
        return line;
    }

    /**
     * Checks if the line is a command.
     *
     * @param nextLine the parts of the line
     * @return true if the line is a command, false otherwise
     */
    public boolean lineIsCommand(String[] nextLine) {
        return nextLine[0].equals("$");
    }

    /**
     * Checks if the line is a directory.
     *
     * @param nextLine the parts of the line
     * @return true if the line is a directory, false otherwise
     */
    public boolean isDirectory(String[] nextLine) {
        return nextLine[0].equals("dir");
    }
}
