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

        int totalScore = 0;
        int [][]frames = game.getFrames();
        for (int[] frame : frames) {
            totalScore += frame[0];
            totalScore += frame[1];
        }
        return totalScore;
    }
}
