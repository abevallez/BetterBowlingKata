import static org.junit.Assert.*;

import org.junit.Test;

public class BowlingScorerTest {

    @Test
    public void gutterGameScore0() {
        BowlingScorer bowlingScorer = new BowlingScorer();
        int totalScore = bowlingScorer.calculateScore("00000000000000000000");
        assertEquals("a gutter game must score 0 points", 0, totalScore);
    }

    @Test
    public void only1PinDownScore1()
    {
        BowlingScorer bowlingScorer = new BowlingScorer();
        int totalScore = bowlingScorer.calculateScore("10000000000000000000");
        assertEquals("only 1 pin down must return 1 point", 1, totalScore);
    }
}