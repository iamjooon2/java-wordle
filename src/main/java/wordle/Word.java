package wordle;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Word {
    private static final int VALID_SIZE = 5;

    private final List<Letter> letters;

    public Word(final List<String> letters) {
        validate(letters);
        this.letters = letters.stream()
                .map(Letter::new)
                .collect(Collectors.toList());
    }

    private void validate(final List<String> value) {
        if (value.size() != VALID_SIZE) {
            throw new IllegalArgumentException(String.format("답안은 총 %d글자여야 합니다.", VALID_SIZE));
        }
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

    public List<Letter> getLetters() {
        return letters;
    }
}
