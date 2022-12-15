package D05;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CrateStacks {

    protected ArrayList<ArrayList<Character>> crateStacks;

    /**
     * Constructor of {@link CrateStacks}.
     * Initialises {@link CrateStacks#crateStacks}.
     *
     * @throws FileNotFoundException if file doesn't exist or was not found
     */
    public CrateStacks () throws FileNotFoundException {
        this.crateStacks = createCrateStacks();
    }

    /**
     * Returns the attribute {@link CrateStacks#crateStacks}.
     *
     * @return the attribute {@link CrateStacks#crateStacks}
     */
    public ArrayList<ArrayList<Character>> getCrateStacks() {
        return crateStacks;
    }

    /**
     * Uses an {@link MoveCommand} to move crates from one stack to another.
     *
     * @param mc instance of {@link MoveCommand}
     */
    public void moveCrates(MoveCommand mc) {
        ArrayList<Character> fromStack = crateStacks.get(mc.getMoveFromIndex());
        ArrayList<Character> toStack = crateStacks.get(mc.getMoveToIndex());

        for (int i = 0; i < mc.getMoveAmount(); i++) {
            toStack.add(fromStack.get(fromStack.size() - 1));
            fromStack.remove(fromStack.size() - 1);
        }

        crateStacks.set(mc.getMoveFromIndex(), fromStack);
        crateStacks.set(mc.getMoveToIndex(), toStack);
    }

    /**
     * Returns all crates on top of all stacks from {@link CrateStacks#crateStacks}.
     *
     * @return crates on top of all stacks
     */
    public ArrayList<Character> getCratesOnTop() {

        ArrayList<Character> cratesOnTop = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            cratesOnTop.add(crateStacks.get(i).get(crateStacks.get(i).size() - 1));
        }

        return cratesOnTop;
    }

    private ArrayList<ArrayList<Character>> createCrateStacks() {

        ArrayList<String> crateStackStrings = new ArrayList<>();

        // I had a rough time figure out how to get the Input stacks to Java Arraylists.
        // So I did it the easy Way
        crateStackStrings.add("DLVTMHF");
        crateStackStrings.add("HQGJCTNP");
        crateStackStrings.add("RSDMPH");
        crateStackStrings.add("LBVF");
        crateStackStrings.add("NHGLQ");
        crateStackStrings.add("WBDGRMP");
        crateStackStrings.add("GMNRCHLQ");
        crateStackStrings.add("CLW");
        crateStackStrings.add("RDLQJZMT");


        ArrayList<ArrayList<Character>> crateStacks = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            ArrayList<Character> crateStacksTemp = new ArrayList<>();
            for (char crate : crateStackStrings.get(i).toCharArray()) {
                crateStacksTemp.add(crate);
            }
            crateStacks.add(crateStacksTemp);
        }

        return crateStacks;
    }



}
