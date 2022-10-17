package baseball.domain;

import baseball.domain.dto.GameResultResponseDto;
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

    @DisplayName("게임 결과 3strike인지 검증")
    @Test
    void isThreeStrike() {
        player = new Player(createTestBalls(1, 2, 3));
        computer = new Computer(createTestBalls(1, 2, 3));
        referee = new Referee(player, computer);

        GameResultResponseDto responseDto = referee.playGame();
        assertThat(responseDto.getStrike()).isEqualTo(3);
        assertThat(responseDto.getBall()).isEqualTo(0);
    }

    @DisplayName("게임 결과 3ball인지 검증")
    @Test
    void isThreeBall() {
        player = new Player(createTestBalls(1, 2, 3));
        computer = new Computer(createTestBalls(3, 1, 2));
        referee = new Referee(player, computer);

        GameResultResponseDto responseDto = referee.playGame();
        assertThat(responseDto.getStrike()).isEqualTo(0);
        assertThat(responseDto.getBall()).isEqualTo(3);
    }

    @DisplayName("게임 결과 nothing인지 검증")
    @Test
    void isNothing() {
        player = new Player(createTestBalls(1, 2, 3));
        computer = new Computer(createTestBalls(4, 5, 6));
        referee = new Referee(player, computer);

        GameResultResponseDto responseDto = referee.playGame();
        assertThat(responseDto.getStrike()).isEqualTo(0);
        assertThat(responseDto.getBall()).isEqualTo(0);
    }

    @DisplayName("게임 결과 1strike 1ball인지 검증")
    @Test
    void isOneStrikeOneBall() {
        player = new Player(createTestBalls(1, 2, 3));
        computer = new Computer(createTestBalls(1, 5, 2));
        referee = new Referee(player, computer);

        GameResultResponseDto responseDto = referee.playGame();
        assertThat(responseDto.getStrike()).isEqualTo(1);
        assertThat(responseDto.getBall()).isEqualTo(1);
    }

    @DisplayName("게임 결과 1strike 2ball인지 검증")
    @Test
    void isOneStrikeTwoBall() {
        player = new Player(createTestBalls(1, 2, 3));
        computer = new Computer(createTestBalls(3, 2, 1));
        referee = new Referee(player, computer);

        GameResultResponseDto responseDto = referee.playGame();
        assertThat(responseDto.getStrike()).isEqualTo(1);
        assertThat(responseDto.getBall()).isEqualTo(2);
    }

    @DisplayName("게임 결과 2strike 인지 검증")
    @Test
    void isTwoStrike() {
        player = new Player(createTestBalls(1, 2, 3));
        computer = new Computer(createTestBalls(1, 2, 7));
        referee = new Referee(player, computer);

        GameResultResponseDto responseDto = referee.playGame();
        assertThat(responseDto.getStrike()).isEqualTo(2);
        assertThat(responseDto.getBall()).isEqualTo(0);
    }

    @DisplayName("게임 결과 2ball 인지 검증")
    @Test
    void isTwoBall() {
        player = new Player(createTestBalls(1, 2, 3));
        computer = new Computer(createTestBalls(3, 7, 1));
        referee = new Referee(player, computer);

        GameResultResponseDto responseDto = referee.playGame();
        assertThat(responseDto.getStrike()).isEqualTo(0);
        assertThat(responseDto.getBall()).isEqualTo(2);
    }
}