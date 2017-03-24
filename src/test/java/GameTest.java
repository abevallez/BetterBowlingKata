import static org.junit.Assert.*;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

/**
 * Game Test
 */
@RunWith(DataProviderRunner.class)
public class GameTest {

    @Test
    public void createGutterGameFromAnnotationMustBeSameGutterGame() {
        Game game = new Game("00000000000000000000");
        Game gutterGame = new GutterGame();
        List<Frame> expectedFrames= gutterGame.getFrames();
        List<Frame> gameFrames = game.getFrames();
        assertTrue(expectedFrames.get(0).equals(gameFrames.get(0)));
        assertTrue(expectedFrames.get(1).equals(gameFrames.get(1)));
        assertTrue(expectedFrames.get(2).equals(gameFrames.get(2)));
        assertTrue(expectedFrames.get(3).equals(gameFrames.get(3)));
        assertTrue(expectedFrames.get(4).equals(gameFrames.get(4)));
        assertTrue(expectedFrames.get(5).equals(gameFrames.get(5)));
        assertTrue(expectedFrames.get(6).equals(gameFrames.get(6)));
        assertTrue(expectedFrames.get(7).equals(gameFrames.get(7)));
        assertTrue(expectedFrames.get(8).equals(gameFrames.get(8)));
        assertTrue(expectedFrames.get(9).equals(gameFrames.get(9)));
    }

    @DataProvider
    public static Object[][] onlyOneRollWithPinsDownInTheWholeGameDataProvider() {

        List<Frame> onePinDown = getOnePinDownFramesGame();
        List<Frame> twoFirstFrames = getTwoFirstFramesGame();
        List<Frame> oneRollEachFrame = getOneRollEachFrameGame();

        return new Object[][] {
                {"01000000000000000000", onePinDown},
                {"01020000000000000000", twoFirstFrames},
                {"01010101010101010101", oneRollEachFrame}
        };
    }

    @Test
    @UseDataProvider("onlyOneRollWithPinsDownInTheWholeGameDataProvider")
    public void createGameFromStringGetFramesWithPinByRollDefined(String annotation, List<Frame> expectedFrames){
        Game game = new Game(annotation);
        List<Frame> gameFrames = game.getFrames();
        assertTrue(expectedFrames.get(0).equals(gameFrames.get(0)));
        assertTrue(expectedFrames.get(1).equals(gameFrames.get(1)));
        assertTrue(expectedFrames.get(2).equals(gameFrames.get(2)));
        assertTrue(expectedFrames.get(3).equals(gameFrames.get(3)));
        assertTrue(expectedFrames.get(4).equals(gameFrames.get(4)));
        assertTrue(expectedFrames.get(5).equals(gameFrames.get(5)));
        assertTrue(expectedFrames.get(6).equals(gameFrames.get(6)));
        assertTrue(expectedFrames.get(7).equals(gameFrames.get(7)));
        assertTrue(expectedFrames.get(8).equals(gameFrames.get(8)));
        assertTrue(expectedFrames.get(9).equals(gameFrames.get(9)));
    }

    /**
     * One pin down each frame game.
     *
     * @return
     */
    private static List<Frame> getOneRollEachFrameGame() {
        List<Frame> oneRollEachFrame = new ArrayList<Frame>();
        oneRollEachFrame.add(0, new Frame(0,1));
        oneRollEachFrame.add(1, new Frame(0,1));
        oneRollEachFrame.add(2, new Frame(0,1));
        oneRollEachFrame.add(3, new Frame(0,1));
        oneRollEachFrame.add(4, new Frame(0,1));
        oneRollEachFrame.add(5, new Frame(0,1));
        oneRollEachFrame.add(6, new Frame(0,1));
        oneRollEachFrame.add(7, new Frame(0,1));
        oneRollEachFrame.add(8, new Frame(0,1));
        oneRollEachFrame.add(9, new Frame(0,1));
        return oneRollEachFrame;
    }

    /**
     * Two first frames with pin downs game
     * @return
     */
    private static List<Frame> getTwoFirstFramesGame() {
        List<Frame> twoFirstFrames = new ArrayList<Frame>();
        twoFirstFrames.add(0, new Frame(0,1));
        twoFirstFrames.add(1, new Frame(0,2));
        twoFirstFrames.add(2, new Frame(0,0));
        twoFirstFrames.add(3, new Frame(0,0));
        twoFirstFrames.add(4, new Frame(0,0));
        twoFirstFrames.add(5, new Frame(0,0));
        twoFirstFrames.add(6, new Frame(0,0));
        twoFirstFrames.add(7, new Frame(0,0));
        twoFirstFrames.add(8, new Frame(0,0));
        twoFirstFrames.add(9, new Frame(0,0));
        return twoFirstFrames;
    }

    /**
     * One pin down in first frame game
     *
     * @return
     */
    private static List<Frame> getOnePinDownFramesGame() {
        List<Frame> onePinDown = new ArrayList<Frame>();
        onePinDown.add(0, new Frame(0,1));
        onePinDown.add(1, new Frame(0,0));
        onePinDown.add(2, new Frame(0,0));
        onePinDown.add(3, new Frame(0,0));
        onePinDown.add(4, new Frame(0,0));
        onePinDown.add(5, new Frame(0,0));
        onePinDown.add(6, new Frame(0,0));
        onePinDown.add(7, new Frame(0,0));
        onePinDown.add(8, new Frame(0,0));
        onePinDown.add(9, new Frame(0,0));
        return onePinDown;
    }
}