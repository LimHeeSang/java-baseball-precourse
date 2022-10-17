package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer extends Player {

    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 9;
    public static final int COUNT = 3;

    public Computer() {
        super(Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT));
    }
}
