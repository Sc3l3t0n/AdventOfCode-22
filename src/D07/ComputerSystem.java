package D07;

import java.util.ArrayList;

/**
 * A class that represents a computer system with a filesystem.
 *
 * @author Marlon Rosenberg
 */
public class ComputerSystem {

    private final Directory rootDirectory;
    private final int diskSize;

    /**
     * Creates a new computer system with a root directory and a disk size.
     *
     * @param diskSize the size of the disk in bytes
     */
    public ComputerSystem(int diskSize) {
        rootDirectory = new Directory("root", null, 0);
        this.diskSize = diskSize;
    }

    /**
     * Print out the whole system-directory.
     */
    public void printSystem() {
        rootDirectory.print();
    }

    /**
     * Updates the size of all directories in the system.
     */
    public void updateAllSize() {
        rootDirectory.updateAllSize();
    }

    // getters and setters

    /**
     * Returns the root directory of the computer system.
     *
     * @return the root directory
     */
    public Directory getRootDirectory() {
        return rootDirectory;
    }

    /**
     * Returns the used space in bytes.
     *
     * @return the used space in bytes
     */
    public int getUsedSpace() {
        return rootDirectory.getSize();
    }


    /**
     * Returns the size of all directories under a certain size.
     *
     * @param size the size in bytes
     * @return the size of all directories under a certain size
     */
    public int getSizeOfDirectoriesUnderSize(int size) {
        return rootDirectory.getSizeOfDirectoriesUnderSize(size);
    }

    /**
     * Returns the size of directories with a size under the given size as an ArrayList.
     *
     * @return the size of directories with a size under the given size as an ArrayList
     */
    public ArrayList<Integer> getSizeOfDirectoriesUnderSizeAsList() {
        return rootDirectory.getSizeOfDirectoriesAsList();
    }

    /**
     * Returns the size of the smallest directory to make up enough space to update.
     *
     * @param size the size to make up (update-size)
     * @return the size of the smallest directory to make up enough space to update
     */
    public int getSmallestDirectoryToMakeUpEnoughSpace(int size) {
        ArrayList<Integer> sizes = getSizeOfDirectoriesUnderSizeAsList();

        int smallest = Integer.MAX_VALUE;

        for (int sizeOfDirectory : sizes) {
            if (sizeOfDirectory >= size) {
                if (sizeOfDirectory < smallest) {
                    smallest = sizeOfDirectory;
                }
            }
        }
        return smallest;
    }

    /**
     * Returns the space needed to update.
     *
     * @param updateSize the size of the update
     * @return the space needed to update
     */
    public int getSpaceNeededToUpdate(int updateSize) {
        int usedSize = getUsedSpace();
        int freeSpace = diskSize - usedSize;
        if (freeSpace >= updateSize) {
            return 0;
        } else {
            return updateSize - freeSpace;
        }
    }


}
