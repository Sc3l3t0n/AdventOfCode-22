package D06;

import java.util.ArrayList;

/**
 * Class that locates the first message starter in a signal.
 */
public class MessageLocator extends IdentifierLocator {

    /**
     * Constructor of {@link MessageLocator}.
     * Calls the constructor of {@link IdentifierLocator}.
     *
     * @param signal the signal to be analyzed
     */
    public MessageLocator(String signal) {
        super(signal);
    }

    /**
     * Returns the first message starter as a {@link Character}.
     *
     * @return the first message starter as a {@link Character}
     */
    public Character getMessageStarter() {
        return getSignal().get(getMessageStarterIndex());
    }

    /**
     * Returns the index of the first message starter.
     *
     * @return the index of the first message starter
     */
    public int getMessageStarterIndex() {

        for (int i = 4; i < getSignal().size(); i++) {
            boolean skip = false;
            ArrayList<Character> fourteenChars = new ArrayList<>();

            for (int j = 1; j <= 14; j++) {
                if (fourteenChars.contains(getSignal().get(i - j))) {
                    skip = true;
                    break;
                }
                fourteenChars.add(getSignal().get(i - j));
            }

            if (skip) {
                continue;
            }

            return i;

        }
        throw new IllegalArgumentException("No identifier found");
    }

}

