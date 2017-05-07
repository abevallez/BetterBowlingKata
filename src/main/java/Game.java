import java.util.ArrayList;
import java.util.List;

/**
 * Game
 */
public class Game {

    static final char STRIKE_SIGNAL = 'X';
    static final int STRIKE_VALUE = 10;
    static final int SPARE_VALUE = 10;
    static final int NUMBER_OF_FRAMES_IN_GAME = 10;
    static final char NO_PINS_SIGNAL = 0;
    static final int NO_PINS = 0;

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
     *
     * @return
     */
    public List<Frame> getFrames() {
        return frames;
    }

    /**
     * Set Frames from annotation
     *
     * @param annotation
     */
    private void setFrames(String annotation) {
        String lastFrameAnnotation = processAllGameUntilLastFrame(annotation);
        processLastFrame(lastFrameAnnotation);
    }

    /**
     *
     * @param annotation
     * @return
     */
    private String processAllGameUntilLastFrame(String annotation) {
        char firstRoll;
        char secondRoll;
        String lastFrameAnnotation;
        int i;
        int j;

        for (i = 0, j = 0; i < NUMBER_OF_FRAMES_IN_GAME - 1; i++) {
            firstRoll = annotation.charAt(j);
            secondRoll = annotation.charAt(j+1);

            if (STRIKE_SIGNAL == firstRoll) {
                this.frames.add(i, new Frame(signalToPoints(STRIKE_SIGNAL), NO_PINS));
                j++;
            } else {
                this.frames.add(i, new Frame(signalToPoints(firstRoll), signalToPoints(secondRoll)));
                j = j+2;
            }
        }

        lastFrameAnnotation = annotation.substring(j);
        return lastFrameAnnotation;
    }

    /**
     *
     * @param lastFrameAnnotation
     */
    private void processLastFrame(String lastFrameAnnotation) {
        char firstRoll;
        char secondRoll;
        char lastIndexFrame = 9;

        firstRoll = lastFrameAnnotation.charAt(0);
        secondRoll = lastFrameAnnotation.charAt(1);
        LastFrame lastFrame;

        if (STRIKE_SIGNAL == firstRoll) {
            lastFrame = getStrikeLastFrame(lastFrameAnnotation);
        } else {
            lastFrame = getSpareLastFrame(lastFrameAnnotation, firstRoll, secondRoll);
        }
        this.frames.add(lastIndexFrame, lastFrame);

    }

    /**
     *
     * @param lastFrameAnnotation
     * @param firstRoll
     * @param secondRoll
     * @return
     */
    private LastFrame getSpareLastFrame(String lastFrameAnnotation, char firstRoll, char secondRoll) {
        LastFrame lastFrame;
        char firstExtraRoll;
        lastFrame = new LastFrame(signalToPoints(firstRoll), signalToPoints(secondRoll));
        if (SPARE_VALUE == lastFrame.getScore()) {
            firstExtraRoll = lastFrameAnnotation.charAt(2);
            lastFrame = new LastFrame(signalToPoints(firstRoll), signalToPoints(secondRoll), signalToPoints(firstExtraRoll));
        }
        return lastFrame;
    }

    /**
     *
     * @param lastFrameAnnotation
     * @return
     */
    private LastFrame getStrikeLastFrame(String lastFrameAnnotation) {
        char firstExtraRoll;
        char secondExtraRoll;
        LastFrame lastFrame;
        firstExtraRoll = lastFrameAnnotation.charAt(2);
        secondExtraRoll = lastFrameAnnotation.charAt(3);
        lastFrame = new LastFrame(STRIKE_VALUE, NO_PINS, signalToPoints(firstExtraRoll), signalToPoints(secondExtraRoll));
        return lastFrame;
    }

    /**
     *
     * @param signal
     * @return
     */
    private int signalToPoints(char signal) {
        switch (signal) {
            case STRIKE_SIGNAL:
                return STRIKE_VALUE;
            case NO_PINS_SIGNAL:
                return NO_PINS;
            default:
                return Character.getNumericValue(signal);
        }
    }
}
