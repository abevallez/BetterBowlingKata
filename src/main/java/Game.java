public class Game {

    /**
     * Frames annotation in a Game
     */
    private int[][] frames = new int[10][2];

    /**
     * @param annotation String score for a game.
     */
    public Game(String annotation) {
        for (int i = 0, j=0; j < annotation.length(); i++,j = j+2) {
            frames[i][0] = Character.getNumericValue(annotation.charAt(j));
            frames[i][1] = Character.getNumericValue(annotation.charAt(j+1));
        }
    }

    public int[][] getFrames() {
        return frames;
    }
}
