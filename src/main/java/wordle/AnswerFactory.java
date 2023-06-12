package wordle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AnswerFactory {

    private static final String FILE_PATH = "src/resources/words.txt";
    private static final LocalDate DATE = LocalDate.of(2021, 6, 19);

    public List<String> create() throws IOException {
        final List<String> words = Files.readAllLines(Paths.get(FILE_PATH));

        final LocalDate today = LocalDate.now();
        final Period gap = Period.between(DATE, today);

        final int answerIndex = gap.getDays();

        return Arrays.stream(words.get(answerIndex).split(""))
                .collect(Collectors.toList());
    }

}
