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
        int totalScore = 0;
        for (int i=0; i<gameAnnotation.length();i++) {
            totalScore += Character.getNumericValue(gameAnnotation.charAt(i));
        }
        return totalScore;
    }
}
