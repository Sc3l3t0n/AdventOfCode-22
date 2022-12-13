package D02;

public class RockPaperScissorGameWinDrawLose extends RockPaperScissorGame{

    private final char gameEnd;

    public RockPaperScissorGameWinDrawLose(char opponent, char suggestion) {
        super(opponent, suggestion);
        this.gameEnd = suggestion;
        super.suggestion = suggestionToGameEnd();
    }

    private RockPaperScissor suggestionToGameEnd(){
        return switch (gameEnd) {
            case 'X' -> moveToLose();
            case 'Y' -> moveToDraw();
            case 'Z' -> moveToWin();
            default -> throw new IllegalStateException("Unexpected value: " + gameEnd);
        };
    }

    private RockPaperScissor moveToWin() {
        return switch (opponent) {
            case ROCK -> RockPaperScissor.PAPER;
            case PAPER -> RockPaperScissor.SCISSOR;
            case SCISSOR -> RockPaperScissor.ROCK;
        };
    }

    private RockPaperScissor moveToDraw() {
        return switch (opponent) {
            case ROCK -> RockPaperScissor.ROCK;
            case PAPER -> RockPaperScissor.PAPER;
            case SCISSOR -> RockPaperScissor.SCISSOR;
        };
    }

    private RockPaperScissor moveToLose() {
        return switch (opponent) {
            case ROCK -> RockPaperScissor.SCISSOR;
            case PAPER -> RockPaperScissor.ROCK;
            case SCISSOR -> RockPaperScissor.PAPER;
        };
    }

}
