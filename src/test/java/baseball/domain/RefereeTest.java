package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RefereeTest {

    private Referee referee;
    private Player player;
    private Computer computer;

    private List<Ball> createTestBalls(int num1, int num2, int num3) {
        return Arrays.asList(
                new Ball(0, num1),
                new Ball(1, num2),
                new Ball(2, num3)
        );
    }

    @DisplayName("3strike인지 테스트")
    @Test
    void isThreeStrike() {
        player = new Player(createTestBalls(1, 2, 3));
        computer = new Computer(createTestBalls(1, 2, 3));
        referee = new Referee(player, computer);

        GameResultResponseDto responseDto = referee.playGame();
        assertThat(responseDto.getStrike()).isEqualTo(3);
        assertThat(responseDto.getBall()).isEqualTo(0);
    }

}