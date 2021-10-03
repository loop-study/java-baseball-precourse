package baseball.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class BallTest {

    @Test
    void 야구공_생성() {
        Ball ball = new Ball(1);

        assertThat(ball).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void 야구공_잘못된_숫자_예외(int number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ball(number));
    }
}
