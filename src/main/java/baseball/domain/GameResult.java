package baseball.domain;

import baseball.domain.dto.GameResultResponseDto;

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
}
