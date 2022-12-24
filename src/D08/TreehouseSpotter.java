package D08;

import java.util.ArrayList;

/**
 * Class to find the highest scenic score and amount of visible trees.
 *
 * @author Marlon Rosenberg
 */
public class TreehouseSpotter {

    private final ArrayList<ArrayList<Integer>> treeMap;
    private int numberOfVisibleTrees;
    private int highestScenicScore;

    /**
     * Constructor for the TreehouseSpotter class.
     *
     * @param droneFootage the drone footage.
     */
    public TreehouseSpotter(DroneFootage droneFootage) {
        this.treeMap = droneFootage.getTreeMap();
        this.numberOfVisibleTrees = treeMap.size() * 2 + treeMap.get(0).size() * 2 - 4;
        this.highestScenicScore = 0;
        calculateNumberOfVisibleTrees();
        calculateHighestScenicScore();
    }

    /**
     * Calculates the number of visible trees.
     */
    private void calculateNumberOfVisibleTrees() {
        for (int i = 1; i < treeMap.size() - 1; i++) {
            for (int j = 1; j < treeMap.get(i).size() - 1; j++) {
                int treeSize = treeMap.get(i).get(j);
                ArrayList<Integer> left = getAllTreesLeft(i, j);
                ArrayList<Integer> right = getAllTreesRight(i, j);
                ArrayList<Integer> up = getAllTreesAbove(i, j);
                ArrayList<Integer> down = getAllTreesBelow(i, j);

                if (!(isThereATallerOrEvenTree(left, treeSize) && isThereATallerOrEvenTree(right, treeSize) &&
                        isThereATallerOrEvenTree(up, treeSize) && isThereATallerOrEvenTree(down, treeSize))) {
                    this.numberOfVisibleTrees++;
                }
            }
        }
    }

    /**
     * Returns {@code true} if there is a taller or even tree in the given direction and {@code false} if not.
     *
     * @param direction the direction to check as ArrayList with tree sizes.
     * @param treeSize the size of the tree to check.
     * @return if there is a taller or even tree in the given direction.
     */
    private boolean isThereATallerOrEvenTree(ArrayList<Integer> direction, int treeSize) {
        for (int tree : direction) {
            if (tree >= treeSize) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns all trees to the left of the given position as an ArrayList.
     *
     * @param i the row of the position
     * @param j the column of the position
     * @return all trees to the left of the given position as an ArrayList
     */
    private ArrayList<Integer> getAllTreesLeft(int i, int j) {
        ArrayList<Integer> trees = new ArrayList<>();

        for (int k = j - 1; k >= 0; k--) {
            trees.add(treeMap.get(i).get(k));
        }

        return trees;
    }

    /**
     * Returns all trees to the right of the given position as an ArrayList.
     *
     * @param i the row of the position
     * @param j the column of the position
     * @return all trees to the right of the given position as an ArrayList
     */
    private ArrayList<Integer> getAllTreesRight(int i, int j) {
        ArrayList<Integer> trees = new ArrayList<>();

        for (int k = j + 1; k < treeMap.get(i).size(); k++) {
            trees.add(treeMap.get(i).get(k));
        }

        return trees;
    }

    /**
     * Returns all trees above the given position as an ArrayList.
     *
     * @param i the row of the position
     * @param j the column of the position
     * @return all trees above the given position as an ArrayList
     */
    private ArrayList<Integer> getAllTreesAbove(int i, int j) {
        ArrayList<Integer> trees = new ArrayList<>();

        for (int k = i - 1; k >= 0; k--) {
            trees.add(treeMap.get(k).get(j));
        }

        return trees;
    }

    /**
     * Returns all trees below the given position as an ArrayList.
     *
     * @param i the row of the position
     * @param j the column of the position
     * @return all trees below the given position as an ArrayList
     */
    private ArrayList<Integer> getAllTreesBelow(int i, int j) {
        ArrayList<Integer> trees = new ArrayList<>();

        for (int k = i + 1; k < treeMap.size(); k++) {
            trees.add(treeMap.get(k).get(j));
        }

        return trees;
    }


    /**
     * Calculates the highest scenic score.
     */
    private void calculateHighestScenicScore() {
        for (int i = 1; i < treeMap.size() - 1; i++) {
            for (int j = 1; j < treeMap.get(i).size() - 1; j++) {
                int treeSize = treeMap.get(i).get(j);
                ArrayList<Integer> left = getAllTreesLeft(i, j);
                ArrayList<Integer> right = getAllTreesRight(i, j);
                ArrayList<Integer> up = getAllTreesAbove(i, j);
                ArrayList<Integer> down = getAllTreesBelow(i, j);

                ArrayList<ArrayList<Integer>> directions = new ArrayList<>();
                directions.add(left);
                directions.add(right);
                directions.add(up);
                directions.add(down);

                int scenicScore = calculateScenicScoreOfTree(directions, treeSize);
                if (scenicScore > this.highestScenicScore) {
                    this.highestScenicScore = scenicScore;
                }
            }
        }
    }

    /**
     * Calculates the scenic score of the given tree.
     *
     * @param directions the directions to check as ArrayList with tree sizes
     * @param treeSize the size of the tree to check
     * @return the scenic score of the given tree
     */
    private int calculateScenicScoreOfTree(ArrayList<ArrayList<Integer>> directions, int treeSize) {
        int scenicScore = 1;
        for (ArrayList<Integer> direction : directions) {
            scenicScore *= getSeenTreesInDirection(direction, treeSize);
        }
        return scenicScore;
    }

    /**
     * Returns the number of trees that can be seen in the given direction.
     *
     * @param direction the direction to check as ArrayList with tree sizes
     * @param treeSize the size of the tree to check
     * @return the number of trees that can be seen in the given direction
     */
    private int getSeenTreesInDirection(ArrayList<Integer> direction, int treeSize) {
        int seenTrees = 0;
            for (int tree : direction) {
                seenTrees++;
                if (tree >= treeSize) {
                    break;
                }
            }
        return seenTrees;
    }

    /**
     * Returns the number of visible trees.
     *
     * @return the number of visible trees
     */
    public int getNumberOfVisibleTrees(){
        return this.numberOfVisibleTrees;
    }

    /**
     * Returns the highest scenic score.
     *
     * @return the highest scenic score
     */
    public int getHighestScenicScore() {
        return this.highestScenicScore;
    }
}
