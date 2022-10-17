package baseball.domain.view;

import baseball.domain.dto.GameResultResponseDto;

public class OutputView {

    public static void printResult(GameResultResponseDto responseDto) {
        printNothing(responseDto);
        printBall(responseDto);
        printStrike(responseDto);
        printBallAndStrike(responseDto);
    }

    private static void printBallAndStrike(GameResultResponseDto responseDto) {
        if (responseDto.getStrike() != 0 && responseDto.getBall() != 0) {
            System.out.printf("%d볼 %d스트라이크\n", responseDto.getBall(), responseDto.getStrike());
        }
    }

    private static void printStrike(GameResultResponseDto responseDto) {
        if (responseDto.getStrike() != 0 && responseDto.getBall() == 0) {
            System.out.printf("%d스트라이크\n", responseDto.getStrike());
        }
    }

    private static void printBall(GameResultResponseDto responseDto) {
        if (responseDto.getStrike() == 0 && responseDto.getBall() != 0) {
            System.out.printf("%d볼\n", responseDto.getBall());
        }
    }

    private static void printNothing(GameResultResponseDto responseDto) {
        if (responseDto.getStrike() == 0 && responseDto.getBall() == 0) {
            System.out.println("낫싱");
        }
    }
}
