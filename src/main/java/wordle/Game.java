package wordle;

import static wordle.Tile.GRAY;
import static wordle.Tile.GREEN;
import static wordle.Tile.YELLOW;
import static wordle.Word.WORD_VALID_SIZE;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {

    private final Results results;
    private final Word answer;

    public Game(final List<String> answer) {
        this.answer = new Word(answer);
        this.results = new Results();
    }

    public List<Tile> play(final List<String> target) {
        final List<Tile> tiles = IntStream.range(0, WORD_VALID_SIZE)
                .mapToObj(index -> getTile(new Letter(target.get(index)), index))
                .collect(Collectors.toList());
        results.add(tiles);
        return tiles;
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

    public List<Result> getResults() {
        return results.getResults();
    }
}
