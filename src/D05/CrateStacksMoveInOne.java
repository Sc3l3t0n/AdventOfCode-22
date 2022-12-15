package D05;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class CrateStacksMoveInOne extends CrateStacks{

    /**
     * Constructor of {@link CrateStacksMoveInOne}.
     * Calls the constructor of {@link CrateStacks}.
     *
     * @throws FileNotFoundException if file doesn't exist or was not found
     */
    public CrateStacksMoveInOne() throws FileNotFoundException {
        super();
    }

    /**
     * Uses an {@link MoveCommand} to move crates from one stack to another.
     * Moves the crates at once.
     *
     * @param mc instance of {@link MoveCommand}
     */
    @Override
    public void moveCrates(MoveCommand mc) {
        ArrayList<Character> fromStack = crateStacks.get(mc.getMoveFromIndex());
        ArrayList<Character> toStack = crateStacks.get(mc.getMoveToIndex());
        ArrayList<Character> moveStack = new ArrayList<>();

        for (int i = 0; i < mc.getMoveAmount(); i++) {
            moveStack.add(fromStack.get(fromStack.size() - 1));
            fromStack.remove(fromStack.size() - 1);
        }
        Collections.reverse(moveStack);

        toStack.addAll(moveStack);

        crateStacks.set(mc.getMoveFromIndex(), fromStack);
        crateStacks.set(mc.getMoveToIndex(), toStack);
    }
}
