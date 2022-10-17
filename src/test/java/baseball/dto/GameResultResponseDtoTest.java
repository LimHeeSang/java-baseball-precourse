package baseball.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultResponseDtoTest {

    private GameResultResponseDto responseDto;

    @BeforeEach
    void setUp() {
        responseDto = new GameResultResponseDto(1, 2);
    }

    @DisplayName("dto getStrike 검증")
    @Test
    void getStrike() {
        assertThat(responseDto.getStrike()).isEqualTo(1);
    }

    @DisplayName("dto getBall 검증")
    @Test
    void getBall() {
        assertThat(responseDto.getBall()).isEqualTo(2);
    }

    @DisplayName("3strike 인지 검증")
    @Test
    void isThreeStrike() {
        responseDto = new GameResultResponseDto(3, 0);
        assertThat(responseDto.isGameWin()).isTrue();
    }
}