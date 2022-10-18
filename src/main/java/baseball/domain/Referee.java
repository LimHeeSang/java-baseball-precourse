package baseball.domain;

import baseball.dto.GameResultResponseDto;

import java.util.stream.IntStream;

public class Referee {

    public static final int GAME_ROUND = 3;
    public static final int ROUND_ZERO = 0;

    private Player player;
    private Player computer;

    public Referee(Player player, Player computer) {
        this.player = player;
        this.computer = computer;
    }

    public GameResultResponseDto playGame() {
        GameResult gameResult = new GameResult();

        IntStream.range(ROUND_ZERO, GAME_ROUND)
                .mapToObj(round -> player.throwRoundBall(round))
                .forEach(playerBall -> playOneRound(playerBall, gameResult));

        return gameResult.toResponseDto();
    }

    private void playOneRound(Ball playerBall, GameResult gameResult) {
        IntStream.range(ROUND_ZERO, GAME_ROUND)
                .mapToObj(round -> computer.throwRoundBall(round))
                .forEach(computerBall -> judgeBall(playerBall, computerBall, gameResult));
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

    public void changeComputer(Computer newComputer) {
        computer = newComputer;
    }
}
