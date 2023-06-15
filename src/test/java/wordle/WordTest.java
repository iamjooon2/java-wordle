package wordle;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import wordle.domain.Letter;
import wordle.domain.Word;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class WordTest {

    @ParameterizedTest(name = "답안의 글자는 총 5자여야 한다: 입력 = {0}")
    @MethodSource("wrongLengthWord")
    void 답안의_글자는_다섯자여야_한다(final List<String> wrongSizeLetters) {

        // then
        assertThatThrownBy(() -> new Word(wrongSizeLetters))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5글자");
    }

    static List<Arguments> wrongLengthWord() {
        return List.of(
                Arguments.of(List.of("a", "b", "c", "d")),
                Arguments.of(List.of("a", "b", "c", "d", "e", "f"))
        );
    }
}
