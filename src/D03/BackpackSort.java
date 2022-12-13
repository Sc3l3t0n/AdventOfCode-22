package D03;

public class BackpackSort {

    private final char[] backpack;

    private final char[] compartmentOne;

    private final char[] compartmentTwo;

    private final int sizeOfBackpack;

    public BackpackSort (String backpack) {
        this.backpack = backpack.toCharArray();
        this.sizeOfBackpack = backpack.length();

        this.compartmentOne = splitBackpack(1);
        this.compartmentTwo = splitBackpack(2);
    }

    public int getPriorityValue() {
        if (getIdentifier() >= 'a' ) {
            return getIdentifier() - 96;
        } else {
            return getIdentifier() - 38;
        }
    }

    public char getIdentifier() {
        char checkChar = 'A';
        while (checkChar <= 'z') {
            if (isInCompartmentOne(checkChar) && isInCompartmentTwo(checkChar)) {
                return checkChar;
            }
            checkChar++;
        }
        return 'a';
    }

    private boolean isInCompartmentOne(char identifier) {
        for (char c : compartmentOne) {
            if (c == identifier) {
                return true;
            }
        }
        return false;
    }

    private boolean isInCompartmentTwo(char identifier) {
        for (char c : compartmentTwo) {
            if (c == identifier) {
                return true;
            }
        }
        return false;
    }

    private char[] splitBackpack(int index) {
        if (index == 1) {
            char[] compartmentOne = new char[sizeOfBackpack / 2];

            if (sizeOfBackpack / 2 >= 0) System.arraycopy(backpack, 0, compartmentOne, 0, sizeOfBackpack / 2);
            return compartmentOne;
        } else if (index == 2) {
            char[] compartmentTwo = new char[sizeOfBackpack / 2];

            if (sizeOfBackpack / 2 >= 0) System.arraycopy(backpack, sizeOfBackpack / 2, compartmentTwo, 0, sizeOfBackpack / 2);
            return compartmentTwo;
        }
        else return null;
    }



    // Getter

    public char[] getCompartmentOne() {
        return compartmentOne;
    }

    public char[] getCompartmentTwo() {
        return compartmentTwo;
    }
}
