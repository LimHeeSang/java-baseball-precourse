package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {

    @DisplayName("Ball이 값 객체인지 검증")
    @Test
    void create() {
        Ball ball1 = new Ball(1);
        Ball ball2 = new Ball(1);
        assertThat(ball1).isEqualTo(ball2);
    }
}