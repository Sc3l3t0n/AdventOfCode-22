package D05;

public class MoveCommand {

    private final int moveAmount;
    private final int moveFrom;
    private final int moveTo;

    /**
     * Constructor of {@link MoveCommand}.
     * Initialises {@link MoveCommand#moveAmount}, {@link MoveCommand#moveFrom}
     * and {@link MoveCommand#moveTo} with the given string.
     * Syntax for the command:
     * {@code move (moveAmount) from (moveFrom) to
     * (moveTo)}.
     *
     * @param command string of a command in specific syntax
     */
    public MoveCommand(String command){
        this.moveAmount = Integer.parseInt(command.split(" ")[1]);
        this.moveFrom = Integer.parseInt(command.split(" ")[3]);
        this.moveTo = Integer.parseInt(command.split(" ")[5]);
    }

    /**
     * Returns the amount of crates to move.
     *
     * @return the amount of crates to move
     */
    public int getMoveAmount() {
        return moveAmount;
    }

    /**
     * Returns the stack to move from.
     *
     * @return the stack to move from
     */
    public int getMoveFrom() {
        return moveFrom;
    }

    /**
     * Returns the stack to move to.
     *
     * @return the stack to move to
     */
    public int getMoveTo() {
        return moveTo;
    }

    /**
     * Returns the index of the stack to move from.
     *
     * @return the index of the stack to move from
     */
    public int getMoveFromIndex() {
        return getMoveFrom() - 1;
    }

    /**
     * Returns the index of the stack to move to.
     *
     * @return the index of the stack to move to
     */
    public int getMoveToIndex() {
        return getMoveTo() - 1;
    }
}
