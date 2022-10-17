package baseball.domain;

import baseball.domain.dto.GameResultResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {

    private GameResult gameResult;

    @BeforeEach
    void setUp() {
        gameResult = new GameResult();
    }

    @DisplayName("strike 증가")
    @Test
    void increaseStrike() {
        gameResult.increaseStrike();

        GameResultResponseDto responseDto = gameResult.toResponseDto();
        assertThat(responseDto.getStrike()).isEqualTo(1);
        assertThat(responseDto.getBall()).isEqualTo(0);
    }

    @DisplayName("ball 증가")
    @Test
    void increaseBall() {
        gameResult.increaseBall();

        GameResultResponseDto responseDto = gameResult.toResponseDto();
        assertThat(responseDto.getStrike()).isEqualTo(0);
        assertThat(responseDto.getBall()).isEqualTo(1);
    }
}