import java.util.ArrayList;
import java.util.List;

/**
 * Game
 */
public class Game {

    /**
     * Frames annotation in a Game
     */
    protected List<Frame> frames = new ArrayList<Frame>();

    /**
     * Game
     */
    public Game() {
    }

    /**
     * @param annotation String score for a game.
     */
    public Game(String annotation) {
        setFrames(annotation);
    }

    /**
     * Set Frames from annotation
     *
     * @param annotation
     */
    private void setFrames(String annotation) {
        setFirstEightFrames(annotation);
        setLastFrame(annotation);

    }

    private void setLastFrame(String annotation) {
        int firstRoll;
        int secondRoll;
        int firstExtraRoll;
        int secondExtraRoll;

        switch (annotation.length()) {
            case 20:
                firstRoll = Character.getNumericValue(annotation.charAt(18));
                secondRoll = Character.getNumericValue(annotation.charAt(19));
                this.frames.add(9, new LastFrame(firstRoll, secondRoll));
                break;
            case 21:
                firstRoll = Character.getNumericValue(annotation.charAt(18));
                secondRoll = Character.getNumericValue(annotation.charAt(19));
                firstExtraRoll = Character.getNumericValue(annotation.charAt(20));
                this.frames.add(9, new LastFrame(firstRoll, secondRoll, firstExtraRoll));
                break;
            case 22:
                firstRoll = Character.getNumericValue(annotation.charAt(18));
                secondRoll = Character.getNumericValue(annotation.charAt(19));
                firstExtraRoll = Character.getNumericValue(annotation.charAt(20));
                secondExtraRoll = Character.getNumericValue(annotation.charAt(21));
                this.frames.add(9, new LastFrame(firstRoll, secondRoll, firstExtraRoll, secondExtraRoll));
                break;
        }
    }

    private void setFirstEightFrames(String annotation) {
        int firstRoll;
        int secondRoll;

        for (int i = 0, j = 0; i<=8; i++,j = j+2) {
            firstRoll = Character.getNumericValue(annotation.charAt(j));
            secondRoll = Character.getNumericValue(annotation.charAt(j+1));
            this.frames.add(i, new Frame(firstRoll, secondRoll));
        }
    }

    public List<Frame> getFrames() {
        return frames;
    }
}
