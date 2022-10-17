package baseball.domain.dto;

public class GameResultResponseDto {

    public static final int THREE_STRIKE = 3;
    private final int strike;
    private final int ball;

    public GameResultResponseDto(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isGameWin() {
        return strike == THREE_STRIKE;
    }
}
