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
        int frameScore;
        boolean spareBonus = false;
        int [][]frames = game.getFrames();

        for (int[] frame : frames) {
            frameScore = getFrameScore(frame);
            if (frameScore == 10) {
                spareBonus = true;
            }

            if (spareBonus) {
                totalScore += frame[0];
                spareBonus = false;
            }
            totalScore += frameScore;
        }
        return totalScore;
    }

    /**
     * Get Frame Score
     *
     * @param frame
     *
     * @return points for a frame
     */
    private int getFrameScore(int[] frame) {
        int frameScore;
        frameScore = frame[0] + frame[1];
        return frameScore;
    }
}
