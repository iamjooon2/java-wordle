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

    @Test
    void 글자들이_같으면_동등하다() {
        // given
        final List<String> words = List.of("a", "b", "c", "d", "e");

        // when
        final Word firstWord = new Word(words);
        final Word secondWord = new Word(words);

        // then
        assertThat(firstWord).isEqualTo(secondWord);
    }

    @Test
    void 해당_순서에_글자가_있는지_알_수_있다() {
        // given
        final Letter letter = new Letter("a");
        final Word word = new Word(List.of("a", "b", "c", "d", "e"));

        // expect
        assertAll(
                () -> assertThat(word.hasAt(0, letter)).isTrue(),
                () -> assertThat(word.hasAt(1, letter)).isFalse()
        );
    }

    @Test
    void 글자가_없는지_알_수_있다() {
        // given
        final Letter letter = new Letter("z");
        final Word word = new Word(List.of("a", "b", "c", "d", "e"));

        // when
        final boolean flag = word.doesntHave(letter);

        // then
        assertThat(flag).isTrue();
    }
}
