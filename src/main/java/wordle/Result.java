package wordle;

import java.util.List;

public class Result {

    private final List<Tile> result;

    public Result(final List<Tile> result) {
        this.result = result;
    }

    public List<Tile> getTiles() {
        return result;
    }
}
