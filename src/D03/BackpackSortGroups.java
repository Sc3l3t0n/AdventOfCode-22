package D03;

public class BackpackSortGroups extends BackpackSort{

    private final char[] backpackOne;
    private final char[] backpackTwo;
    private final char[] backpackThree;


    public BackpackSortGroups(String backpackOne, String backpackTwo, String backpackThree) {
        super(backpackOne);
        this.backpackOne = backpackOne.toCharArray();
        this.backpackTwo = backpackTwo.toCharArray();
        this.backpackThree = backpackThree.toCharArray();
    }

    @Override
    public int getPriorityValue() {
        if (getIdentifier() >= 'a' ) {
            return getIdentifier() - 96;
        } else {
            return getIdentifier() - 38;
        }
    }

    @Override
    public char getIdentifier() {
        char checkChar = 'A';
        while (checkChar <= 'z') {
            if (isInBackpackOne(checkChar) && isInBackpackTwo(checkChar) && isInBackpackThree(checkChar)) {
                return checkChar;
            }
            checkChar++;
        }
        return 'a';
    }

    private boolean isInBackpackOne(char identifier) {
        for (char c : backpackOne) {
            if (c == identifier) {
                return true;
            }
        }
        return false;
    }

    private boolean isInBackpackTwo(char identifier) {
        for (char c : backpackTwo) {
            if (c == identifier) {
                return true;
            }
        }
        return false;
    }

    private boolean isInBackpackThree(char identifier) {
        for (char c : backpackThree) {
            if (c == identifier) {
                return true;
            }
        }
        return false;
    }

}
