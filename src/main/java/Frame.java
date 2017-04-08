/**
 * Frame
 */
public class Frame{

    /**
     * First Roll
     */
    protected int firstRoll;

    /**
     * Second Roll
     */
    protected int secondRoll;

    /**
     * Score
     */
    protected int score;

    /**
     * Frame
     */
    public Frame() {
    }

    /**
     * @param firstRoll
     * @param secondRoll
     */
    public Frame(int firstRoll, int secondRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
        this.score = firstRoll + secondRoll;
    }

    /**
     * Get pin downs in first Roll
     *
     * @return pin downs in first roll
     */
    public int getFirstRoll() {
        return firstRoll;
    }

    /**
     * Get pin downs in second roll
     *
     * @return pin downs in first roll
     */
    public int getSecondRoll() {
        return secondRoll;
    }

    /**
     * Get score in frame
     *
     * @return
     */
    public int getScore() {
        return score;
    }

    /**
     * Set Score
     *
     * @return
     */
    private void setScore() {
        this.score = this.firstRoll + this.secondRoll;
    }

    /**
     *
     * @param frame
     * @return
     */
    public boolean equals(Frame frame) {
        return (this.getFirstRoll() == frame.getFirstRoll()
                && this.getSecondRoll() == frame.getSecondRoll());
    }
}
