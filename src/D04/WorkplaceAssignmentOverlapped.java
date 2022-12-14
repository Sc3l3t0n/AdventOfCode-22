package D04;

public class WorkplaceAssignmentOverlapped extends WorkplaceAssignmentContain {
    /**
     * Constructor of {@link WorkplaceAssignmentOverlapped}.
     * Calls the constructor of {@link WorkplaceAssignmentContain}.
     *
     * @param workerOne workplaces of worker one
     * @param workerTwo workplaces of worker two
     */
    public WorkplaceAssignmentOverlapped(String workerOne, String workerTwo) {
        super(workerOne, workerTwo);
    }

    /**
     * Returns {@code true} if the workplaces are overlapping
     * and {@code false} if not.
     *
     * @return if the workplaces are overlapping
     */
    public boolean areWorkspacesOverlapping() {
        return (getStartOfWorker(1) <= getEndOfWorker(2) && getStartOfWorker(2) <= getStartOfWorker(1)) || (getStartOfWorker(2) <= getEndOfWorker(1) && getStartOfWorker(1) <= getStartOfWorker(2));
    }
}
