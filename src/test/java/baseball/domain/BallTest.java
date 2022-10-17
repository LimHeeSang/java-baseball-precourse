package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {
    private Ball ball1;
    private Ball ball2;
    private Ball ball3;
    private Ball ball4;

    @BeforeEach
    void setUp() {
        ball1 = new Ball(1, 1);
        ball2 = new Ball(1, 1);
        ball3 = new Ball(2, 1);
        ball4 = new Ball(3, 3);
    }

    @DisplayName("두개의 볼이 스트라이크 인지 검증")
    @Test
    void isStrike() {
        assertThat(ball1.isStrike(ball2)).isTrue();
    }

    @DisplayName("두개의 볼이 볼인지 인지 검증")
    @Test
    void isBall() {
        assertThat(ball1.isBall(ball3)).isTrue();
    }
}