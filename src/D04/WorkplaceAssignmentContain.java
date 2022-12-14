package D04;

public class WorkplaceAssignmentContain {

    private final String[] workerOne;
    private final String[] workerTwo;

    /**
     * Constructor of {@link WorkplaceAssignmentContain}.
     * Assigns the attributes {@link WorkplaceAssignmentContain#workerOne} and
     * {@link WorkplaceAssignmentContain#workerTwo} with given parameters.
     * Splits given strings by an "-" to get the workplaces as a String Array.
     *
     * @param workerOne workplaces of worker one
     * @param workerTwo workplaces of worker two
     */
    public WorkplaceAssignmentContain(String workerOne, String workerTwo) {
        this.workerOne = workerOne.split("-");
        this.workerTwo = workerTwo.split("-");
    }

    /**
     * Takes the index of a Worker as input and returns
     * the start workplace of a Worker.
     *
     * @param index of the worker
     * @return start of the given worker
     */

    public int getStartOfWorker(int index) {
        return switch (index) {
            case 1 -> Integer.parseInt(workerOne[0]);
            case 2 -> Integer.parseInt(workerTwo[0]);
            default -> throw new IllegalStateException("Unexpected value: " + index);
        };
    }

    /**
     * Takes the index of a Worker as input and returns
     * the end workplace of a Worker.
     *
     * @param index of the worker
     * @return end of the given worker
     */

    public int getEndOfWorker(int index) {
        return switch (index) {
            case 1 -> Integer.parseInt(workerOne[1]);
            case 2 -> Integer.parseInt(workerTwo[1]);
            default -> throw new IllegalStateException("Unexpected value: " + index);
        };
    }

    /**
     * Returns {@code true} if one workplace completely contains the other
     * workplace and {@code false} if not.
     *
     * @return if one workplace completely contains the other workplace
     */
    public boolean containsWholeWorkplace() {
        return (getEndOfWorker(1) <= getEndOfWorker(2) && getStartOfWorker(1) >= getStartOfWorker(2)) || (getEndOfWorker(2) <= getEndOfWorker(1) && getStartOfWorker(2) >= getStartOfWorker(1));
    }

}
