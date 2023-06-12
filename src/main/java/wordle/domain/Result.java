package wordle.domain;

import java.util.List;

public class Result {

    private final List<Tile> result;

    public Result(final List<Tile> result) {
        this.result = result;
    }

    public List<Tile> getTiles() {
        return result;
    }

    public boolean isWin() {
        return result.stream()
                .allMatch(tile -> tile == Tile.GREEN);
    }
}
