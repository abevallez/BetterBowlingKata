public class LastFrame  extends Frame{

    /**
     * First extra roll
     */
    private int firstExtraRoll = 0;

    /**
     * Second extra roll
     */
    private int secondExtraRoll = 0;

    /**
     * @param firstRoll
     * @param secondRoll
     */
    public LastFrame(int firstRoll, int secondRoll) {
        super(firstRoll,secondRoll);
    }

    /**
     *
     * @param firstRoll
     * @param secondRoll
     * @param firstExtraRoll
     */
    public LastFrame(int firstRoll, int secondRoll, int firstExtraRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
        this.firstExtraRoll = firstExtraRoll;
        this.setScore();
    }

    /**
     *
     * @param firstRoll
     * @param secondRoll
     * @param firstExtraRoll
     * @param secondExtraRoll
     */
    public LastFrame(int firstRoll, int secondRoll, int firstExtraRoll, int secondExtraRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
        this.firstExtraRoll = firstExtraRoll;
        this.secondExtraRoll = secondExtraRoll;
        this.setScore();
    }

    /**
     * Get First Extra Roll
     *
     * @return
     */
    public int getFirstExtraRoll() {
        return firstExtraRoll;
    }

    /**
     * Get Second Extra Roll
     *
     * @return
     */
    public int getSecondExtraRoll() {
        return secondExtraRoll;
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
     * Set Score
     *
     * @return
     */
    private void setScore() {
        this.score = this.firstRoll + this.secondRoll + this.firstExtraRoll + this.secondExtraRoll;
    }

    /**
     *
     * @param frame
     * @return
     */
    public boolean equals(LastFrame frame) {
        return (this.getFirstRoll() == frame.getFirstRoll()
                && this.getSecondRoll() == frame.getSecondRoll()
                && this.getFirstExtraRoll() == frame.getFirstExtraRoll()
                && this.getSecondExtraRoll() == frame.getSecondExtraRoll());
    }
}
