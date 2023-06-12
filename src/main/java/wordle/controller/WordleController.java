package wordle.controller;

import java.io.IOException;
import java.util.List;
import wordle.domain.AnswerFactory;
import wordle.domain.Game;
import wordle.domain.Results;
import wordle.view.InputView;
import wordle.view.OutputView;

public class WordleController {

    private final AnswerFactory answerFactory;

    public WordleController(final AnswerFactory answerFactory) {
        this.answerFactory = answerFactory;
    }

    public void run() throws IOException {
        OutputView.printStartMessage();
        final List<String> answer = answerFactory.create();
        final Game game = new Game(answer);

        while (game.isPlaying()) {
            final List<String> userAnswer = InputView.readAnswer();
            final Results results = game.play(userAnswer);
            OutputView.printResult(results.getResults());
        }

        OutputView.printResults(game.getTrial(), game.getResults());
    }
}
