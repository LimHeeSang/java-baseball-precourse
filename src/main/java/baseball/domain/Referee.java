package baseball.domain;

import baseball.domain.dto.GameResultResponseDto;

public class Referee {

    private static final int GAME_ROUND = 3;

    private final Player player;
    private final Computer computer;

    public Referee(Player player, Computer computer) {
        this.player = player;
        this.computer = computer;
    }

    public GameResultResponseDto playGame() {
        GameResult gameResult = new GameResult();

        for (int round = 0; round < GAME_ROUND; round++) {
            Ball playBall = player.throwRoundBall(round);
            playOneRound(playBall, gameResult);
        }

        return gameResult.toResponseDto();
    }

    private void playOneRound(Ball playerBall, GameResult gameResult) {
        for (int round = 0; round < GAME_ROUND; round++) {
            Ball computerBall = computer.throwRoundBall(round);

            judgeBall(playerBall, computerBall, gameResult);
        }
    }

    private void judgeBall(Ball playerBall, Ball computerBall, GameResult gameResult) {
        if (playerBall.isStrike(computerBall)) {
            gameResult.increaseStrike();
        }
        if (playerBall.isBall(computerBall)) {
            gameResult.increaseBall();
        }
    }
}
