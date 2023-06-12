package wordle;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;
import static org.junit.jupiter.api.Assertions.assertAll;
import static wordle.Tile.GRAY;
import static wordle.Tile.GREEN;
import static wordle.Tile.YELLOW;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class GameTest {

    @Test
    void 게임_결과를_알_수_있다() {
        // given
        final Game game = new Game(List.of("h", "a", "p", "p", "y"));

        // when
        final List<Tile> result = game.play(List.of("a", "b", "c", "d", "e"));

        // then
        assertThat(result).containsExactly(YELLOW, GRAY, GRAY, GRAY, GRAY);
    }

    @Test
    void 게임_결과를_알_수_있다2() {
        // given
        final Game game = new Game(List.of("h", "a", "p", "p", "y"));

        // when
        final List<Tile> result = game.play(List.of("a", "a", "c", "d", "e"));

        // then
        assertThat(result).containsExactly(YELLOW, GREEN, GRAY, GRAY, GRAY);
    }

    @Test
    void 게임_결과를_알_수_있다3() {
        // given
        final Game game = new Game(List.of("h", "a", "p", "p", "y"));

        // when
        final List<Tile> result = game.play(List.of("p", "p", "h", "a", "y"));

        // then
        assertThat(result).containsExactly(YELLOW, YELLOW, YELLOW, YELLOW, GREEN);
    }


    @Test
    void 게임_결과를_알_수_있다4() {
        // given
        final Game game = new Game(List.of("h", "a", "p", "p", "y"));

        // when
        final List<Tile> result = game.play(List.of("h", "a", "p", "p", "y"));

        // then
        assertThat(result).containsExactly(GREEN, GREEN, GREEN, GREEN, GREEN);
    }

    @Test
    void 모든_결과를_알_수_있다() {
        // given
        final Game game = new Game(List.of("h", "a", "p", "p", "y"));

        game.play(List.of("a", "b", "c", "d", "e"));
        game.play(List.of("a", "a", "c", "d", "e"));
        game.play(List.of("h", "a", "p", "p", "y"));

        // when
        final List<Result> results = game.getResults();

        // then
        assertAll(
                () -> assertThat(results).hasSize(3),
                () -> assertThat(results.get(0).getTiles()).containsExactly(YELLOW, GRAY, GRAY, GRAY, GRAY),
                () -> assertThat(results.get(1).getTiles()).containsExactly(YELLOW, GREEN, GRAY, GRAY, GRAY),
                () -> assertThat(results.get(2).getTiles()).containsExactly(GREEN, GREEN, GREEN, GREEN, GREEN)
        );



        // then
    }

}
