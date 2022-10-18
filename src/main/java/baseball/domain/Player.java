package baseball.domain;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Player {

    private final List<Ball> balls;

    public Player(List<Integer> numbers) {
        AtomicInteger index = new AtomicInteger();
        balls = numbers.stream()
                .map(integer -> new Ball(index.getAndIncrement(), integer))
                .collect(Collectors.toList());
    }

    public Ball throwRoundBall(int roundNumber) {
        return balls.get(roundNumber);
    }
}
