package helper;

public class ScoreValueHelper {
    public static int getScoreValue(String textureName) {
        return switch (textureName) {
            case "book" -> 20;
            case "bomb" -> -50;
            default -> 10;
        };
    }
}
