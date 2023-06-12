package wordle;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class LetterTest {

    @ParameterizedTest(name = "영어 소문자가 입력되지 않으면 예외가 발생한다: 입력 = {0}")
    @ValueSource(strings = {"A", "1", "가"})
    void 영어_소문자가_입력되지_않으면_예외가_발생한다(final String value) {
        // expect
        assertThatThrownBy(() -> new Letter(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "영어 소문자를 받아 생성된다: 입력 = {0}")
    @ValueSource(strings = {"a", "b", "y", "z"})
    void 영어_소문자를_받아_생성된다(final String value) {
        // exepct
        assertDoesNotThrow(() -> new Letter(value));
    }


    @Test
    void 값이_같으면_동등하다() {
        // given
        final String value = "a";

        // when
        final Letter firstLetter = new Letter(value);
        final Letter secondLetter = new Letter(value);

        // then
        assertThat(firstLetter).isEqualTo(secondLetter);
    }
}
