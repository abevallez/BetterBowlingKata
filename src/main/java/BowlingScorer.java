/**
 * Bowling Scorer
 */
public class BowlingScorer {

    /**
     * Calculate the Score for a Bowling game from a string with the score roll by roll
     *
     * @param gameAnnotation string with the score, roll by roll
     *
     * @return points
     */
    public int calculateScore(String gameAnnotation) {
        Game game = new Game(gameAnnotation);
        return getTotalScore(game);
    }

    /**
     * Get Total Score from a Game
     * @param game
     *
     * @return total score
     */
    private int getTotalScore(Game game) {
        int totalScore = 0;
        int [][]frames = game.getFrames();
        for (int[] frame : frames) {
            totalScore += frame[0];
            totalScore += frame[1];
        }
        return totalScore;
    }
}
