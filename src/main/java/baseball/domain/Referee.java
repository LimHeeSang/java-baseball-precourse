package baseball.domain;

import baseball.domain.dto.GameResultResponseDto;

public class Referee {

    public static final int GAME_ROUND = 3;

    private Player player;
    private final Player computer;

    public Referee(Player player, Player computer) {
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

    public void changePlayer(Player newPlayer) {
        player = newPlayer;
    }
}
