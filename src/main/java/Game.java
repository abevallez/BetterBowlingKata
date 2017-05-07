import java.util.ArrayList;
import java.util.List;

/**
 * Game
 */
public class Game {

    static final char STRIKE_SIGNAL = 'X';
    static final int STRIKE_VALUE = 10;
    static final int SPARE_VALUE = 10;

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
        char firstRoll;
        char secondRoll;
        char firstExtraRoll;
        char secondExtraRoll;

        int i;
        int j;

        for (i = 0, j = 0; i<=8; i++) {
            firstRoll = annotation.charAt(j);
            secondRoll = annotation.charAt(j+1);

            if (STRIKE_SIGNAL == firstRoll) {
                this.frames.add(i, new Frame(signalToPoints(STRIKE_SIGNAL), 0));
                j++;
            } else {
                this.frames.add(i, new Frame(signalToPoints(firstRoll), signalToPoints(secondRoll)));
                j = j+2;
            }
        }

        firstRoll = annotation.charAt(j);
        secondRoll = annotation.charAt(j + 1);

        if (STRIKE_SIGNAL == firstRoll) {
            firstExtraRoll = annotation.charAt(j + 2);
            secondExtraRoll = annotation.charAt(j + 3);
            this.frames.add(i, new LastFrame(STRIKE_VALUE, 0, signalToPoints(firstExtraRoll), signalToPoints(secondExtraRoll)));
        } else {
            LastFrame lastFrame = new LastFrame(signalToPoints(firstRoll), signalToPoints(secondRoll));
            if (SPARE_VALUE == lastFrame.getScore()) {
                firstExtraRoll = annotation.charAt(j + 2);
                lastFrame = new LastFrame(signalToPoints(firstRoll), signalToPoints(secondRoll), signalToPoints(firstExtraRoll));
            }
            this.frames.add(i, lastFrame);
        }
    }

    private int signalToPoints(char signal) {
        switch (signal) {
            case 'X':
                return STRIKE_VALUE;
            case '-':
                return 0;
            default:
                return Character.getNumericValue(signal);
        }
    }

    public List<Frame> getFrames() {
        return frames;
    }
}
