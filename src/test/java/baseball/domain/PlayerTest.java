package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player(Arrays.asList(4, 5, 6));
    }

    @DisplayName("플레이어가 라운드 볼을 던지는 기능 테스트")
    @Test
    void throwBall() {
        assertThat(player.throwRoundBall(0)).isEqualTo(new Ball(0, 4));
        assertThat(player.throwRoundBall(1)).isEqualTo(new Ball(0, 5));
        assertThat(player.throwRoundBall(2)).isEqualTo(new Ball(0, 6));
    }
}