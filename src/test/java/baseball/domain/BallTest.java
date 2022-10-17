package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {
    private Ball ball1;
    private Ball ball2;

    @BeforeEach
    void setUp() {
        ball1 = new Ball(1);
        ball2 = new Ball(1);
    }

    @DisplayName("Ball이 값 객체인지 검증")
    @Test
    void create() {
        assertThat(ball1).isEqualTo(ball2);
    }

    @DisplayName("Ball의 숫자가 같은 숫자인지 확인")
    @Test
    void isSame() {
        assertThat(ball1).isEqualTo(ball2);
    }
}