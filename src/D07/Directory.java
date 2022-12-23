package D07;

import java.util.ArrayList;

/**
 * Class representing a directory in a computer system with subdirectories and files.
 *
 * @author Marlon Rosenberg
 */
public class Directory {

    private final String name;
    private final Directory parent;
    private final ArrayList<Directory> directories;
    private final ArrayList<File> files;
    private int size;
    private final int numberOfDirectoriesAbove;

    /**
     * Constructor for a directory.
     *
     * @param name name of the directory
     * @param parent parent directory
     * @param numberOfDirectoriesAbove number of directories above this directory
     */
    public Directory(String name, Directory parent, int numberOfDirectoriesAbove) {
        this.name = name;
        this.parent = parent;
        directories = new ArrayList<>();
        files = new ArrayList<>();
        size = 0;
        this.numberOfDirectoriesAbove = numberOfDirectoriesAbove;
    }

    /**
     * Updates the size of all subdirectory and this directory afterwards.
     */
    public void updateAllSize() {
        for (Directory directory : directories) {
            directory.updateAllSize();
        }
        updateSize();
    }

    /**
     * Updates the size of this directory.
     */
    private void updateSize() {
        size = 0;
        for (File file : files) {
            size += file.size();
        }
        for (Directory directory : directories) {
            size += directory.getSize();
        }

    }

    /**
     * Prints the directory and all subdirectories and files with right indentations.
     */
    public void print() {
        StringBuilder space = new StringBuilder();
        space.append(" ".repeat(numberOfDirectoriesAbove));
        System.out.println(space + "-" +  name + " (" + size + ")");
        for (Directory directory : directories) {
            directory.print();
        }
        for (File file : files) {
            file.print(String.valueOf(space.append(" ".repeat(2))));
        }
    }

    // addDirectory, addFile

    /**
     * Adds a directory to this directory.
     *
     * @param directory directory to add
     */
    public void addDirectory(Directory directory) {
        directories.add(directory);
        updateSize();
    }

    /**
     * Adds a file to this directory.
     *
     * @param file file to add
     */
    public void addFile(File file) {
        files.add(file);
        updateSize();
    }


    // getters

    /**
     * Returns the name of this directory.
     *
     * @return name of this directory
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the parent directory of this directory.
     *
     * @return parent directory of this directory
     */
    public Directory getParent() {
        return parent;
    }

    /**
     * Returns the size of this directory.
     *
     * @return size of this directory
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the number of directories above this directory.
     *
     * @return number of directories above this directory
     */
    public int getNumberOfDirectoriesAbove() {
        return numberOfDirectoriesAbove;
    }

    /**
     * Returns all subdirectories of this directory as ArrayList.
     *
     * @return all subdirectories of this directory as ArrayList
     */
    public ArrayList<Directory> getDirectories() {
        return directories;
    }


    /**
     * Returns the size of all subdirectories of this directory that are smaller than the given size.
     *
     * @param size size to compare with
     * @return size of all subdirectories of this directory that are smaller than the given size
     */
    public int getSizeOfDirectoriesUnderSize(int size) {

        int sizeCount = 0;

        if (this.size < size) {
            sizeCount += this.size;
        }
        for (Directory directory : directories) {
            sizeCount += directory.getSizeOfDirectoriesUnderSize(size);
        }
        return sizeCount;
    }

    /**
     * Returns the size of all subdirectories of this directory as ArrayList.
     *
     * @return size of all subdirectories of this directory as Arraylist
     */
    public ArrayList<Integer> getSizeOfDirectoriesAsList() {
        ArrayList<Integer> sizeList = new ArrayList<>();
        sizeList.add(this.size);

        for (Directory directory : directories) {
            sizeList.addAll(directory.getSizeOfDirectoriesAsList());
        }

        return sizeList;
    }
}
