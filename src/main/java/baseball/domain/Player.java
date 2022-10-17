package baseball.domain;

import java.util.List;

public class Player {

    private final List<Ball> balls;

    public Player(List<Ball> balls) {
        this.balls = balls;
    }

    public Ball throwRoundBall(int roundNumber) {
        return balls.get(roundNumber);
    }
}
