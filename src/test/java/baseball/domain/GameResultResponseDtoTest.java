package baseball.domain;

import baseball.domain.dto.GameResultResponseDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResultResponseDtoTest {

    private GameResultResponseDto responseDto;

    @BeforeEach
    void setUp() {
        responseDto = new GameResultResponseDto(1, 2);
    }

    @DisplayName("dto getStrike 검증")
    @Test
    void getStrike() {
        Assertions.assertThat(responseDto.getStrike()).isEqualTo(1);
    }

    @DisplayName("dto getBall 검증")
    @Test
    void getBall() {
        Assertions.assertThat(responseDto.getBall()).isEqualTo(2);
    }
}