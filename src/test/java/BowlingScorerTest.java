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
                {"12345678912345678912", 93},
                {"10101010101010101010", 10}
        };
    }

    @Test
    @UseDataProvider("noSparesNoStrikesGamesCases")
    public void NoSparesNoStrikesGameReturnSumOfPinDowns(String stringGame, int expectedScore) {
        BowlingScorer bowlingScorer = new BowlingScorer();
        int totalScore = bowlingScorer.calculateScore(stringGame);
        assertEquals("Not spare, not strike game return sum of pin downs", expectedScore, totalScore);
    }
}