package baseball.domain.Controller;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.Referee;
import baseball.domain.dto.GameResultResponseDto;
import baseball.domain.view.InputView;
import baseball.domain.view.OutputView;

public class Controller {

    private Referee referee;

    public void run() {
        Computer computer = new Computer();

        boolean reGameFlag = true;
        referee = new Referee(new Player(InputView.inputNumber()), computer);

        while (reGameFlag) {
            GameResultResponseDto resultResponseDto = referee.playGame();
            OutputView.printResult(resultResponseDto);

            if (resultResponseDto.isGameWin()) {
                if (InputView.endGame() == 2) {
                    break;
                }
                referee.changeComputer(new Computer());
            }

            referee.changePlayer(new Player(InputView.inputNumber()));
        }

    }
}
