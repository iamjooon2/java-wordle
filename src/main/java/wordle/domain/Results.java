package wordle.domain;

import java.util.LinkedList;
import java.util.List;

public class Results {

    private final List<Result> results;

    public Results() {
        this.results = new LinkedList<>();
    }

    public void add(final List<Tile> tiles) {
        results.add(new Result(tiles));
    }

    public boolean hasWin() {
        return results.stream()
                .anyMatch(Result::isWin);
    }

    public List<Result> getResults() {
        return results;
    }
}
