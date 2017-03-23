public class Game {

    /**
     * Frames annotation in a Game
     */
    protected int[][] frames = new int[10][2];

    /**
     * @param annotation String score for a game.
     */
    public Game(String annotation) {
        frames[0][0] = 0;
        frames[0][1] = 0;
    }
}
