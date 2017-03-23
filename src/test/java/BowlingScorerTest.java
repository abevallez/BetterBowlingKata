import static org.junit.Assert.*;

import org.junit.Test;

public class BowlingScorerTest {

    @Test
    public void gutterGameScore0() {
        BowlingScorer bowlingScorer = new BowlingScorer();
        int totalScore = bowlingScorer.calculateScore("00000000000000000000");
        assertEquals("a gutter game must score 0", 0, totalScore);
    }
}