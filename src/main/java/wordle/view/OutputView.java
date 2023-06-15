package wordle.view;

import static wordle.domain.Tile.GRAY;
import static wordle.domain.Tile.GREEN;
import static wordle.domain.Tile.YELLOW;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import wordle.domain.Result;
import wordle.domain.Tile;
import wordle.domain.Trial;

public class OutputView {
    private static final String INIT_MESSAGE = "WORDLE을 " + Trial.MAX_TRIAL  +"번 만에 맞춰 보세요.\n"
            + "시도의 결과는 타일의 색 변화로 나타납니다.";
    private static final String GRAY_VIEW = "⬜";
    private static final String YELLOW_VIEW = "\uD83D\uDFE8";
    private static final String GREEN_VIEW = "\uD83D\uDFE9";
    private static final String NEXT_LINE = System.lineSeparator();
    private static final Map<Tile, String> TILE_VIEW = Map.of(GRAY, GRAY_VIEW, GREEN, GREEN_VIEW, YELLOW, YELLOW_VIEW);

    private OutputView() {
    }

    public static void printStartMessage() {
        System.out.println(INIT_MESSAGE);
    }


    public static void printResult(final List<Result> results) {
        final String result = results.stream()
                .map(it -> generateResult(it.getTiles()))
                .collect(Collectors.joining(NEXT_LINE));
        System.out.println(result);
    }
    private static String generateResult(final List<Tile> tiles) {
        return tiles.stream()
                .map(TILE_VIEW::get)
                .collect(Collectors.joining());
    }

    public static void printResults(final Trial trial, final List<Result> results) {
        System.out.println(trial.value() + " / " + Trial.MAX_TRIAL);
        printResult(results);
    }
}
