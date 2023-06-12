package wordle.domain;

import static wordle.domain.Tile.GRAY;
import static wordle.domain.Tile.GREEN;
import static wordle.domain.Tile.YELLOW;
import static wordle.domain.Word.WORD_VALID_SIZE;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {

    private final Results results;
    private final Word answer;
    private final Trial trial;

    public Game(final List<String> answer) {
        this.answer = new Word(answer);
        this.results = new Results();
        this.trial = new Trial();
    }

    public Results play(final List<String> target) {
        final List<Tile> tiles = calculate(target);
        results.add(tiles);
        trial.plyOneTime();
        validateWin(tiles);
        return results;
    }

    private List<Tile> calculate(final List<String> target) {
        return IntStream.range(0, WORD_VALID_SIZE)
                .mapToObj(index -> getTile(new Letter(target.get(index)), index))
                .collect(Collectors.toList());
    }

    private Tile getTile(final Letter letter, final int index) {
        if (answer.doesntHave(letter)) {
            return GRAY;
        }
        if (answer.hasAt(index, letter)) {
            return GREEN;
        }
        return YELLOW;
    }

    private void validateWin(final List<Tile> tiles) {
        if (tiles.stream().allMatch(tile -> tile == GREEN)) {
            trial.finish();
        }
    }

    public boolean isPlaying() {
        return trial.isLeft();
    }

    public Trial getTrial() {
        return trial;
    }

    public List<Result> getResults() {
        return results.getResults();
    }
}
