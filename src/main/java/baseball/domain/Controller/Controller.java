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
        while (reGameFlag) {
            referee = new Referee(new Player(InputView.inputNumber()), computer);

            GameResultResponseDto resultResponseDto = referee.playGame();
            OutputView.printResult(resultResponseDto);

            reGameFlag = isRestartGame(resultResponseDto);
        }

    }

    private boolean isRestartGame(GameResultResponseDto resultResponseDto) {
        if (resultResponseDto.isGameWin()) {
            referee.changeComputer(new Computer());
            return (InputView.endGame() == 1);
        }
        return true;
    }
}
