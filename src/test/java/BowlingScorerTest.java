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
    public void only1PinDownScore1Return1Point()
    {
        BowlingScorer bowlingScorer = new BowlingScorer();
        int totalScore = bowlingScorer.calculateScore("10000000000000000000");
        assertEquals("only 1 pin down must return 1 point", 1, totalScore);
    }

    @Test
    public void OnePinEachFrameReturn10Points() {
        BowlingScorer bowlingScorer = new BowlingScorer();
        int totalScore = bowlingScorer.calculateScore("10101010101010101010");
        assertEquals("1 pin down each frame must return 10 point", 10, totalScore);
    }

    @Test
    public void OnePinDownEachRollReturn20Points() {
        BowlingScorer bowlingScorer = new BowlingScorer();
        int totalScore = bowlingScorer.calculateScore("11111111111111111111");
        assertEquals("1 pin down each roll must return 20 point", 20, totalScore);
    }

    @Test
    public void NoSparesNoStrikesGameReturnSumOfPinDowns() {
        BowlingScorer bowlingScorer = new BowlingScorer();
        int totalScore = bowlingScorer.calculateScore("12345678912345678912");
        assertEquals("Not spare, not strike game return sum of pin downs", 93, totalScore);
    }
}