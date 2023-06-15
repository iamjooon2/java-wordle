package wordle.domain;

import static wordle.domain.Tile.GRAY;
import static wordle.domain.Tile.GREEN;
import static wordle.domain.Tile.YELLOW;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Word {
    private static final int VALID_WORD_SIZE = 5;

    private final List<Letter> letters;

    private Word(final List<Letter> letters) {
        this.letters = letters;
    }

    public static Word from(final List<String> values) {
        validate(values);
        final List<Letter> letters = values.stream()
                .map(Letter::new)
                .collect(Collectors.toList());
        return new Word(letters);
    }

    private static void validate(final List<String> values) {
        if (values.size() != VALID_WORD_SIZE) {
            throw new IllegalArgumentException(String.format("답안은 총 %d글자여야 합니다.", VALID_WORD_SIZE));
        }
    }

    public List<Tile> match(final Word target) {
        return IntStream.range(0, VALID_WORD_SIZE)
                .mapToObj(index -> getTile(target.get(index), index))
                .collect(Collectors.toList());
    }

    private Tile getTile(final Letter letter, final int index) {
        if (doesntHave(letter)) {
            return GRAY;
        }
        if (hasAt(index, letter)) {
            return GREEN;
        }
        return YELLOW;
    }

    private boolean hasAt(final int index, final Letter target) {
        final Letter source = letters.get(index);
        return source.equals(target);
    }

    private boolean doesntHave(final Letter target) {
        return !letters.contains(target);
    }

    public Letter get(final int index) {
        return letters.get(index);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Word)) {
            return false;
        }
        final Word word = (Word) o;
        return Objects.equals(letters, word.letters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(letters);
    }
}
