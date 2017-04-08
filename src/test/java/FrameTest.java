import static org.junit.Assert.*;

import org.junit.Test;


/**
 * Frame test
 */
public class FrameTest {

    @Test
    public void rollsAreSetWhenCreate() {
        int firstRoll = 1;
        int secondRoll = 2;

        Frame frame = new Frame(firstRoll, secondRoll);
        assertEquals(String.format("first Roll must be %d", firstRoll), firstRoll, frame.getFirstRoll());
        assertEquals(String.format("second Roll must be %d", secondRoll), secondRoll, frame.getSecondRoll());
    }
}
