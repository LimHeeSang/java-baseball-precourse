package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.Referee;
import baseball.dto.GameResultResponseDto;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Controller {

    public static final int END_NUMBER = 2;
    private Referee referee;

    public void run() {
        Computer computer = new Computer();
        referee = new Referee(new Player(InputView.inputNumber()), computer);

        // TODO: 2022-10-18 리팩토링 필요
        boolean reGameFlag = true;
        while (reGameFlag) {
            GameResultResponseDto resultResponseDto = referee.playGame();
            OutputView.printResult(resultResponseDto);

            if (resultResponseDto.isGameWin()) {
                OutputView.printEndGame();
                if (InputView.inputRestart() == END_NUMBER) {
                    break;
                }
                referee.changeComputer(new Computer());
            }

            referee.changePlayer(new Player(InputView.inputNumber()));
        }

    }
}
