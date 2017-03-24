import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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
        List<Frame> frames = game.getFrames();

        for (Frame frame : frames) {
            if (spareBonus) {
                totalScore += frame.getFirstRoll();
                spareBonus = false;
            }

            frameScore = frame.getScore();
            if (frameScore == 10) {
                spareBonus = true;
            }
            totalScore += frameScore;
        }
        return totalScore;
    }
}
