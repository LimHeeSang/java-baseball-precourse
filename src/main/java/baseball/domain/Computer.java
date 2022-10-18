package baseball.domain;

public class Computer extends Player {

    public Computer() {
        super(RandomNumberFactory.createRandomNumbers());
    }
}
