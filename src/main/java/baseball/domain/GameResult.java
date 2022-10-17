package baseball.domain;

import baseball.domain.dto.GameResultResponseDto;

import java.util.Objects;

public class GameResult {

    private int strike = 0;
    private int ball = 0;

    public void increaseStrike() {
        strike++;
    }

    public void increaseBall() {
        ball++;
    }

    public GameResultResponseDto toResponseDto() {
        return new GameResultResponseDto(strike, ball);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return strike == that.strike && ball == that.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }
}
