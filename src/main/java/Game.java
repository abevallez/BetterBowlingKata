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
        int firstFrame;
        int secondFrame;

        for (int i = 0, j = 0; j < annotation.length(); i++,j = j+2) {
            firstFrame = Character.getNumericValue(annotation.charAt(j));
            secondFrame = Character.getNumericValue(annotation.charAt(j+1));
            frames.add(i, new Frame(firstFrame, secondFrame));
        }
    }

    public List<Frame> getFrames() {
        return frames;
    }
}
