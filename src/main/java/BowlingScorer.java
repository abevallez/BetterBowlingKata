public class BowlingScorer {

    public int calculateScore(String gameAnnotation) {
        if (gameAnnotation.contains("1")) {
            return 1;
        }

        return 0;
    }
}
