package D07;

/**
 * Record of a file in a directory.
 *
 * @author Marlon Rosenberg
 *
 * @param name name of the file
 * @param size size of the file
 * @param parent parent directory
 */
public record File(String name, int size, Directory parent) {
    /**
     * Print the filename and size to the commandline.
     *
     * @param space string of spaces to indent the file
     */
    public void print(String space) {
        System.out.println(space + name + " (" + size + ")");
    }
}
