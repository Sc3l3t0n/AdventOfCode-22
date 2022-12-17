package D06;

import java.util.ArrayList;

/**
 * Class that locates the first identifier in a signal.
 */
public class IdentifierLocator {

    private final ArrayList<Character> signal;

    /**
     * Constructor of {@link IdentifierLocator}.
     *
     * @param signal the signal to be analyzed
     */
    public IdentifierLocator(String signal) {
        this.signal = messageToArrayList(signal);
    }

    /**
     * Returns the message as an {@link ArrayList} of {@link Character}s.
     *
     * @param message the message to be converted
     * @return the message as an {@link ArrayList} of {@link Character}s
     */
    private ArrayList<Character> messageToArrayList(String message) {
        ArrayList<Character> messageArray = new ArrayList<>();
        for (int i = 0; i < message.length(); i++) {
            messageArray.add(message.charAt(i));
        }
        return messageArray;
    }

    /**
     * Returns the first Identifier of the signal as a {@link Character}.
     *
     * @return the first Identifier of the signal as a {@link Character}
     */
    public Character getIdentifier() {
        return signal.get(getIdentifierIndex());
    }

    /**
     * Returns the index of the first Identifier.
     *
     * @return the first index of the first Identifier
     */
    public int getIdentifierIndex() {

        for (int i = 4; i < signal.size(); i++) {
            boolean skip = false;
            ArrayList<Character> fourChars = new ArrayList<>();

            for (int j = 1; j <= 4; j++) {
                if (fourChars.contains(signal.get(i - j))) {
                    skip = true;
                    break;
                }
                fourChars.add(signal.get(i - j));
            }

            if (skip) {
                continue;
            }

            return i;

        }
        throw new IllegalArgumentException("No identifier found");
    }

    // getters and setters

    /**
     * Returns the message.
     *
     * @return the message
     */
    public ArrayList<Character> getSignal() {
        return signal;
    }
}
