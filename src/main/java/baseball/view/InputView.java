package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    public static final String INPUT_REGEX = "^[1-9]{3}$";

    public static List<Integer> inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumbers = Console.readLine();

        validateInputNumbers(inputNumbers);

        String[] splitedNumber = inputNumbers.split("");
        return Arrays.stream(splitedNumber).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static void validateInputNumbers(String inputNumbers) {
        if (!Pattern.matches(INPUT_REGEX, inputNumbers)) {
            throw new IllegalArgumentException("정상적이지 않은 입력 데이터입니다.");
        }
    }

    public static int inputRestart() {
        return Integer.parseInt(Console.readLine());
    }
}
