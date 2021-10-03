package baseball.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class BallTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9})
    void 야구공_생성(int number) {
        Ball ball = new Ball(number);

        assertThat(ball).isNotNull();
    }

    @Test
    void 야구공_랜덤생성() {
        Ball ball = Ball.of();

        assertThat(ball).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void 야구공_잘못된_숫자_예외(int number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ball(number));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1:true", "2:1:false", "2:2:true", "5:9:false"}, delimiter = ':')
    void 야구공_비교확인(int number1, int number2, boolean result) {
        Ball ball1 = new Ball(number1);
        Ball ball2 = new Ball(number2);

        assertThat(ball1.equals(ball2)).isEqualTo(result);
    }
}
