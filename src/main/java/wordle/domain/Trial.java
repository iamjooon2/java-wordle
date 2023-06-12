package wordle.domain;

import java.util.Objects;

public class Trial {

    private static final int INITIAL_TRIAL = 0;
    public static final int MAX_TRIAL = 6;

    private int value;

    public Trial() {
        this.value = INITIAL_TRIAL;
    }

    public void plyOneTime() {
        this.value++;
    }

    public boolean isLeft() {
        return value != MAX_TRIAL;
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Trial)) {
            return false;
        }
        final Trial trial = (Trial) o;
        return value == trial.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
