package baseball.domain;

public class Ball {

    private final int index;
    private final int number;

    public Ball(int index, int number) {
        this.index = index;
        this.number = number;
    }

    public boolean isStrike(Ball ball) {
        return index == ball.index
                && number == ball.number;
    }

    public boolean isBall(Ball ball) {
        return index != ball.index
                && number == ball.number;
    }

    public boolean isNothing(Ball ball) {
        return !isStrike(ball) && !isBall(ball);
    }

}
