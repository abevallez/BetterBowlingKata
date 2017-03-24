public class Frame{

    /**
     * First Roll
     */
    private int firstRoll;

    /**
     * Second Roll
     */
    private int secondRoll;

    /**
     * Score
     */
    private int score;

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

    public boolean equals(Frame frame) {
        return (this.getFirstRoll() == frame.getFirstRoll()
                && this.getSecondRoll() == frame.getSecondRoll());
    }
}
