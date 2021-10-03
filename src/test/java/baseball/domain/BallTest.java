package baseball.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class BallTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9})
    void 야구공_생성(int number) {
        Ball ball = new Ball(number);

        assertThat(ball).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void 야구공_잘못된_숫자_예외(int number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ball(number));
    }
}
