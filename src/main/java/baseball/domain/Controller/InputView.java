package baseball.domain.Controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static List<Integer> inputNumber() {
        System.out.print("숫자를 입력해주세요 :");
        String inputNumbers = Console.readLine();
        String[] splitedNumber = inputNumbers.split("");

        return Arrays.stream(splitedNumber).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static int endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(Console.readLine());
    }
}
