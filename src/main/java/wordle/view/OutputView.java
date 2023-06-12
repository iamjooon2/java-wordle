package wordle.view;

import static wordle.domain.Tile.GRAY;
import static wordle.domain.Tile.GREEN;

import java.util.List;
import wordle.domain.Result;
import wordle.domain.Tile;
import wordle.domain.Trial;

public class OutputView {
    private static final String GRAY_VIEW = "⬜";
    private static final String YELLOW_VIEW = "\uD83D\uDFE8";
    private static final String GREEN_VIEW = "\uD83D\uDFE9";

    private OutputView() {
    }

    public static void printResult(final List<Result> results) {
        results.forEach(result -> printTile(result.getTiles()));
    }

    private static void printTile(final List<Tile> tiles) {
        String view = "";
        for (final Tile tile : tiles) {
            if (tile == GRAY) {
                view += GRAY_VIEW;
            }
            if (tile == GREEN) {
                view += GREEN_VIEW;
            }
            view += YELLOW_VIEW;
        }
        System.out.println(view);
    }

}
