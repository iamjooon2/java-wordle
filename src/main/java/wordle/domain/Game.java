package wordle.domain;

import java.util.List;

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
        final Word word = new Word(target);
        final List<Tile> tiles = answer.match(word);
        results.add(tiles);
        trial.plyOneTime();
        return results;
    }

    public boolean isPlaying() {
        return trial.isLeft() && !results.hasWin();
    }

    public Trial getTrial() {
        return trial;
    }

    public List<Result> getResults() {
        return results.getResults();
    }
}
