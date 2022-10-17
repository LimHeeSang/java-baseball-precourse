package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Pattern;

public class PatternTest {

    @DisplayName("정상 입력 테스트")
    @Test
    void patternTest() {
        boolean result = Pattern.matches("^[1-9]{3}$", "123");
        Assertions.assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "013", "abc"})
    void patternTest2() {
        boolean result = Pattern.matches("^[1-9]{3}$", "1234");
        Assertions.assertThat(result).isFalse();
    }
}
