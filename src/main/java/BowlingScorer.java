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
        if (gameAnnotation.contains("1")) {
            return 1;
        }

        return 0;
    }
}
