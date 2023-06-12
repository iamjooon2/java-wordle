package wordle;

import java.io.IOException;
import java.lang.ModuleLayer.Controller;
import wordle.controller.WordleController;
import wordle.domain.AnswerFactory;

public class Application {
    public static void main(String[] args) throws IOException {
        final var wordleController = new WordleController(new AnswerFactory());
        wordleController.run();
    }
}
