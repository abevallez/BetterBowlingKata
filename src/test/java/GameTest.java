import static org.junit.Assert.*;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Game Test
 */
@RunWith(DataProviderRunner.class)
public class GameTest {

    @DataProvider
    public static Object[][] onlyOneRollWithPinsDownInTheWholeGameDataProvider() {
        int[][] gutterGame = {{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};
        int[][] onePinDown = {{0,1},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};
        int[][] twoFirstFrames = {{0,1},{0,2},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};
        int[][] oneRollEachFrame = {{0,1},{0,1},{0,1},{0,1},{0,1},{0,1},{0,1},{0,1},{0,1},{0,1}};

        return new Object[][] {
                {"00000000000000000000", gutterGame},
                {"01000000000000000000", onePinDown},
                {"01020000000000000000", twoFirstFrames},
                {"01010101010101010101", oneRollEachFrame}
        };
    }

    @Test
    @UseDataProvider("onlyOneRollWithPinsDownInTheWholeGameDataProvider")
    public void createGameFromStringGetFramesWithPinByRollDefined(String annotation, int[][]expectedFrames){
        Game game = new Game(annotation);
        assertArrayEquals("game must have frames with rolls defined", expectedFrames, game.getFrames());
    }
}