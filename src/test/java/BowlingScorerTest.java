import static org.junit.Assert.*;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Bowling Scorer Test
 */
@RunWith(DataProviderRunner.class)
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

    @DataProvider
    public static Object[][] noSparesNoStrikesGamesCases() {
        return new Object[][] {
                {"11111111111111111111", 20},
                {"12121212121212121212", 30},
                {"10101010101010101010", 10}
        };
    }

    @Test
    @UseDataProvider("noSparesNoStrikesGamesCases")
    public void noSparesNoStrikesGameReturnSumOfPinDowns(String stringGame, int expectedScore) {
        BowlingScorer bowlingScorer = new BowlingScorer();
        int totalScore = bowlingScorer.calculateScore(stringGame);
        assertEquals("Not spare, not strike game return sum of pin downs", expectedScore, totalScore);
    }

    @Test
    public void oneSpareNotLastOneAddTheNextRollPoints() {
        BowlingScorer bowlingScorer = new BowlingScorer();
        int totalScore = bowlingScorer.calculateScore("19100000000000000000");
        assertEquals("one spare, not last one, add the next roll points", 12, totalScore);
    }

    @Test
    public void twoSpareInARowAddTheNextRollPoints() {
        BowlingScorer bowlingScorer = new BowlingScorer();
        int totalScore = bowlingScorer.calculateScore("19191000000000000000");
        assertEquals("one spare, not last one, add the next roll points", 23, totalScore);
    }

    @Test
    public void oneSpareInLastRowAddOneExtraRoll() {
        BowlingScorer bowlingScorer = new BowlingScorer();
        int totalScore = bowlingScorer.calculateScore("101000000000000000192");
        assertEquals("one spare, not last one, add the next roll points", 14, totalScore);
    }
}