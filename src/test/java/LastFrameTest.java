import static org.junit.Assert.*;

import org.junit.Test;

/**
 * LastFrame Test
 */
public class LastFrameTest  extends FrameTest {

    @Test
    public void rollsAreSetWhenCreateWithoutExtraRoll() {
        int firstRoll = 1;
        int secondRoll = 2;

        Frame frame = new LastFrame(firstRoll, secondRoll);
        assertEquals(String.format("first Roll must be %d", firstRoll), firstRoll, frame.getFirstRoll());
        assertEquals(String.format("second Roll must be %d", secondRoll), secondRoll, frame.getSecondRoll());
    }

    @Test
    public void rollsAreSetWhenCreateWithOneExtraRoll() {
        int firstRoll = 1;
        int secondRoll = 2;
        int firstExtraRoll = 3;

        LastFrame frame = new LastFrame(firstRoll, secondRoll, firstExtraRoll);
        assertEquals(String.format("first Roll must be %d", firstRoll), firstRoll, frame.getFirstRoll());
        assertEquals(String.format("second Roll must be %d", secondRoll), secondRoll, frame.getSecondRoll());
        assertEquals(String.format("first extra Roll must be %d", firstExtraRoll), firstExtraRoll, frame.getFirstExtraRoll());
    }

    @Test
    public void rollsAreSetWhenCreateWithTwoExtraRolls() {
        int firstRoll = 1;
        int secondRoll = 2;
        int firstExtraRoll = 3;
        int secondExtraRoll = 4;

        LastFrame frame = new LastFrame(firstRoll, secondRoll, firstExtraRoll, secondExtraRoll);
        assertEquals(String.format("first Roll must be %d", firstRoll), firstRoll, frame.getFirstRoll());
        assertEquals(String.format("second Roll must be %d", secondRoll), secondRoll, frame.getSecondRoll());
        assertEquals(String.format("first extra Roll must be %d", firstExtraRoll), firstExtraRoll, frame.getFirstExtraRoll());
        assertEquals(String.format("second extra Roll must be %d", secondExtraRoll), secondExtraRoll, frame.getSecondExtraRoll());
    }

}