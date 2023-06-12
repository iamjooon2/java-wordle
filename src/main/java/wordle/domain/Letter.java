package wordle.domain;

import java.util.Objects;

public class Letter {
    private static final char SMALL_A = 'a';
    private static final char SMALL_Z = 'z';

    private final String value;

    public Letter(final String value) {
        validate(value);
        this.value = value;
    }

    private void validate(final String value) {
        for (char charValue : value.toCharArray()) {
            if (SMALL_Z < charValue || charValue < SMALL_A) {
                throw new IllegalArgumentException("글자는 영어 소문자만 입력가능합니다.");
            }
        }
    }

    public boolean isSame(final Letter letter) {
        return this.value.equals(letter.value());
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Letter)) {
            return false;
        }
        final Letter letter = (Letter) o;
        return Objects.equals(value, letter.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
