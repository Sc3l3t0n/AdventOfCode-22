package D02;

public class RockPaperScissorGame {

    protected final RockPaperScissor opponent;
    protected RockPaperScissor suggestion;

    public RockPaperScissorGame(char opponent, char suggestion) {

        this.opponent = charToRockPaperScissor(opponent);
        this.suggestion = charToRockPaperScissor(suggestion);

    }

    public int getPoints() {
        return winningPoints() + suggestion.ordinal() + 1;
    }

    private int winningPoints() {
        if (opponent == suggestion) {
            return 3;
        } else if (opponent == RockPaperScissor.PAPER && suggestion == RockPaperScissor.SCISSOR) {
            return 6;
        } else if (opponent == RockPaperScissor.ROCK && suggestion == RockPaperScissor.PAPER) {
            return 6;
        } else if (opponent == RockPaperScissor.SCISSOR && suggestion == RockPaperScissor.ROCK) {
            return 6;
        } else {
            return 0;
        }
    }

    private RockPaperScissor charToRockPaperScissor(char input) {
        return input == 'A' || input == 'X' ? RockPaperScissor.ROCK : input == 'B' || input == 'Y' ? RockPaperScissor.PAPER : input == 'C' || input == 'Z' ? RockPaperScissor.SCISSOR : null;
    }

}
