package wordle.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scan = new Scanner(System.in);

    private InputView() {
    }

    public static List<String> readAnswer(){
        return Arrays.stream(scan.next().split(""))
                .collect(Collectors.toList());
    }
}
